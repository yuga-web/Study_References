package com.oril.paypal.service.impl;

import com.oril.paypal.model.PayPalResponseDTO;
import com.oril.paypal.service.PayPalService;
import com.paypal.api.payments.*;
import com.paypal.base.rest.APIContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class PayPalServiceImpl implements PayPalService {

    private final static Logger logger = LoggerFactory.getLogger(PayPalServiceImpl.class);

    private static final String APPROVAL_URL = "approval_url";
    private static final String PAYMENT_INTENT = "sale";
    private static final String CURRENCY = "USD";
    private static final String PAYMENT_METHOD = "paypal";
    private APIContext context;

    @Value("${serverUrl}")
    private String serverUrl;

    @Value("${paypal.clientId}")
    private String clientId;

    @Value("${paypal.clientSecret}")
    private String clientSecret;

    @Value("${paypal.environmentMode}")
    private String environmentMode;

    @PostConstruct
    public void init() {
        context = new APIContext(clientId, clientSecret, environmentMode);
    }

    @Override
    public String createPayment(Double price) {
        // Set payer details
        Payer payer = new Payer();
        payer.setPaymentMethod(PAYMENT_METHOD);
        // Set redirect URLs
        // (It will be called by PayPal after transaction submit or cancel)
        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl(serverUrl + "/payments/paypal/cancel");
        redirectUrls.setReturnUrl(serverUrl + "/payments/paypal/success");
        // Payment amount
        Amount amount = new Amount();
        amount.setCurrency(CURRENCY);
        amount.setTotal(price.toString());
        // Transaction information
        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setDescription("Test Description");
        // Add transaction to a list
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction);
        // Add payment details
        Payment payment = new Payment();
        payment.setIntent(PAYMENT_INTENT);
        payment.setPayer(payer);
        payment.setRedirectUrls(redirectUrls);
        payment.setTransactions(transactions);
        // Create payment
        try {
            payment = payment.create(context);
            for (Links link : payment.getLinks()) {
                if (link.getRel().equalsIgnoreCase(APPROVAL_URL)) {
                    return link.getHref();
                }
            }
            throw new RuntimeException("Error while processing transaction");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    @Override
    public Payment executePayment(String paymentId, String payerId) {
        Payment payment = new Payment();
        payment.setId(paymentId);
        PaymentExecution paymentExecution = new PaymentExecution();
        paymentExecution.setPayerId(payerId);

        try {
            return payment.execute(context, paymentExecution);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }
}
