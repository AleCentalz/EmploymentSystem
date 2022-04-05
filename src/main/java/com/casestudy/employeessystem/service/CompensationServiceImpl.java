package com.casestudy.employeessystem.service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.employeessystem.models.Compensation;
import com.casestudy.employeessystem.repositories.ICompensationRepository;

@Service
public class CompensationServiceImpl {

	@Autowired
	private ICompensationRepository repo;

	public List<Compensation> listAllCompensations() {
		return repo.findAll();
	}

	public Compensation saveCompensation(Compensation comp) {
		return repo.save(comp);
	}

	public Compensation updateCompensation(Compensation comp) {
		return repo.save(comp);
	}

	public Compensation getCompensation(int id) {
		return repo.getById(id);
	}
	
	//before saving, check if the amount is in the correct ranges
	public boolean checkAmount(Compensation comp) {
		String type = comp.getType();
		double amount = comp.getAmount();

		if(type.equals("Bonus") || type.equals("Commision") || type.equals("Allowance")) {
			if(amount <= 0) 
				return false;
		}else if(type.equals("Adjustment")) {
			if(amount == 0) 
				return false;
		}
		return true;
	}

	// Find the compensations of X employee
	public List<Compensation> findCompensationsByEmployeeId(int idEmployee) {
		List<Compensation> listCompensations = repo.findCompensationsByEmployeeId(idEmployee);
		// List<Compensation> emptylist = new ArrayList<Compensation>();
		return listCompensations;
	}

	// Get the global total of all the compensations of X employee
	public double getGlobalTotal(int idEmployee) {
		double total = 0;
		if (repo.getTotal(idEmployee) != null) {
			total = repo.getTotal(idEmployee);
		}
		return total;

	}

	// Find the compensations by a range of dates
	public List<Compensation> findCompensationsByDates(String sDate, String eDate, int uid) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");

		java.util.Date date1 = sdf.parse(sDate);
		java.util.Date date2 = sdf.parse(eDate);
		java.sql.Date startDate = new Date(date1.getTime());
		java.sql.Date endDate = new Date(date2.getTime());

		// review dates entries to avoid errors
		return repo.findCompensationByDate(startDate, endDate, uid);
	}

	// Find the compensations by X Month
	public List<Compensation> findCompensationsByMonthname(int idEmployee, String month, int year) {
		return repo.findByMonth(idEmployee, month, year);
	}

	// get the total of Y compensations
	public double getTotal(List<Compensation> list) {
		double total = 0;
		if (list != null) {
			Iterator<Compensation> iterator = list.iterator();
			while (iterator.hasNext()) {
				Compensation next = iterator.next(); // iterates every object in the list and sum the amounts
				total += next.getAmount();
			}
		}
		return total;
	}

}
