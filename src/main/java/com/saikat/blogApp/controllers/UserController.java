package com.saikat.blogApp.controllers;


import com.saikat.blogApp.models.User;
import com.saikat.blogApp.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService service;


//    post create user
    @PostMapping("/user")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){

        User createdUser = service.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);

    }

//    put update user by id
    @PutMapping("/user/{userId}")
    public ResponseEntity<User> updateUser(@RequestBody User user , @PathVariable int userId ){
        User updatedUser = service.updateUser(user , userId);
        return ResponseEntity.status(HttpStatus.OK).body(updatedUser);
    }

//    get an user by id
    @GetMapping("/user/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable int userId){
            User gotUser = service.getUserById(userId);
            return ResponseEntity.status(HttpStatus.OK).body(gotUser);
    }

//    delete an user
    @DeleteMapping("/user/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable int userId){
        service.deleteUser(userId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

//    get all users
    @GetMapping("/user")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> res = service.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }
}



