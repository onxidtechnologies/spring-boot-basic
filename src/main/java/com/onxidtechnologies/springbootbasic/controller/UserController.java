package com.onxidtechnologies.springbootbasic.controller;

import com.onxidtechnologies.springbootbasic.model.User;
import com.onxidtechnologies.springbootbasic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private UserRepository userRepository;

    @RequestMapping(method = POST, consumes = "application/json")
    public @ResponseBody
    User add(@RequestBody User user) {
        return userRepository.save(user);
    }

    @RequestMapping(method = GET, produces = "application/json")
    public @ResponseBody Iterable<User> getList() {
        return userRepository.findAll();
    }

    @RequestMapping(path="/{id}", method = GET, produces = "application/json")
    public @ResponseBody
    ResponseEntity<User> get(@PathVariable("id") String id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(path="/{id}", method = PUT, consumes = "application/json")
    public @ResponseBody ResponseEntity<User> update(@RequestBody User user, @PathVariable("id") String id) {
        Optional<User> currentUser = userRepository.findById(id);

        if (currentUser.isPresent()) {
            user.setId(id);
            return new ResponseEntity<>(userRepository.save(user), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(path="/{id}", method = DELETE)
    public @ResponseBody ResponseEntity<User> delete(@PathVariable("id") String id) {
        Optional<User> currentUser = userRepository.findById(id);

        if (currentUser.isPresent()) {
            userRepository.delete(currentUser.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
