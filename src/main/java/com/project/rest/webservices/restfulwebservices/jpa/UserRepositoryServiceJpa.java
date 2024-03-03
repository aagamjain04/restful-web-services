package com.project.rest.webservices.restfulwebservices.jpa;

import com.project.rest.webservices.restfulwebservices.user.Post;
import com.project.rest.webservices.restfulwebservices.user.User;
import com.project.rest.webservices.restfulwebservices.user.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Service
public class UserRepositoryServiceJpa {
    @Autowired
    UserRepositoryDao userRepositoryDao;
    public List<User> findAll() {
        return userRepositoryDao.findAll();
    }
    public Optional<User> findUser(int id) {

        Optional<User> user= userRepositoryDao.findById(id);
        return user;
        //return (User) userRepositoryDao.findAllById(Collections.singleton(id));
    }
    public void deleteById(int id) {
        userRepositoryDao.deleteById(id);
    }

    public User save(User user) {
       return userRepositoryDao.save(user);
    }

}
