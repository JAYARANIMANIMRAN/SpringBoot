//package com.example.SpringBoot.controller;
//
//import com.example.SpringBoot.model.RegisterDetails;
//import com.example.SpringBoot.model.UserDetailDto;
//import com.example.SpringBoot.service.AuthService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/auth")
//public class AuthController {
//
//    @Autowired
//    AuthService authService;
//
//    @PostMapping("/register")
//    public String addNewUser(@RequestBody UserDetailDto register) {
//        return authService.addNewEmployee(register);
//
//    }
//
//
//    @PostMapping("/login")
//    public String Login(@RequestBody RegisterDetails login) {
//        return authService.authenticate(login);
//
//    }
//}


package com.example.SpringBoot.controller;

import com.example.SpringBoot.model.RegisterDetails;
import com.example.SpringBoot.model.UserDetailDto;
import com.example.SpringBoot.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public String register(@RequestBody UserDetailDto register) {
        return authService. addnewuser(register);
    }


    @PostMapping("/login")
    public String login(@RequestBody RegisterDetails login) {
        return authService.authenticate(login);
    }
}
