package net.java.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
@Entity
@Table(name = "utility")
public class Utility {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	
	private long id;
	@Column(name="date")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date date;
	@Column(name="ExpenseName")
	private String ExpenseName;
	@Column(name="Description")
	private String Description;
	@Column(name="amount")
	private float amount;
	
	public Utility(){
		
	}
	
	
	
	
	public Utility(Date date, String expenseName, String description, float amount) {
		super();
		date = date;
		ExpenseName = expenseName;
		Description = description;
		this.amount = amount;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getExpenseName() {
		return ExpenseName;
	}
	public void setExpenseName(String expenseName) {
		ExpenseName = expenseName;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	

}
