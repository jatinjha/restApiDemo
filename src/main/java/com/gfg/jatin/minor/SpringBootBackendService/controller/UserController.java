package com.gfg.jatin.minor.SpringBootBackendService.controller;

import com.gfg.jatin.minor.SpringBootBackendService.model.User;
import com.gfg.jatin.minor.SpringBootBackendService.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Service;
import java.util.List;

@RestController
public class UserController {

    /*
    Define following methods for endpoints :
	1. @GetMapping("/users")
    	public List<User> getAllUsers()
	2. @GetMapping("/user/{id}")
    	public User getUserById(@PathVariable("id") Long id)
	3. @PostMapping("/user")
    	public User createUser(@RequestBody User user)
	4. @PutMapping("/user")
    	public User updateUserById(@RequestBody User user)
	5. @DeleteMapping("/user/{id}")
    	public void deleteUserById(@PathVariable("id") Long id)
     */

    @Autowired
    ServiceLayer userService;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.findAllUsers();
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Long id){
        return userService.findUserById(id);
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user){
        userService.createUser(user);

        return user;
    }

    @PutMapping("/user")
    public User updateUser(@RequestBody User user){
        userService.updateUser(user);
        return userService.findUserById(user.getId());
    }

    @DeleteMapping("/user/{id}")
    public User deleteUser(@PathVariable("id") Long id){
        User user = userService.findUserById(id);
        userService.deleteUser(id);
        return user;
    }








}
