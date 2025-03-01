package com.example.employeepayrollappdevelopment.services;

import com.example.employeepayrollappdevelopment.dto.EmployeePayrollDTO;
import com.example.employeepayrollappdevelopment.model.Employee;
import jakarta.validation.Valid;
import lombok.*;
import java.util.List;
import java.util.Optional;

public interface IEmployeePayrollService {
    List<Employee> getAllEmployees();

    // Create Employee and save it to database.
    Employee saveEmployee(@Valid EmployeePayrollDTO employeePayrollDTO);

    Optional<Employee> getEmployeeById(Long id);

    // Delete Employee from data
    boolean deleteEmployee(Long id);

    Employee updateEmployee(long id, EmployeePayrollDTO employeeDTO);


}
