package com.casestudy.employeessystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casestudy.employeessystem.models.User;

public interface IUserRepository extends JpaRepository<User, Long> {

}
