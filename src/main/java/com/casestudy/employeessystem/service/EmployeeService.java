package com.casestudy.employeessystem.service;

import java.sql.Date;
import java.util.List;

import com.casestudy.employeessystem.models.Employee;

public interface EmployeeService {
	
	public List<Employee> listAllEmployees();
	public Employee saveEmployees(Employee employee);
	public Employee getEmployeeById(int uid);
	public Employee updateEmployee(Employee employee);
	public List<Employee> findEmployee(String fisrtName, String lastName, String position);
	public Boolean exists(Employee empl);

}
