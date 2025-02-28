package com.example.employeepayrollappdevelopment.services;

import com.example.employeepayrollappdevelopment.dto.EmployeePayrollDTO;
import com.example.employeepayrollappdevelopment.model.Employee;

import java.util.List;

public interface IEmployeePayrollService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);
    Employee createEmployee(EmployeePayrollDTO employeeDTO);
    Employee updateEmployee(int id, EmployeePayrollDTO employeeDTO);
    boolean deleteEmployee(int id);
}
