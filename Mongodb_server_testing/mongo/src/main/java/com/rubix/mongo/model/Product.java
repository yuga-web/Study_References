package com.rubix.mongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "Product")
public class Product {
		
	
	@Transient
    public static final String SEQUENCE_NAME = "users_sequence";

    @Id
	  private Long productId;
	  private String code;
	  private String name;
	  private String details;
	  
	  public Product(Long productId,String code, String name, String details){
	    this.productId=productId;
		this.code = code;
	    this.name = name;
	    this.details = details;
	  }
	  
	  
	  
	  public Long getProductId() {
		return productId;
	}



	public void setProductId(Long productId) {
		this.productId = productId;
	}



	public void setCode(String code){
	    this.code = code;
	  }
	  
	  public String getCode(){
	    return this.code;
	  }
	  
	  public void setName(String name){
	    this.name = name;
	  }
	  
	  public String getName(){
	    return this.name;
	  }
	  
	  public void setDetails(String details){
	    this.details = details;
	  }
	  
	  public String getDetails(){
	    return this.details;
	  }
	}
