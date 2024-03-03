package com.project.rest.webservices.restfulwebservices.jpa;

import com.project.rest.webservices.restfulwebservices.user.Post;
import com.project.rest.webservices.restfulwebservices.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostRepositoryServiceJpa {
    @Autowired
    PostRepositoryDao postRepositoryDao;


    public Post save(Post post) {
        return postRepositoryDao.save(post);
    }
}
