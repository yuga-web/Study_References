package com.rubix.mongo.model;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Document(collection = "currency")

public class Currency {
	
	
	@Transient
    public static final String SEQUENCE_NAME = "users_sequence";
	public Currency() {

	}

	public Currency(long id, String currency, String code,Expense expense) {
		super();
		this.id = id;
		this.currency = currency;
		this.code = code;
		this.expense=expense;
	}

	@Id
	
	private long id;

	private String currency;

	private String code;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	// @ManyToOne(cascade = CascadeType.ALL)
	@DBRef

	private Expense expense;
	// @JsonBackReference

	/*
	 * public Employee getEmployee() { return employee; } public void
	 * setEmployee(Employee employee) { this.employee = employee; }
	 */

	

	

	
	/**
	 * @return the expense
	 */
	

	public long getId() {
		return id;
	}

	

	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the expense
	 */
	public Expense getExpense() {
		return expense;
	}

	/**
	 * @param expense the expense to set
	 */
	public void setExpense(Expense expense) {
		this.expense = expense;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the userIden
	 */
	@Override
	public String toString() {
		return "Currency [id=" + id + ", currency=" + currency + ", code=" + code + "]";
	}

}
