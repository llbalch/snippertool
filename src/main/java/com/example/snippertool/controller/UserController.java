package com.example.snippertool.controller;

import Utility.LoginRequest;
import com.example.snippertool.entity.User;
import com.example.snippertool.payload.UserRepo;
import java.util.Optional;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/users")
public class UserController {
    // salt rounds are handled through BCryptPassword encoder internally
    private final PasswordEncoder encoder = new BCryptPasswordEncoder();
    private final UserRepo repository;
    public UserController(UserRepo repository) {
        this.repository = repository;
    }

    //Create User POST /users

    @PostMapping
    public User createUser(@RequestBody User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        User savedUser = repository.save(user);
        savedUser.setPassword(null);
        return savedUser;
    }

    // manual authentication - Spring security middleware can be more robust
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        // using optional here enforces unique emails
        Optional<User> userOpt = repository.findByEmail(loginRequest.getEmail());
        if (userOpt.isEmpty()) {
            return ResponseEntity.status(401).body("Invalid email or password");
        }

        User user = userOpt.get();

        if (!encoder.matches(loginRequest.getPassword(), user.getPassword())) {
            return ResponseEntity.status(401).body("Invalid email or password");
        }

        user.setPassword(null);

        return ResponseEntity.ok(user);
    }

    //  get the user data - by email
    @GetMapping()
    public List<User> getUsers(@RequestParam(required = false) String email) {
        List<User> users;
        if (email != null) {
            users = repository.findByEmail(email)
                    .map(List::of)
                    .orElseGet(List::of);
        } else {
            users = repository.findAll();
        }
        for (User u : users) {
            u.setPassword(null);
        }
        return users;
    }

    // GET /users/{id}
    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        Optional<User> UserOpt = Optional.ofNullable(repository.findById(id));
        User user = UserOpt.orElseThrow(() -> new RuntimeException("User not found"));
        user.setPassword(null);
        return user;
    }

// basicAuth middleware?

//    salt rounds
    //save the user route.push
    // don't send back the hashed password


}
