package com.rubix.mongo.controller;


import java.util.List;


//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rubix.mongo.service.SequenceGeneratorService;

import com.rubix.mongo.exception.ResourceNotFoundException;
import com.rubix.mongo.model.Currency;
import com.rubix.mongo.model.CurrencyDAL;
import com.rubix.mongo.model.Employee;
import com.rubix.mongo.repository.ExpenseRepository;
import com.rubix.mongo.repository.CurrencyRepository;




//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class CurrencyController {

  @Autowired
  private CurrencyRepository currencyRepository;

  @Autowired
  private ExpenseRepository expenseRepository;
  
  @Autowired
  private SequenceGeneratorService sequenceGeneratorService;
  
  private  CurrencyDAL CurrencyDAL;
  @GetMapping("/curr")
	public List<Currency> getAllCurrency() {
		return currencyRepository.findAll();
	}

 /* @GetMapping("/currency/{employeeId}")
  public Page<ExpenseCurrency> getAllExpenseCurrencyByEmployeeId(@PathVariable (value = "employeeId") Long employeeId,
                                              Pageable pageable) {
  	
  	
      return expensecurrencyRepository.findByEmployeeId(employeeId, pageable);
  }*/
  
  @GetMapping("/curr/{id}")
  public List <Currency> getCurrencyById(@PathVariable(value = "id") Long expenseId) {
	  
			return CurrencyDAL.getCurrencyByExpenseId(expenseId);
  }

 
  
  @PostMapping("/curr/{id}")
  public  ResponseEntity<String> createCurrency(@PathVariable(value = "id") long ExpenseId,
      /*@Valid*/ @RequestBody Currency currency) throws ResourceNotFoundException,Exception{
	  //Code to restrict the count of EmployeeId
	  /*List<Expense> exp = expenseRepo. findByUserId(UserId);
	 
	  long count = exp.size();
	  	if(count > 2  ){
	  		
	  		throw new Exception("EmployeeId cant exceed");
	  	}*/
  	
  	
    String tempname=currency.getCode(); 
    currency.setId(sequenceGeneratorService.generateSequence(Employee.SEQUENCE_NAME));
		
  Currency expen= currencyRepository.findByCodeAndExpenseId(tempname,ExpenseId) ;
	
		
		if(expen!=null){throw new Exception("Currency already exists");}
		
	    if(tempname.equals("usd")) {
	    	currency.setCurrency("US Dollar");
	    }else  if(tempname.equals("aud")) {
	    	currency.setCurrency("Australian Dollar");
	    }else  if(tempname.equals("inr")) {
	    	currency.setCurrency("Indian Rupees");
	    }
	    
	  
      return  expenseRepository.findById(ExpenseId).map(expense -> {
      	
    	  currency.setExpense(expense);
         
          
    	  
    	  currencyRepository.save(currency);
    	  return ResponseEntity.ok("Currrency added Successfully");
          
      }).orElseThrow(() -> new ResourceNotFoundException("Currency not found"));
   
		
  }
		 
 /* @PutMapping("/curr/{id}/{exp}")
  public Currency updateCurrency(@PathVariable(value = "id")  long ExpenseId,
      @PathVariable(value = "exp") long currencyId,/*@Valid @RequestBody Currency currency)
  throws ResourceNotFoundException{
      if (! expenseRepository.existsById( ExpenseId)) {
          throw new ResourceNotFoundException("Expense Id not found");
      }

      return currencyRepository.findById(currencyId).map(expens -> {
    	  currency.setCurrency(currency.getCurrency());
    	  currency.setCode(currency.getCode());
      	 
          return currencyRepository.save(currency);
      }).orElseThrow(() -> new ResourceNotFoundException("Currency  id not found"));
  }*/
  
  @PutMapping("/curr/{id}/{exp}")
  public ResponseEntity<String> updateCurrency(@PathVariable(value = "id")  long ExpenseId,
      @PathVariable(value = "exp") long currencyId,/*@Valid*/ @RequestBody  Currency currency)
  throws ResourceNotFoundException,Exception{
	  
      if (!expenseRepository.existsById( ExpenseId)) {
          throw new ResourceNotFoundException("UserId not found");
      	}
      Currency  curren =   currencyRepository.findById(currencyId)
              .orElseThrow(() -> new ResourceNotFoundException("Expenseid not found for this id :: " + currencyId));
      String tempname=currency.getCode(); 
      Currency  expene= currencyRepository.findByCodeAndExpenseId(tempname,ExpenseId) ;
		
		
		if(expene!=null){throw new Exception("Curreency code already exists");}
		
					curren.setCode(currency.getCode());
					
					if(tempname.equals("usd")) {
					    	curren.setCurrency("US Dollar");
					    }else  if(tempname.equals("aud")) {
					    	curren.setCurrency("Australian Dollar");
					    }else  if(tempname.equals("inr")) {
					    	curren.setCurrency("Indian Rupees");
					    }
  		
			 
  	
					 currencyRepository.save(curren);
				        return ResponseEntity.ok("Currrency Updated Successfully");
  }

  @DeleteMapping("/curr/{Id}/{currencyId}")
  public ResponseEntity<?> deleteCurrency(@PathVariable (value = "Id") Long ExpenseId,
                            @PathVariable (value = "currencyId") Long currencyId) throws ResourceNotFoundException {
      return currencyRepository.findByIdAndExpenseId(currencyId, ExpenseId).map(currency -> {
      	currencyRepository.delete(currency);
          return ResponseEntity.ok().build();
      }).orElseThrow(() -> new ResourceNotFoundException("ExpenseCurrency not found with id " + currencyId + " and ExpenseId " + ExpenseId));
  }
}