package com.example.SprinProject.services.impl;
import com.example.SprinProject.DTO.MyRequestDTO;

import com.example.SprinProject.services.UserService;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;

@Service
public class UserServiceImpl implements UserService {

    public UserServiceImpl(){
        System.out.println("Inside UserService constructor..");
    }

    @PostConstruct
    public void init(){
        System.out.println("Inside UserService PostConstructor...");
    }
    @Override
    public boolean updateEmployee(MyRequestDTO request,String id){
        System.out.println("inside user services" +request+" id: "+id);
        return false;
    }
}
