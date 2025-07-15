//package com.example.SpringBoot.service;
//
//import com.example.SpringBoot.model.RegisterDetails;
//import com.example.SpringBoot.model.Roles;
//import com.example.SpringBoot.model.UserDetailDto;
//import com.example.SpringBoot.repository.RegisterDetailsRepository;
//import com.example.SpringBoot.repository.RolesRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import java.util.HashSet;
//import java.util.Set;
//
//
//@Service
//public class AuthService {
//
//
//        @Autowired
//        RegisterDetailsRepository registerDetailsRepository;
//
//        @Autowired
//        RolesRepository rolesRepository;
//
//        @Autowired
//        PasswordEncoder passwordEncoder;
//
//        public String addNewEmployee(CustomUserDetailService register) {
//
//            RegisterDetails registerDetails = new RegisterDetails();
//            registerDetails.setEmpId(register.getEmpId());
//            registerDetails.setName(register.getName());
//            registerDetails.setEmail(register.getEmail());
//            registerDetails.setPassword(passwordEncoder.encode(register.getpassword()));
//            registerDetails.setUsername(register.getUsername());
//            Set<Roles> roles = new HashSet<>();
//            for(String roleName: register.getRoleNames()){
//                Roles role = rolesRepository.findByRoleName(roleName)
//
//                        .orElseThrow(()->new RuntimeException("User not found" + roleName));
//                roles.add(role);
//            }
//
//            registerDetails.setRoles(roles);
//
//            System.out.println("Registration"+ registerDetails);
//            registerDetailsRepository.save(registerDetails);
//
//            return "Employee Added Successfully";
//
//        }
//
//
//        public String authenticate(RegisterDetails login) {
//
//            RegisterDetails user = registerDetailsRepository.findByEmail(login.getEmail());
//
//            if(user != null){
//
//                if (passwordEncoder.matches(login.getPassword(),user.getPassword())){
//                    return "Login Successful";
//
//                }
//
//            }
//
//            return "Login Not Successful";
//
//        }
//
//}
//


package com.example.SpringBoot.service;

import com.example.SpringBoot.model.RegisterDetails;
import com.example.SpringBoot.model.Roles;
import com.example.SpringBoot.model.UserDetailDto;
import com.example.SpringBoot.repository.RegisterDetailsRepository;

import com.example.springbootsecond.repository.RegisterRepository;
import com.example.SpringBoot.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AuthService {

    @Autowired
    RegisterDetailsRepository registerDetailsRepository;


    @Autowired
    RegisterRepository registerRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Autowired
    RolesRepository rolesRepo;


    public String  addnewuser(UserDetailDto register) {
        RegisterDetails registerDetails1 = new RegisterDetails();
        registerDetails1.setEmpid(register.getEmpid());
        registerDetails1.setEmpName(register.getName());
//        registerDetails1.setDob(register.getDob());
        registerDetails1.setEmail(register.getEmail());
        System.out.println("Password is "+register.getPassword()+"\n Encrtpted Password is "+passwordEncoder);
        registerDetails1.setPassword(passwordEncoder.encode(register.getPassword()
        ));
        registerDetails1.setUsername(register.getUserName());

        Set<Roles> roles = new HashSet<>();
        for (String roleName : register.getRoleNames()) {
            Roles role = rolesRepo.findByRoleName(roleName)
                    .orElseThrow(() -> new RuntimeException("Role not found: " + roleName));
            roles.add(role);
        }

        registerDetails1.setRoles(roles);
        System.out.println("register:"+register);



//        registerDetails1.setRoles(register.getRoles());
//        registerDetails1.setGender(register.getGender());
        registerDetailsRepository.save(registerDetails1);

        return "Employee added Sucessfully!!!!!!!";
    }

    public String authenticate(RegisterDetails login) {

        RegisterDetails user = registerRepository.findByEmail(login.getEmail());
        if (user == null){
            return "User not found!";
        }

        boolean isMatch = passwordEncoder.matches(login.getPassword(), user.getPassword());

        if (!isMatch) {
            return "Invalid password!";
        }

        return "Login Successfully!";

    }

}

