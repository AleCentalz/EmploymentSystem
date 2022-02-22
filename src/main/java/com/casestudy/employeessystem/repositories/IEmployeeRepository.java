package com.casestudy.employeessystem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.casestudy.employeessystem.models.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

	//CRUDRepository executes the SQL statements
	//JpaRepository can create the DAO implementation
	/*
	 * @Query(value="SELECT * FFROM Employee e WHERE e.firstname = %?1% " +
	 * " or e.lastname = %?2% " + " or e.position = %?3% " + " and NOT EXISTS;",
	 * nativeQuery=true) List<Employee> findByKeywords(@Param("fname") String
	 * fname, @Param("lname") String lname, @Param("pos") String pos);
	 */
	List<Employee> findByFirstNameOrLastNameOrPosition(String fisrtName, String lastName, String position);
}
