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

}
