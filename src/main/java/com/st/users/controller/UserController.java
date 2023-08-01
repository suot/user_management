package com.st.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.st.users.entity.User;
import com.st.users.repository.UserRepository;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/user")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @PostMapping(path = "/add")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        userRepository.save(user);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping(path = "/users")
    public ResponseEntity<?> getAllUsers() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok().body(users);
    }

}
