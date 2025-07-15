package com.example.SpringBoot.service;
import com.example.SpringBoot.model.Employee;
import com.example.SpringBoot.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class EmployeeService {

    List<Employee> employees = new ArrayList<>(Arrays.asList(
            new Employee(1, "Sana", "Developer"),
            new Employee(2, "Jaya", "Product Manager"),
            new Employee(3, "dhana", "Data Analyst")
    ));

    @Autowired
    private EmployeeRepo empRepo;

    public List<Employee> getAllEmployees() {
        return empRepo.findAll();
    }

    public Employee getEmployeeById(int id) {
        return empRepo.findById(id).orElse(null);
    }

    public List<Employee> getEmployeesByJob(String job) {
        return empRepo.findByJob(job);
    }

    public Employee getEmployeesByID(int empID) {
        return empRepo.findById(empID).orElse(null);
    }

    public String addEmployee(Employee employee) {
        empRepo.save(employee);
        return "Employee added successfully";
    }


    public Employee updateEmployee(int id, Employee updatedEmployee) {
        return empRepo.findById(id).map(employee -> {
            employee.setName(updatedEmployee.getName());
            employee.setJob(updatedEmployee.getJob());
            return empRepo.save(employee);
        }).orElse(null);


    }


    public void deleteEmployee(int id) {
        empRepo.deleteById(id);
    }


}
