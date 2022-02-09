package com.casestudy.employeessystem.service;

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
	public List<Employee> findEmployee(String fisrtName, String lastName, String position) {
		return repo.findByFirstNameOrLastNameOrPosition(fisrtName, lastName, position);
	}

}
