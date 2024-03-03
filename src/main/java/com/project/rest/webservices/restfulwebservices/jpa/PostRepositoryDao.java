package com.project.rest.webservices.restfulwebservices.jpa;

import com.project.rest.webservices.restfulwebservices.user.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepositoryDao extends JpaRepository<Post,Integer> {

}