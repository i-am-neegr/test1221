package com.example.test.controller;

import com.example.test.model.User;
import com.example.test.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping()
    public ResponseEntity<User> addMeal(@RequestBody User users) {
        return ResponseEntity.ok(userService.addUser(users));
    }
}
