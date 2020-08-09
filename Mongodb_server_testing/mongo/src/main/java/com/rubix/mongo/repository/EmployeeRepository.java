package com.rubix.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.Query;
import java.util.List;

import com.rubix.mongo.model.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Long>{
	 @Query("{'product.code': ?0}")
	  List<Employee> findByCode(String code);

}