package com.casestudy.employeessystem;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import com.casestudy.employeessystem.models.User;
import com.casestudy.employeessystem.repositories.IUserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
	
	@Autowired
	private IUserRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateUser() {
		//User user = new User();
		//user.setEmail("ruiz@ibm.com");
		//user.setPassword("test");
		
		//User savedUser = repo.save(user);
		
		//User existUser =  entityManager.find(User.class, savedUser.getId());
		
		//assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
		
	} 
	
	@Test public void testFindUserByEmail() {
		String email = "rramirez@ibm.com";
		User user = repo.findByEmail(email);
		assertThat(user).isNotNull();
	}

}
