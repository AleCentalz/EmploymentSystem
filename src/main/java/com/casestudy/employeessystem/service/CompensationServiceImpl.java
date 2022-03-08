package com.casestudy.employeessystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.employeessystem.models.Compensation;
import com.casestudy.employeessystem.models.Employee;
import com.casestudy.employeessystem.repositories.ICompensationRepository;

@Service
public class CompensationServiceImpl implements CompensationService {

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

	
}
