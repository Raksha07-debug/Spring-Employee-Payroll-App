package com.example.employeepayrollappdevelopment.services;

import com.example.employeepayrollappdevelopment.dto.EmployeePayrollDTO;
import com.example.employeepayrollappdevelopment.exception.EmployeeNotFoundException;
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
public class EmployeeServices implements IEmployeePayrollService{

    @Autowired
    private EmployeeRepository employeeRepository;

    // Create Employee and save it to database.
    @Override
    public Employee saveEmployee(@Valid EmployeePayrollDTO employeePayrollDTO) {
        log.info("Creating employee: {}", employeePayrollDTO.name);
        Employee employee = new Employee(employeePayrollDTO);
        return employeeRepository.save(employee);

    }

    // Get Employee by ID.
    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        log.info("Fetching employee with ID: {}",id);
        return employeeRepository.findById(id);
    }

    // List All Employees in the database
    @Override
    public List<Employee> getAllEmployees() {
        log.info("Fetching all employees");
        return employeeRepository.findAll();
    }



    // Delete Employee from data
    @Override
    public boolean deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            log.info("Deleting employee with id: {}",id);
            employeeRepository.deleteById(id);
            return true;
        }
        log.warn("Employee with ID {} not found for deletion",id);
        return false;
    }

    @Override
    public Employee updateEmployee(long id, @Valid EmployeePayrollDTO newEmployeeDTO){
        Employee existingEmployee = employeeRepository.findById(id)
            .orElseThrow(() -> new EmployeeNotFoundException("Employee with ID " + id + " not found"));

        log.info("Updating employee with ID: {}", id);

        existingEmployee.updateEmployeePayrollData(newEmployeeDTO);
        return employeeRepository.save(existingEmployee);
}
}