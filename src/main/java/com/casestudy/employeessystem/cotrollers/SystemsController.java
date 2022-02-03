package com.casestudy.employeessystem.cotrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.casestudy.employeessystem.models.Employee;
import com.casestudy.employeessystem.repositories.IEmployeeRepo;

@Controller
public class SystemsController {
	
	@Autowired
	private IEmployeeRepo repo;
	
	@GetMapping("/")
	public String welcome() {
		return "index";
	}
	
	@GetMapping("/addEmployee")
	public String addEmpl() {
		return "addEmployee";
	}
	
	@GetMapping("/all")
	public List<Employee> getAll(){
		return (List<Employee>) repo.findAll();
	}
	
	@GetMapping("/searchEmployee")
	public String searchEmpl() {
		return "searchEmployee";
	}
	
	@PostMapping("/addEmployee")
	public String addNewEmployee() {
		return "";
	}
	

}
