package com.project.rest.webservices.restfulwebservices.jpa;

import com.project.rest.webservices.restfulwebservices.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryDao extends JpaRepository<User,Integer> {

}