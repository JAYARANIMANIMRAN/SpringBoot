package com.example.SpringBoot.service;


import com.example.SpringBoot.model.RegisterDetails;
import com.example.SpringBoot.model.Roles;
import com.example.SpringBoot.model.UserDetailDto;
import com.example.SpringBoot.repository.RegisterDetailsRepository;
import com.example.SpringBoot.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class EmployeeService {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RegisterDetailsRepository registerDetailRepository;

    @Autowired
    RolesRepository rolesRepository;

    public List<RegisterDetails> getMethod() {

        return registerDetailRepository.findAll();
    }

    public RegisterDetails getEmployeeById(int empID) {
        return registerDetailRepository.findById(empID).orElse(new RegisterDetails());
    }

    public List<RegisterDetails> getEmployeeByRoles(String roleName){
        Roles role = rolesRepository.findByRoleName(roleName)
                .orElseThrow(()->new RuntimeException("Role Not Found" + roleName));
        return registerDetailRepository.findByRoles(role);
    }

    public String addNewEmployee(UserDetailDto register) {
        RegisterDetails registerDetails = new RegisterDetails();
        registerDetails.setEmpid(register.getEmpid());
        registerDetails.setEmpName(register.getName());
        registerDetails.setEmail(register.getEmail());
        registerDetails.setPassword(passwordEncoder.encode(register.getPassword()));
        registerDetails.setUsername(register.getUserName());
        Set<Roles> roles = new HashSet<>();
        for(String roleName: register.getRoleNames()){
            Roles role = rolesRepository.findByRoleName(roleName)
                    .orElseThrow(()->new RuntimeException("User not found" + roleName));
            roles.add(role);
        }
        registerDetails.setRoles(roles);
        System.out.println("Registration"+ registerDetails);
        registerDetailRepository.save(registerDetails);
        return "Employee Added Successfully";
    }

    public String updateEmployee(int empID,UserDetailDto registerDetails) {
        RegisterDetails user = registerDetailRepository.findById(empID)
                .orElseThrow(()-> new RuntimeException("No such user found"));
        user.setEmpName(registerDetails.getName());
        user.setEmail(registerDetails.getEmail());
        user.setPassword(passwordEncoder.encode(registerDetails.getPassword()));
        user.setUsername(registerDetails.getUserName());
        Set<Roles> roles = new HashSet<>();
        for(String roleName: registerDetails.getRoleNames()){
            Roles role = rolesRepository.findByRoleName(roleName)
                    .orElseThrow(()->new RuntimeException("User not found" + roleName));
            roles.add(role);
        }
        user.setRoles(roles);

        registerDetailRepository.save(user);
        return "Employee Updated Successfully";
    }

    public String deleteEmployeeById(int empID){
        registerDetailRepository.deleteById(empID);
        return "Employee Deleted Successfully";
    }
}