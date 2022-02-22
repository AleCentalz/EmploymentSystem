package com.casestudy.employeessystem;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.casestudy.employeessystem.models.Employee;
import com.casestudy.employeessystem.repositories.IEmployeeRepository;

@SpringBootTest
class EmployeessystemApplicationTests {
	
	@Autowired
	ApplicationContext context; 

	//Test to try upload information to the DB 
	@Test
	public void contextLoads() {
		IEmployeeRepository repo = context.getBean(IEmployeeRepository.class);
		
		  
		//Employee employee = new Employee();
		//employee.setUid(1); //this should do it the DB 
		//employee.setFirstName("Raul");
		//employee.setMiddleName("Manuel");
		//employee.setLastName("Mancilla");
		//employee.setBirthDate(Date.parse("17/02/1987")); //this has to be a datetime type
		//employee.setPosition("Employee");
		//repo.save(employee); //* CREATE *
		
		// * READ *
		// I should read by first name, last name or position ... or a combination of them
		/*List<Employee> result = repo.findByFirstNameOrLastNameOrPosition("Alejandra","Centeno",""); //search by name, last name or position
		if(result.isEmpty()) 
			System.out.println("Employee not found"); //check to prevent a null pointer
		else
			System.out.println(result);*/
		
		// * UPDATE * 
		//Optional<Employee> result = repo.findById(3); //search by id
		//employee = result.get();
		//employee.setFirstName("Alejandra");
		//repo.save(employee);
		
		// * READ ALL *
		repo.findAll().forEach(p->{System.out.println(p.getFirstName());}); //lamda expression
		//repo.findByFirstNameOrLastNameOrPosition("", "", "Employee");
		
		// * DELETE * this will delete the user #3 
		//if(result.isPresent()) {
			//employee = result.get();
			//repo.delete(employee);
			//System.out.println(employee.getFirstName() + "deleted");
		//}
		//else
			//System.out.println("Employee not found");
		
	}
	

}
