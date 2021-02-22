package com.example.SprinProject.services;


import com.example.SprinProject.DTO.MyRequestDTO;

public interface UserService {
    boolean updateEmployee(MyRequestDTO request, String id);
}
