package com.casestudy.employeessystem.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casestudy.employeessystem.models.Compensation;

public interface ICompensationRepository extends JpaRepository<Compensation, Integer> {
	//fin compensations by start date and end date
	//List<Compensation> findCompensationByDate(Date date);

}
