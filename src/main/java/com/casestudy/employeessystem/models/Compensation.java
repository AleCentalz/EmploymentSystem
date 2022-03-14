package com.casestudy.employeessystem.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "Compensation")
public class Compensation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private int id;
	@Column(name = "type", nullable = false)
	private String type;
	@Column(name = "amount", nullable = false)
	private float amount;
	@Column(name = "description", nullable = true)
	private String description;
	@Column(name = "date", nullable = false)
	private Date date; 
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "idemployee", nullable=false)
	private Employee idEmployee;
	
	// constructors
	public Compensation() {
		
	}
	
	public Compensation(int id, String type, float amount, String description, Date date, Employee idEmployee) {
		super();
		this.id = id;
		this.type = type;
		this.amount = amount;
		this.description = description;
		this.date = date;
		this.idEmployee = idEmployee;
	}
	
	//getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Employee getIdEmployee() {
		return idEmployee;
	}
	public void setIdEmployee(Employee idEmployee) {
		this.idEmployee = idEmployee;
	}

	@Override
	public String toString() {
		return "Compensation [id=" + id + ", type=" + type + ", amount=" + amount + ", description=" + description
				+ ", date=" + date + ", idEmployee=" + idEmployee + "]";
	}
	
	

}
