package com.example.SpringBoot.controller;
import com.example.SpringBoot.model.Employee;
import com.example.SpringBoot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/employees")
public class EmployeeController {


        @Autowired
        private EmployeeService employeeService;


        @GetMapping
        public List<Employee> getAllEmployees() {
            return employeeService.getAllEmployees();
        }


        @GetMapping("/{id}")
        public Employee getEmployeeById(@PathVariable int id) {
            return employeeService.getEmployeesByID(id);
        }


        @GetMapping("/job/{job}")
        public List<Employee> getEmployeesByJob(@PathVariable String job) {
            return employeeService.getEmployeesByJob(job);
        }


         @PostMapping
         public String addEmployee(@RequestBody Employee employee) {
            return employeeService.addEmployee(employee);
        }

}
