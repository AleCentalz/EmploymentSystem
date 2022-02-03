package com.casestudy.employeessystem.repositories;

import org.springframework.data.repository.CrudRepository;

import com.casestudy.employeessystem.models.Employee;

public interface IEmployeeRepo extends CrudRepository<Employee, Integer> {

	//CRUDRepository executes the SQL statements
}
