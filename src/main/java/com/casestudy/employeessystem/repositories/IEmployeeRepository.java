package com.casestudy.employeessystem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.employeessystem.models.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

	//CRUDRepository executes the SQL statements
	//JpaRepository can create the DAO implementation
	List<Employee> findByFirstName(String firstName);
	List<Employee> findByLastName(String lastName);
	List<Employee> findByPosition(String position);
	List<Employee> findByFirstNameOrLastNameOrPosition(String fisrtName, String lastName, String position);
}
