package com.casestudy.employeessystem;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.casestudy.employeessystem.models.Compensation;
import com.casestudy.employeessystem.models.User;
import com.casestudy.employeessystem.repositories.ICompensationRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class CompensationRepositoryTest {
	@Autowired
	private ICompensationRepository repo;

	@Autowired
	private TestEntityManager entityManager;

	// find compensations by employee's id
	/*
	 * @Test public void findCompensations() { int uid = 1; List<Compensation>
	 * compensations; try { compensations = repo.findCompensationByIdEmployee(uid);
	 * System.out.println(compensations); for (Compensation comp : compensations) {
	 * System.out.println(comp.getDescription()); }
	 * assertThat(compensations).isNotNull(); } catch (Exception e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); }
	 * 
	 * }
	 */
	
	@Test public void testFindByMonth() {
		String month = "October";
		List<Compensation> result = repo.findByMonth(month, 1, 2018);
		assertThat(result).isNotNull();
	}
	

}
