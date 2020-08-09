package com.rubix.mongo.model;

import java.sql.Date;
import java.util.List;



import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Document(collection = "expense")
public class Expense {
	
	
	@Transient
    public static final String SEQUENCE_NAME = "users_sequence";
	
	@Id
	private long id;
	private String name;
    private String quantity;
	private String tax;
	private String price;
	private String amount;
	private String total;
	//private Date purchase_date;
	private String created_by;
	private String updated_by;
	
	 
	/*Date purchase_date*/
	

	public Expense() {
		
	}
	
	public Expense(String name, String quantity, String tax,String price,String amount,String total,String created_by,String updated_by) {
		
		this.name = name;
	    this.quantity = quantity;
		this.tax = tax;
		this.price = price;
		this.amount = amount;
		this.total = total;
		//this.purchase_date = purchase_date;
		this.created_by = created_by;
		this.updated_by = updated_by;
		
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	
	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}
	
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}
	
	/*public Date getPurchase_date() {
		return purchase_date;
	}

	public void setPurchase_date(Date purchase_date) {
		this.purchase_date = purchase_date;
	}*/

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	
	public String getUpdated_by() {
		return updated_by;
	}

	public void setUpdated_by(String updated_by) {
		this.updated_by = updated_by;
	}

	

	@Override
	public String toString() {
		return "Expense [id=" + id + ",name =" + name+ ",quantity=" + quantity + ",tax=" +tax + ",price= " + price + ",amount =" +amount + ", total = "+ total + ",created_by =" +created_by +", updated_by = " +  updated_by  
				+ "]";
	}
	
}