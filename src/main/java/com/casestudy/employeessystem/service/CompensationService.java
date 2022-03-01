package com.casestudy.employeessystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.employeessystem.models.Compensation;
import com.casestudy.employeessystem.repositories.ICompensationRepository;

@Service
public class CompensationService {

	@Autowired
	private ICompensationRepository repo;
	
	public List<Compensation> listAllCompensations() {
		return repo.findAll();
	}
	
	public Compensation updateCompensation(Compensation comp) {
		return repo.save(comp);
	}
	
	public Compensation getCompensation(int id) {
		return repo.getById(id);
	}
	
	
	
}
