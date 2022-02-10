package com.springsecurity.controller;

import com.springsecurity.model.UserAccount;
import com.springsecurity.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("user/")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("registration")
    public ResponseEntity<?> registration(@RequestBody UserAccount user) {
        log.info("registration");
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.registration(user));
    }

    @GetMapping("home")
    public ResponseEntity<?> getHome() {
        log.info("Home Service Call");
        return ResponseEntity.status(HttpStatus.OK).body("Home Service Call");
    }

    @GetMapping("dashboard")
    public ResponseEntity<?> getDashboard() {
        log.info("Dashboard Service Call");
        return ResponseEntity.status(HttpStatus.OK).body("Dashboard Service Call");
    }

    @GetMapping("findBy/{userName}")
    public ResponseEntity<?> findByUserName(@PathVariable String userName) {
        log.info("findByUserName {}", userName);
        return ResponseEntity.status(HttpStatus.OK).body(userService.findByUserName(userName));
    }

    @GetMapping("fetchUser/{userId}")
    public ResponseEntity<?> fetchUser(@PathVariable Long userId) {
        log.info("fetchUser");
        return ResponseEntity.status(HttpStatus.OK).body(userService.fetchUser(userId));
    }
}
