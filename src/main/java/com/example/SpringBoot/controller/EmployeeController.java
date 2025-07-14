package com.example.SpringBoot.controller;
import com.example.SpringBoot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController


public class EmployeeController {


        @Autowired
        private EmployeeService hws;

        @GetMapping("/")
        public String hello() {
            return hws.getMethod();
        }

        @PostMapping("/")
        public String postMethod() {
            return hws.postMethod();
        }
        @PutMapping("/")
        public String putMethod() {
            return hws.putMethod();
        }

        @DeleteMapping("/")
        public String deleteMethod() {
            return hws.deleteMethod();
        }



}
