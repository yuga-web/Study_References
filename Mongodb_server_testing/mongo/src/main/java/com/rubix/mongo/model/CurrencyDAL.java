package com.rubix.mongo.model;

import java.util.List;
import com.rubix.mongo.model.Currency;
public interface CurrencyDAL {
	List<Currency>  getCurrencyByExpenseId(Long expenseId);

}
