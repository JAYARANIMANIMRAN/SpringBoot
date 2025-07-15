package com.example.SpringBoot.repository;

import com.example.SpringBoot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

    List<Employee> findByJob(String job);
}
