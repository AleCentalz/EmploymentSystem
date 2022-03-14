package com.casestudy.employeessystem.repositories;

import java.sql.Date;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.casestudy.employeessystem.models.Compensation;

@Repository
public interface ICompensationRepository extends JpaRepository<Compensation, Integer> {
	//find compensations by start date and end date
	@Query(value="SELECT id, type, description, idEmployee, amount, date FROM Compensation "
			+ "WHERE date >= :startDate AND date < :endDate", nativeQuery = true)
	List<Compensation> findCompensationByDate(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
	
	/*find all compensations by employee id to show in the history
	@Query(value="SELECT * FROM Compensation "
			+ "WHERE idEmployee = :idEmployee ORDER BY date asc", nativeQuery = true)
	List <Compensation> findCompensationsByEmployeeId(@Param("idEmployee") int idEmployee);	*/

	//find compensations grouped by year, month and totals
	@Query(value="SELECT id, type, description, idEmployee, date, SUM(amount) as amount, MONTHNAME(date) as monthname, "
			+ "YEAR(date) as yearname FROM Compensation WHERE idEmployee = :idEmployee "
			+ "GROUP BY yearname, monthname ORDER by date asc", nativeQuery=true)
	List<Compensation> findCompensationsByEmployeeId(@Param("idEmployee") int idEmployee);	
	
	//get the total 
	@Query(value="SELECT SUM(amount) as total FROM Compensation WHERE idEmployee = :idEmployee", nativeQuery=true)
	Float getTotal(@Param("idEmployee") int idEmployee);
	
	//get compensations by month
	@Query(value="SELECT * FROM Compensation WHERE MONTHNAME(date) = :monthname and idEmployee = :idEmployee and YEAR(date) = :year", nativeQuery=true)
	List<Compensation> findByMonth(@Param("monthname") String monthname, @Param("idEmployee") int idEmployee, @Param("year") int year);
}
