package com.example.employeepayrollappdevelopment.controller;

import com.example.employeepayrollappdevelopment.dto.EmployeePayrollDTO;
import com.example.employeepayrollappdevelopment.model.Employee;
import com.example.employeepayrollappdevelopment.services.EmployeeServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeServices employeeService;

    // Create Employee
    @PostMapping("/add")
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody EmployeePayrollDTO employeeDTO){
        Employee employee=employeeService.saveEmployee(employeeDTO);
        return ResponseEntity.ok(employee);
    }

    // Get Employee by their  ID
    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    // Get All Employees from database.
    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // Update Employee
    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@Valid @RequestBody EmployeePayrollDTO employeeDTO){
        Employee updateEmployee=employeeService.updateEmployee(id,employeeDTO);
        return ResponseEntity.ok(updateEmployee);
    }

    // Delete Employee
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        return employeeService.deleteEmployee(id) ? "Deleted Successfully" : "Employee Not Found";
    }
}