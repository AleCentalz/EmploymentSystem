package com.casestudy.employeessystem.cotrollers;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.casestudy.employeessystem.models.Compensation;
import com.casestudy.employeessystem.models.Employee;
import com.casestudy.employeessystem.models.User;
import com.casestudy.employeessystem.repositories.IUserRepository;
import com.casestudy.employeessystem.service.CompensationServiceImpl;
import com.casestudy.employeessystem.service.CustomUserDetailsService;
import com.casestudy.employeessystem.service.EmployeeServiceImpl;

@Controller
public class SystemsController {

	@Autowired
	private IUserRepository userRepo;
	@Autowired
	private CompensationServiceImpl compService;
	@Autowired
	private CustomUserDetailsService userService;
	@Autowired
	private EmployeeServiceImpl emplService;

	// ________index page______________
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
	public String processRegistration(@Valid User user) {
		//email verification
		if(userService.patternMatches(user.getEmail(),"^(.+)@ibm.com$")) { 
			//correct
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String encodedPassword = passwordEncoder.encode(user.getPassword());
			user.setPassword(encodedPassword);
			userRepo.save(user);

			return "sucessful_registration";
		}else {
			//its not an IBM email
			return "redirect:/register?invalid";
		}
	}
	

	// ________welcome page______________
	@GetMapping("/welcome")
	public String welcome() {
		return "welcome";
	}
	

	// ________add an employee form_____________
	@GetMapping("/employee/add")
	public String addEmplForm(Model model) {
		Employee empl = new Employee();
		model.addAttribute(empl);
		return "add_employee";
	}
	// ________save the employee________________
	@PostMapping("/employee")
	public String addNewEmployee(@ModelAttribute("employee") @Valid Employee empl) {
		// get the birth date and check it
		Date birthDate = empl.getBirthDate();

		if (emplService.isValidBirthDate(birthDate)) {
			if (emplService.exists(empl) != true) { // successfully added
				emplService.saveEmployees(empl);
				return "redirect:/welcome?success";
			} else // error, employee already exists
				return "redirect:/welcome?duplicate";
		} else // wrong date
			return "redirect:/welcome?invalid";
	}
	

	// _______search form________________________
	@GetMapping("/search/form")
	public String searchForm() {
		return "search";
	}
	// _______search the employee___________
	@RequestMapping(value="/search", method = RequestMethod.GET)
	public String searchEmpl(Model model, String fname, String lname, String pos, RedirectAttributes redirAttrs) {
		List<Employee> list = emplService.findEmployee(fname, lname, pos);
		if (list != null && list.isEmpty()) {
			redirAttrs.addFlashAttribute("empty", "0 results found.");
			return "redirect:/welcome";
		} else {
			model.addAttribute("list", list);
			return "search";
		}

	}
	

	// _______edit employee______________
	@GetMapping("/employee/{uid}/edit")
	public String editEmployeeForm(@PathVariable int uid, Model model) { // receive the uid to get its info
		model.addAttribute("employee", emplService.getEmployeeById(uid));
		return "edit_employee";
	}
	// _______update info employee________
	@PostMapping("/employee/{uid}")
	public String updateEmployee(@PathVariable int uid, @ModelAttribute("employee") Employee employee, Model model) {
		// check birth date
		Date bday = employee.getBirthDate();
		Employee existingEmpl = emplService.getEmployeeById(uid);

		if (emplService.isValidBirthDate(bday)) {
			if (emplService.exists(employee) != true) { //successfully added
				existingEmpl.setUid(employee.getUid());
				existingEmpl.setFirstName(employee.getFirstName()); // from the employee in the form, assign the data
				existingEmpl.setLastName(employee.getLastName());
				existingEmpl.setMiddleName(employee.getMiddleName());
				existingEmpl.setPosition(employee.getPosition());
				existingEmpl.setBirthDate(bday);

				emplService.updateEmployee(existingEmpl);
				return "redirect:/search/form?success";
			}
			else { //error, that employee already exists
				return "redirect:/search/form?duplicate";
			}
		}
		else { //invalid birth date
			return "redirect:/search/form?invalid";
		}

	}

	
	// ________view employee's compensation history_______
	@RequestMapping(value = "/employee/{uid}/view_compensation", method = RequestMethod.GET)
	public String viewCompensation(@PathVariable int uid, Model model) {
		model.addAttribute("employee", emplService.getEmployeeById(uid));
		List<Compensation> compensations = compService.findCompensationsByEmployeeId(uid); // obtain all compensations																			// each compensation
		Float total = compService.getTotal(uid); //get total
		model.addAttribute("listComp", compensations);
		model.addAttribute("total", total);
		return "compensation_history";
	}
	//________view employee's compensation details by month______
	@RequestMapping(value="/employee/{uid}/view_details/{month}", method = RequestMethod.GET)
	public String viewDetails(@PathVariable int uid, @PathVariable String month, @PathVariable int year, Model model) {
		model.addAttribute("employee", emplService.getEmployeeById(uid));
		List<Compensation> compensations = compService.findCompensationsByMonthname(month, uid, year);
		model.addAttribute("list", compensations);
		model.addAttribute("month", month);
		return "compensation_details";
	}
	
	//__________search compensations by date ____________
	@GetMapping("/employee/{uid}/view_compensation/dates")
	public String viewCompensationsByDate(Model model, String sDate, String eDate, @PathVariable int uid) throws ParseException{
		model.addAttribute("employee", emplService.getEmployeeById(uid));
		List<Compensation> compensations = compService.findCompensationsByDates(sDate, eDate);
		System.out.println(compensations.get(1));
		model.addAttribute("listComp", compensations);
		return "compensation_history";
	}
	
	// ________new compensation form_________________
	@RequestMapping(value = "/employee/{uid}/new_compensation", method = RequestMethod.GET)
	public ModelAndView compensationForm(@PathVariable int uid) {
		ModelAndView model = new ModelAndView("add_compensation");
		model.addObject("employee", emplService.getEmployeeById(uid));
		Compensation comp = new Compensation();
		model.addObject(comp);
		return model;
	}
	// ________add a new compensation__________________
	@PostMapping("/employee/{uid}/add_newcompensation")
	public String addCompensation(@ModelAttribute("compensation") @Valid Compensation comp, @PathVariable("uid") int uid) {
		Employee emp = emplService.getEmployeeById(uid);
		comp.setIdEmployee(emp);
		compService.saveCompensation(comp);
		return "redirect:/employee/{uid}/view_compensation?success";
	}

	// DB error
	@ExceptionHandler({ SQLException.class, DataAccessException.class })
	public String databaseError() {
		return "error";
	}

}
