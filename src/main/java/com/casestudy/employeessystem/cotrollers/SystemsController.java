package com.casestudy.employeessystem.cotrollers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.casestudy.employeessystem.models.Employee;
import com.casestudy.employeessystem.models.User;
import com.casestudy.employeessystem.repositories.IUserRepository;
import com.casestudy.employeessystem.service.EmployeeService;

@Controller
public class SystemsController {
	@Autowired
	private IUserRepository userRepo;

	@Autowired
	private EmployeeService service;
	
	//________index page______________
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	// ________register form______________
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}
	// ________make the registration___________
	@PostMapping("/process_register")
	public String processRegistration(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);

		userRepo.save(user);

		return "sucessful_registration";
	}
	
	// ________welcome page______________
	@GetMapping("/welcome") 
	public String welcome() {
		return "welcome";
	}

	// ________add an employee_______________
	// show the form
	@GetMapping("/employee/add")
	public String addEmplForm(Model model) {
		Employee empl = new Employee();
		model.addAttribute(empl);
		return "add_employee";
	}

	//________save the employee________________
	@PostMapping("/employee")
	public String addNewEmployee(@ModelAttribute("employee") @Valid Employee empl) { // send the employee object
		service.saveEmployees(empl);
		return "redirect:/";
	}

	// _______search the employee___________
	@GetMapping("/search")
	public String searchEmpl() {
		return "search";
	}

	// _______view all the employees________
	@GetMapping("/list")
	public String listEmployees(Model model) {
		try {
			model.addAttribute("employees", service.listAllEmployees()); // employee's list
		}catch(Exception ex) {
			System.out.println(ex);
		}
		
		return "employees";
	}

	// _______edit employee______________
	@GetMapping("/employee/edit/{uid}")
	public String editEmployeeForm(@PathVariable int uid, Model model) { // receive the uid to get its info
		model.addAttribute("employee", service.getEmployeeById(uid));
		return "edit_employee";
	}

	// _______update info employee________
	@PostMapping("/employee/{uid}")
	public String updateEmployee(@PathVariable int uid, @ModelAttribute("employee") Employee employee, Model model) {
		Employee existingEmpl = service.getEmployeeById(uid);
		existingEmpl.setUid(employee.getUid());
		existingEmpl.setFirstName(employee.getFirstName()); // from the employee in the form, assign the data
		existingEmpl.setLastName(employee.getLastName());
		existingEmpl.setMiddleName(employee.getMiddleName());
		existingEmpl.setPosition(employee.getPosition());
		existingEmpl.setBirthDate(employee.getBirthDate());

		service.updateEmployee(existingEmpl);
		return "redirect:/";
	}

}
