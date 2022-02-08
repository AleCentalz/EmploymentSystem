package com.casestudy.employeessystem.cotrollers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.casestudy.employeessystem.models.Employee;
import com.casestudy.employeessystem.repositories.IEmployeeRepository;
import com.casestudy.employeessystem.service.EmployeeService;

@Controller
public class SystemsController {
	
	@Autowired
	private IEmployeeRepository repo; //dependency injection
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/") //home page
	public String welcome() {
		return "welcome";
	}
	
	@GetMapping("/add_form") //add an employee
	public String addEmpl() {
		return "add_employee";
	}
	
	@GetMapping("/all")
	public List<Employee> getAll(){
		return (List<Employee>) repo.findAll();
	}
	
	@GetMapping("/search")
	public String searchEmpl() {
		return "search";
	}
	
	@GetMapping("/employees")
	public String listEmployees(Model model) {
		try {
			model.addAttribute("employees", service.listAllEmployees());		
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		
		return "employees";
	}
	
	@PostMapping("/add_employee")
	public String addNewEmployee(@Valid Employee empl, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "add_employee";
		}
		this.repo.save(empl);
		return "redirect:/";
	}
	

}
