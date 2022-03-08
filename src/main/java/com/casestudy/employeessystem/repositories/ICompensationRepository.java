package com.casestudy.employeessystem.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.casestudy.employeessystem.models.Compensation;

public interface ICompensationRepository extends JpaRepository<Compensation, Integer> {
	//find compensations by start date and end date
	@Query(value="SELECT id, type, description, idEmployee, amount, date FROM Compensation "
			+ "WHERE date >= :startDate AND date < :endDate", nativeQuery = true)
	List<Compensation> findCompensationByDate(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
	
	//find compensations by employee id to show in the history
	@Query(value="SELECT id, type, description, idEmployee, amount, date FROM Compensation "
			+ "WHERE idEmployee = :idEmployee", nativeQuery = true)
	List <Compensation> findCompensationsByEmployeeId(@Param("idEmployee") int idEmployee);	

}
