package com.rubix.mongo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.rubix.mongo.model.Employee;
import com.rubix.mongo.model.Expense;
import com.rubix.mongo.repository.ExpenseRepository;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class ExpenseController {
	@Autowired
	private ExpenseRepository expenseRepository;

	 @Autowired
	    private SequenceGeneratorService sequenceGeneratorService;
	 
	@GetMapping("/expense")
	public List<Expense> getAllExpense() {
		return  expenseRepository.findAll();
	}

	@GetMapping("/expense/{id}")
	public ResponseEntity<Expense> getExpenseById(@PathVariable(value = "id") Long ExpenseId)
			throws ResourceNotFoundException {
		Expense employee =  expenseRepository.findById(ExpenseId)
				.orElseThrow(() -> new ResourceNotFoundException("Expense details not  found for this id :: " + ExpenseId));
		return ResponseEntity.ok().body(employee);
	}

	@PostMapping("/expense")
	public ResponseEntity<Object> createExpense(/*@Valid*/ @RequestBody Expense  expense) {
		System.out.println("expense.getAmount()" +  expense.getAmount());
		expense.setId(sequenceGeneratorService.generateSequence(Employee.SEQUENCE_NAME));
		 expenseRepository.save( expense);
		 return ResponseEntity.ok("Expense Created Successfully");
		 }

	@PutMapping("/expense/{id}")
	public ResponseEntity<Object>  updateExpense(@PathVariable(value = "id") Long expenseId,
			/*@Valid*/ @RequestBody Expense  expenseDetails) throws ResourceNotFoundException {
		 Expense expense =  expenseRepository.findById( expenseId)
				.orElseThrow(() -> new ResourceNotFoundException("Expense details  not found for this id :: " +  expenseId));

		
		 expense.setName( expenseDetails.getName());
		 expense.setQuantity( expenseDetails.getQuantity());
		 expense.setTax( expenseDetails.getTax());
		 expense.setPrice( expenseDetails.getPrice());
		 expense.setAmount( expenseDetails.getAmount());
		 expense.setTotal( expenseDetails.getTotal());
		// expense.setPurchase_date( expenseDetails.getPurchase_date());
		 expense.setCreated_by( expenseDetails.getCreated_by());
		 expense.setUpdated_by( expenseDetails.getUpdated_by());
		 expenseRepository.save( expense);
			return ResponseEntity.ok("Expense Updated Successfully");
	}

	@DeleteMapping("/expense/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id")Long  expenseId)
			throws ResourceNotFoundException {
		Expense employee =  expenseRepository.findById(expenseId)
				.orElseThrow(() -> new ResourceNotFoundException("Expense details not found for this id :: " +expenseId));

		 expenseRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}