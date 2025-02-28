package com.example.employeepayrollappdevelopment.services;

import com.example.employeepayrollappdevelopment.dto.EmployeePayrollDTO;
import com.example.employeepayrollappdevelopment.repository.EmployeeRepository;
import com.example.employeepayrollappdevelopment.model.Employee;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class EmployeeServices {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Create Employee and save it to database.
    public Employee saveEmployee(@Valid EmployeePayrollDTO employeePayrollDTO) {
        Employee employee= new Employee();
        employee.setName(employeePayrollDTO.name);
        employee.setSalary((int) employeePayrollDTO.salary);
        return employeeRepository.save(employee);

    }

    // Get Employee by ID.
    public Optional<Employee> getEmployeeById(Long id) {
        log.info("Fetching employee with ID: {}",id);
        return employeeRepository.findById(id);
    }

    // List All Employees in the database 
    public List<Employee> getAllEmployees() {
        log.info("Fetching all employees");
        return employeeRepository.findAll();
    }

    // Update Employee
    public Employee updateEmployee(Long id, @Valid EmployeePayrollDTO newEmployeeData) {
        return employeeRepository.findById(id).map(employee -> {
            employee.setName(newEmployeeData.name);
            employee.setSalary((int)newEmployeeData.salary);
            return employeeRepository.save(employee);
        }).orElse(null);
    }

    // Delete Employee from data
    public boolean deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            log.info("Deleting employee with id: {}",id);
            employeeRepository.deleteById(id);
            return true;
        }
        log.warn("Employee with ID {} not found for deletion",id);
        return false;
    }
}