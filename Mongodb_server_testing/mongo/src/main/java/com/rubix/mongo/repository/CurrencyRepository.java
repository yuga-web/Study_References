package com.rubix.mongo.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.rubix.mongo.model.Currency;


@Repository
public interface CurrencyRepository extends MongoRepository<Currency, Long> {
	// @Query("{'currency.expense.id': ?0}")
	
    List<Currency> findByExpenseId(Long expenseId);
    Optional<Currency> findByIdAndExpenseId(Long id, Long expenseId);
	Currency findByCodeAndExpenseId(String code, Long expenseId);
}
