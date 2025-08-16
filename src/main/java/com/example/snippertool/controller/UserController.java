//package com.example.snippertool.controller;
//import com.example.snippertool.entity.User;
//import com.example.snippertool.repository.UserRepo;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/users")
//public class UserController {
//
//    private final UserRepo repository;
//
//    public UserController(UserRepo repository) {
//        this.repository = repository;
//    }
//
//    @GetMapping("/{id}")
//    public User getUserById(@PathVariable int id) {
//        return repository.findById(id)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//    }
//
//    // Other endpoints for user data, none for login/password!
//}




