package com.example.SprinProject.controller;
import com.example.SprinProject.DTO.MyRequestDTO;
//import com.example.SprinProject.services.UserServices;
import com.example.SprinProject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;


import javax.annotation.PostConstruct;

@RestController
public class UserController {
    public UserController(UserService userservice){
        this.userService=userService;
        System.out.println("Inside UserController constructor");
    }
    @PostConstruct
    public void init(){
        System.out.println("Inside UserController post constructor");
    }
    @Autowired
    private UserService userService;
    @PostMapping(path = "/update/employee/{id}")
    public boolean updateEmployee(@PathVariable String id, @RequestBody MyRequestDTO request) {
        return userService.updateEmployee(request, id);

    }


}
