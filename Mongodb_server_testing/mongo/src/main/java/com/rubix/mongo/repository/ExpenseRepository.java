package com.rubix.mongo.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import com.rubix.mongo.model.Expense;


@Repository
  public interface ExpenseRepository extends MongoRepository<Expense, Long>{

}
