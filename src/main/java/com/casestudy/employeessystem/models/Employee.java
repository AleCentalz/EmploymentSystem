package com.casestudy.employeessystem.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uid;
	@Column(name = "first_name", nullable = false, length = 45)
	private String firstName;
	@Column(name = "middle_name", nullable = true, length = 45)
	private String middleName;
	@Column(name = "last_name", nullable = false, length = 45)
	private String lastName;
	@Column(name = "position", nullable = false, length = 45)
	private String position;
	@Column(name = "birth_date", nullable = false, length = 45)
	private String birthDate;


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

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
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
