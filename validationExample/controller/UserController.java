package com.validation.validationExample.controller;

import com.validation.validationExample.dto.UserRequest;
import com.validation.validationExample.entity.User;
import com.validation.validationExample.exception.UserNotFoundException;
import com.validation.validationExample.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    //create a new user
    @PostMapping("/add-user")
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserRequest userRequest){
        return new ResponseEntity<>(userService.saveUser(userRequest), HttpStatus.CREATED);
    }

    //find all user
    @GetMapping("/get-all-user")
    public ResponseEntity<List<User>> getAll(){
        return ResponseEntity.ok(userService.getAllUser());
    }

    //find user by id
    @GetMapping("/get-user/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id) throws UserNotFoundException {
        return ResponseEntity.ok(userService.getUserByID(id));
    }

    //update user by id
    @PutMapping("/update-info/{id}")
    public ResponseEntity<String> updateUser(@RequestBody UserRequest userRequest, @PathVariable int id) throws UserNotFoundException {
        User user = userService.getUserByID(id);
        userService.updateUser(id, userRequest);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("updated");
    }

    //delete by id
    @DeleteMapping("/delete-user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) throws UserNotFoundException {
        User user = userService.getUserByID(id);
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("deleted");
    }
}
