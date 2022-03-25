package com.casestudy.employeessystem.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.employeessystem.models.Employee;
import com.casestudy.employeessystem.repositories.IEmployeeRepository;

@Service
public class EmployeeServiceImpl{
	
	@Autowired
	private IEmployeeRepository repo;
	
	public List<Employee> listAllEmployees() {
		return repo.findAll();
	}

	public Employee saveEmployees(Employee employee) {
		return repo.save(employee);
	}

	public Employee updateEmployee(Employee employee) {
		return repo.save(employee);
	}

	public Employee getEmployeeById(int uid) {
		return repo.getById(uid);
	}

	public List<Employee> findEmployee(String fname, String lname, String pos) {
		List<Employee> employees = repo.findEmployee(fname, lname, pos);
		if(employees != null && employees.isEmpty()) {
			System.out.println("0 results");
		}
		return employees;
	}

	public Boolean exists(Employee empl) {
		//get new employee data
		//int uid = empl.getUid();
		String fname = empl.getFirstName();
		String mname = empl.getMiddleName();
		String lname = empl.getLastName();
		Date bday = empl.getBirthDate();
		
		Employee existedEmployee = (Employee) repo.findEmployeeByFirstNameAndMiddleNameAndLastNameAndBirthDate(fname, mname, lname, bday);
		//int existedUid = existedEmployee.getUid();
		
		if(existedEmployee != null) {
			System.out.println("ERROR, EMPLOYEE ALREADY EXISTS");
			return true;
		}
		else
			return false;
	}
	
	
	public Boolean isValidBirthDate(Date bday) {
		//convert Date.sql to util.Date
		java.util.Date bdayUtilDate = new java.util.Date(bday.getTime());
		// get actual date
		LocalDateTime dateTime = LocalDateTime.now();
		// obtain minimum date
		LocalDateTime oldDate = dateTime.minusYears(21);
		java.util.Date c2 = oldDate.toDateTime().toDate();
		//compare
		if(bdayUtilDate.before(c2)) {
			return true;
		}else
			return false;
	}

}
