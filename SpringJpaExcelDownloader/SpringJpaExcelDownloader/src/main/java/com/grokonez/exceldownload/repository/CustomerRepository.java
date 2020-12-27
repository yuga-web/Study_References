package com.grokonez.exceldownload.repository;

import org.springframework.data.repository.CrudRepository;

import com.grokonez.exceldownload.model.Customer;
 
public interface CustomerRepository extends CrudRepository<Customer, Long>{
}
