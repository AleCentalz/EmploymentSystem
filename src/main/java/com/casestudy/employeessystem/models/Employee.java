package com.casestudy.employeessystem.models;


import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uid;
	@Column(name = "firstname", nullable = false, length = 45) //name always in lower case!!!
	private String firstName;
	@Column(name = "middlename", nullable = true, length = 45)
	private String middleName;
	@Column(name = "lastname", nullable = false, length = 45)
	private String lastName;
	@Column(name = "position", nullable = false, length = 45)
	private String position;
	@Column(name = "birthdate", nullable = false, length = 45)
	private Date birthDate;
    @OneToMany(mappedBy = "idEmployee", fetch = FetchType.LAZY, cascade = CascadeType.ALL) //foreing key
    private Set<Compensation> compensations;

    //constructors
    public Employee()
    {
    	
    }
    
    public Employee(int uid, String firstName, String middleName, String lastName, String position, Date birthDate,
			Set<Compensation> compensations) {
		super();
		this.uid = uid;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.position = position;
		this.birthDate = birthDate;
		this.compensations = compensations;
	}


	// getters and setters
	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Set<Compensation> getCompensations() {
		return compensations;
	}

	public void setCompensations(Set<Compensation> compensations) {
		this.compensations = compensations;
	}

	@Override
	public String toString() {
		return "Employee [uid=" + uid + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", position=" + position + ", birthDate=" + birthDate + "]";
	}

	/*
	 * LocalDate date = LocalDate.now(); DateTimeFormatter formatter =
	 * DateTimeFormatter.ofPattern("dd MM yyyy"); birthDate =
	 * date.format(formatter); LocalDate parsedDate = LocalDate.parse(birthDate,
	 * formatter);
	 */

}
