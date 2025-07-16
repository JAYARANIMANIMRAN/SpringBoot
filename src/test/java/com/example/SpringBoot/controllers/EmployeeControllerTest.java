package com.example.SpringBoot.controllers;

import com.example.SpringBoot.controller.EmployeeController;
import com.example.SpringBoot.model.RegisterDetails;
import com.example.SpringBoot.model.UserDetailDto;
import com.example.SpringBoot.service.EmployeeService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class EmployeeControllerTest {

    @Mock
    EmployeeService employeeService;

    @InjectMocks
    EmployeeController employeeController;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRoute(){
        String result = employeeController.route();
        assertEquals("Welcome to SpringBoot Security",result);
    }


    @Test
    void testgetMethod(){
        RegisterDetails emp1 = new RegisterDetails();
        RegisterDetails emp2 = new RegisterDetails();
        when(employeeService.getMethod()).thenReturn(Arrays.asList(emp1,emp2));
        List<RegisterDetails> result = employeeController.getMethod();
        assertEquals(2,result.size());
    }

    @Test
    void testgetEmployeeById(){
        int empid = 1;
        RegisterDetails emp1 = new RegisterDetails();
        emp1.setEmpid(empid);
        when(employeeService.getEmployeeById(empid)).thenReturn(emp1);
        RegisterDetails result = employeeController.getEmployeeById(empid);
        assertEquals(empid,result.getEmpid());
    }

    @Test
    void testaddnewEmployee(){
        UserDetailDto user = new UserDetailDto();
        user.setName("Jaya");
        user.setEmail("Jaya@email.com");
        user.setPassword("Jaya@2005");
        String expectedMessage = "Employee added successfully";
        when(employeeService.addNewEmployee(user)).thenReturn(expectedMessage);
        String result = employeeController.addnewEmployee(user);
        assertEquals(expectedMessage, result);
    }

    @Test
    void testupdateEmployee(){
        int empId = 1;
        UserDetailDto user = new UserDetailDto();
        user.setName("Jayarani");
        user.setEmail("jayarani@email.com");
        String expectedMessage = "Employee updated successfully";
        when(employeeService.updateEmployee(empId, user)).thenReturn(expectedMessage);
        String result = employeeController.updateEmployee(empId, user);
        assertEquals(expectedMessage, result);
    }

}