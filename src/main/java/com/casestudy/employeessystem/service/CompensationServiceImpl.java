package com.casestudy.employeessystem.service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.employeessystem.models.Compensation;
import com.casestudy.employeessystem.repositories.ICompensationRepository;

@Service
public class CompensationServiceImpl  {

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
	
	public List<Compensation> findCompensationsByEmployeeId(int idEmployee){
		return repo.findCompensationsByEmployeeId(idEmployee);
	}

	public List<Compensation> findCompensationsByDates(String sDate, String eDate) throws ParseException{
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");

		 java.util.Date date1 = sdf.parse(sDate);
		 java.util.Date date2 = sdf.parse(eDate);
		 java.sql.Date startDate = new Date(date1.getTime());
		 java.sql.Date endDate = new Date(date2.getTime());
		 System.out.println(endDate);
		 System.out.println(startDate);
		return repo.findCompensationByDate(startDate, endDate);
	}
	
}
