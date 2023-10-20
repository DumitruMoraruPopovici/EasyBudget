package com.example.EasyBudget.controller;

import com.example.EasyBudget.model.User;

import com.example.EasyBudget.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@Controller
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @PostMapping(path = "/adduser")
    public @ResponseBody String addUser(@RequestParam String firstName,
                                        @RequestParam String lastName,
                                        @RequestParam String email,
                                        @RequestParam String password,
                                        @RequestParam String gender,
                                        @RequestParam LocalDate dateOfBirth) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        user.setGender(gender);
        user.setDateOfBirth(dateOfBirth);
        userRepository.save(user);
        return "User was saved";
    }

    @GetMapping(path = "/getusers")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }


}

