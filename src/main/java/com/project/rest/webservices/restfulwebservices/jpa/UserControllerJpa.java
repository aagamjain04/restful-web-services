package com.project.rest.webservices.restfulwebservices.jpa;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.project.rest.webservices.restfulwebservices.user.Post;
import com.project.rest.webservices.restfulwebservices.user.User;
import com.project.rest.webservices.restfulwebservices.user.UserDaoService;
import com.project.rest.webservices.restfulwebservices.user.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserControllerJpa {

    @Autowired
    UserRepositoryServiceJpa userRepositoryServiceJpa;
    @Autowired
    PostRepositoryServiceJpa postRepositoryServiceJpa;

    @GetMapping("/jpa/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<List<User>>(userRepositoryServiceJpa.findAll(),HttpStatus.OK);

    }
    @GetMapping("/jpa/users/{id}")
    public EntityModel<User> getUser(@PathVariable int id) {
        Optional<User> user= userRepositoryServiceJpa.findUser(id);
        if(user.isEmpty()){
            throw new UserNotFoundException("id "+id);
        }
        //return new ResponseEntity<User>(userDaoService.findUser(id),HttpStatus.OK);
        EntityModel<User> entityModel = EntityModel.of(user.get());
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllUsers());
        entityModel.add(link.withRel("all-users"));
        return entityModel;

    }

    @PostMapping("/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {

        return new ResponseEntity<>(userRepositoryServiceJpa.save(user), HttpStatus.CREATED);
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteById(@PathVariable int id) {
        userRepositoryServiceJpa.deleteById(id);
    }

    @GetMapping("/jpa/users/{id}/posts")
    public ResponseEntity<List<Post>> getPostsforUser(@PathVariable int id) {
        Optional<User> user= userRepositoryServiceJpa.findUser(id);
        if(user.isEmpty()){
            throw new UserNotFoundException("id "+id);
        }
        return new ResponseEntity<>(user.get().getPosts(), HttpStatus.OK);
    }

    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Post> postforUser(@PathVariable int id, @Valid @RequestBody Post post){
        Optional<User> user= userRepositoryServiceJpa.findUser(id);
        if(user.isEmpty()){
            throw new UserNotFoundException("id "+id);
        }
        post.setUser(user.get());
        return new ResponseEntity<>(postRepositoryServiceJpa.save(post), HttpStatus.OK);

    }
}
