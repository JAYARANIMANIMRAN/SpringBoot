package com.example.SpringBoot.controller;



import com.example.SpringBoot.model.RegisterDetails;
import com.example.SpringBoot.model.Roles;
import com.example.SpringBoot.model.UserDetailDto;
import com.example.SpringBoot.service.AuthService;
import com.example.SpringBoot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")


public class EmployeeController {

    @Autowired
    AuthService authService;

    @Autowired
    private EmployeeService employeeService;

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/")
    public String route(){
        return "Welcome to SpringBoot Security";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/get")
    public List<RegisterDetails> getMethod(){

        return employeeService.getMethod();
    }

    //@PreAuthorize("hasRole('USER')")
    @GetMapping("/{empID}")
    public RegisterDetails getEmployeeById(@PathVariable int empID){

        return employeeService.getEmployeeById(empID);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/role/{roleName}")
    public List<RegisterDetails> getRoles(@PathVariable String roleName){
        return employeeService.getEmployeeByRoles(roleName);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{empID}")
    public String updateEmployee(@PathVariable int empID,@RequestBody UserDetailDto registerDetails){
        return employeeService.updateEmployee(empID,registerDetails);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add")
    public String addnewEmployee(@RequestBody UserDetailDto registerDetails){
        return employeeService.addNewEmployee(registerDetails);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/del/{empID}")
    public String deleteEmployee(@PathVariable int empID){
        return employeeService.deleteEmployeeById(empID);
    }



}