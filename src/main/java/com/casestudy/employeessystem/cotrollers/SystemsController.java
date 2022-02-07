package com.casestudy.employeessystem.cotrollers;

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

@Controller
public class SystemsController {
	
	@Autowired
	private IEmployeeRepository repo; //dependency injection
	
	@GetMapping("/") //home page
	public String welcome() {
		return "index";
	}
	
	@GetMapping("/addEmployee") //add an employee
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
	public String addNewEmployee(@Valid Employee empl, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "addEmployee";
		}
		this.repo.save(empl);
		return "index";
	}
	

}
