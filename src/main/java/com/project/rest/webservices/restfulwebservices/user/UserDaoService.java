package com.project.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int usersCount = 0;

    static {
        users.add(new User(++usersCount,"Aagam", LocalDate.now().minusYears(30)));
        users.add(new User(++usersCount,"Alex", LocalDate.now().minusYears(20)));
        users.add(new User(++usersCount,"John", LocalDate.now().minusYears(22)));
    }
    public List<User> findAll() {
        return users;
    }
    public User findUser(int id) {
        Predicate<? super User> predicate = user -> (user.getId()==id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }
    public Boolean deleteById(int id) {
        Predicate<? super User> predicate = user -> (user.getId()==id);
        return users.removeIf(predicate);
    }

    public User save(User user) {
        user.setId(++usersCount);
        users.add(user);
        return user;
    }
}
