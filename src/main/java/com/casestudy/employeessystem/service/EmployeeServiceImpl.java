package com.casestudy.employeessystem.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

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
		return repo.findEmployee(fname, lname, pos);
	}

	public Boolean exists(Employee empl) {
		//get new employee data
		String fname = empl.getFirstName();
		String mname = empl.getMiddleName();
		String lname = empl.getLastName();
		Date bday = empl.getBirthDate();
		
		Employee existedEmployee = (Employee) repo.findEmployeeByFirstNameAndMiddleNameAndLastNameAndBirthDate(fname, mname, lname, bday);
		
		if(existedEmployee != null) {
			System.out.println("ERROR, EMPLOYEE ALREADY EXISTS");
			return true;
		}
		else
			return false;
	}

}
