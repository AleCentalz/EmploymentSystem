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
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private IEmployeeRepository repo;
	
	@Override
	public List<Employee> listAllEmployees() {
		return repo.findAll();
	}

	@Override
	public Employee saveEmployees(Employee employee) {
		return repo.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return repo.save(employee);
	}

	@Override
	public Employee getEmployeeById(int uid) {
		return repo.getById(uid);
	}

	@Override
	public List<Employee> findEmployee(String fname, String lname, String pos) {
		return repo.findEmployee(fname, lname, pos);
	}

	@Override
	public Boolean exists(Employee empl) {
		//get new employee data
		String fname = empl.getFirstName();
		System.out.println(fname);
		String mname = empl.getMiddleName();
		System.out.println(mname);
		String lname = empl.getLastName();
		System.out.println(lname);
		Date bday = empl.getBirthDate();
		System.out.println(bday);
		
		Employee existedEmployee = (Employee) repo.findEmployeeByFirstNameAndMiddleNameAndLastNameAndBirthDate(fname, mname, lname, bday);
		
		if(existedEmployee != null) {
			System.out.println("ERROR, EMPLOYEE ALREADY EXISTS");
			return true;
		}
		else
			return false;
	}

}
