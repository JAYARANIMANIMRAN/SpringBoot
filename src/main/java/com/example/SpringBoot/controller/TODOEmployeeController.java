package com.example.SpringBoot.controller;

import com.example.SpringBoot.model.Todo;
import com.example.SpringBoot.repository.RegisterDetailsRepository;
import com.example.SpringBoot.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class EmpTodoController {

    @Autowired
    TodoService todoServices;


    @GetMapping("/get/{empID}")
    public List<Todo> getTodoByEmployee(@PathVariable int empID){
        return todoServices.getTodoByEmployee(empID);
    }

    @PostMapping("/assign/{empID}")
    public String assignTask(@PathVariable int empID, @RequestBody Todo todo) {
        return todoServices.assignTaskToEmployee(empID, todo);
    }


}