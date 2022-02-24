package com.casestudy.employeessystem.models;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee {

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
