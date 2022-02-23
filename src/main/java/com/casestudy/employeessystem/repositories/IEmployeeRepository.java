package com.casestudy.employeessystem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.casestudy.employeessystem.models.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

	// CRUDRepository executes the SQL statements
	// JpaRepository can create the DAO implementation
	
	//find an employee by first name, last name, position or by their combination
	@Query(value = "SELECT * FROM Employee "
			+ "WHERE ( firstName = :firstName OR :firstName = '' ) "
			+ "AND ( lastName = :lastName OR :lastName = '' ) "
			+ "AND ( position = :position OR :position = '' ) "
			+ "AND ", nativeQuery = true)
	List<Employee> findEmployee(@Param("firstName") String fname, @Param("lastName") String lname, @Param("position") String pos);
	
}
