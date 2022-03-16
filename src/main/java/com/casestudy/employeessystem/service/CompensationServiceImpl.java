package com.casestudy.employeessystem.service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

	// Find the compensations of X employee
	public List<Compensation> findCompensationsByEmployeeId(int idEmployee) {
		return repo.findCompensationsByEmployeeId(idEmployee);
	}

	// Get the total of all the compensations of X employee
	public Float getTotal(int idEmployee) {
		return repo.getTotal(idEmployee);
	}

	// Find the compensations by a range of dates
	public List<Compensation> findCompensationsByDates(String sDate, String eDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");

		java.util.Date date1 = sdf.parse(sDate);
		java.util.Date date2 = sdf.parse(eDate);
		java.sql.Date startDate = new Date(date1.getTime());
		java.sql.Date endDate = new Date(date2.getTime());
		System.out.println(endDate);
		System.out.println(startDate);

		// review dates entries to avoid errors
		return repo.findCompensationByDate(startDate, endDate);
	}

	// Find the compensations by X Month
	public List<Compensation> findCompensationsByMonthname(int idEmployee, String month, int year) {
		return repo.findByMonth(idEmployee, month, year);
	}

}
