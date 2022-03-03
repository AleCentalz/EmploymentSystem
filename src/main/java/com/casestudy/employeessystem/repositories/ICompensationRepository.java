package com.casestudy.employeessystem.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.casestudy.employeessystem.models.Compensation;

public interface ICompensationRepository extends JpaRepository<Compensation, Integer> {
	//fin compensations by start date and end date
	//List<Compensation> findCompensationByDate(Date date);
	
	//find compensations by employee id to show in the history
	@Query(value="SELECT id, type, description, idEmployee, amount, date, MONTHNAME(date) as monthname, "
			+ "YEAR(date) as yeardate, SUM(amount) as totalmonth FROM Compensation "
			+ "WHERE idEmployee = :idEmployee GROUP BY monthname, yeardate, id, type, description, idEmployee, amount, date", nativeQuery = true)
	
	List <Compensation> findCompensationsByEmployeeId(@Param("idEmployee") int idEmployee);
	

}
