package com.notyfyd.controller;

import com.notyfyd.model.UserModel;
import com.notyfyd.entity.User;
import com.notyfyd.service.UserService;
import com.notyfyd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @PostMapping("/user/create")
    public ResponseEntity<Object> createUser(@RequestBody UserModel model) {
        return userService.createUser(model);
    }
    @GetMapping("/user/all")
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
