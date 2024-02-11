package com.project.rest.webservices.restfulwebservices.user;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserDaoService userDaoService;
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<List<User>>(userDaoService.findAll(),HttpStatus.OK);

    }
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id) {
        User user = userDaoService.findUser(id);
        if(user==null){
            throw new UserNotFoundException("id "+id);
        }
        return new ResponseEntity<User>(userDaoService.findUser(id),HttpStatus.OK);

    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {

        return new ResponseEntity<>(userDaoService.save(user), HttpStatus.CREATED);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable int id) {
        Boolean status = userDaoService.deleteById(id);

        return new ResponseEntity<Boolean>(userDaoService.deleteById(id),HttpStatus.OK);

    }
}
