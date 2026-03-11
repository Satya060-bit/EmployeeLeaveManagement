package EmployeeLeaveManagementApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import EmployeeLeaveManagementApplication.entity.User;
import EmployeeLeaveManagementApplication.repository.UserRepository;
import EmployeeLeaveManagementApplication.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
    private UserService userService;

    @PostMapping("/save")
    public User saveUser(@RequestBody User user) {

        return userService.saveUser(user);
    }

    @GetMapping("/all")
    public List<User> getUsers(){

        return userService.getAllUsers();
    }

}
