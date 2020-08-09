package com.rubix.mongo.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.data.mongodb.repository.Query;
//import java.util.List;

import com.rubix.mongo.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, Long>{
	 

}