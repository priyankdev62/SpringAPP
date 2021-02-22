package com.example.SprinProject.controller;
import  com.example.SprinProject.DTO.MyRequestDTO;
import com.example.SprinProject.DTO.MyResponseDTO;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyController {
    @GetMapping(path = "/hello")
    public String helloWorld(){
        return "success!!!";
    }
//    @PutMapping
  //  @DeleteMapping
    @PostMapping(path = "/hello-post")
    public String HelloWorldPost(){
        return "success post";
    }
    @GetMapping(path = "/hello-query")
    public String helloQuery(@RequestParam String query){
        return "query" +query;

    }
    @PostMapping(value ="/regist")
    public String registerUser(@RequestBody MyRequestDTO request){
        return request.toString();
    }
    @GetMapping(path ="/employee/{employeeID}")
    public MyResponseDTO getEmployeeDetails(@PathVariable String employeeID){
        MyResponseDTO response = new MyResponseDTO();
        response.setId(employeeID);
        return response;
    }
}
