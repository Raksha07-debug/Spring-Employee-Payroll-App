package com.example.employeepayrollappdevelopment.repository;

import com.example.employeepayrollappdevelopment.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query(value = "SELECT ep.* FROM employee_payroll ep " +
            "JOIN employee_department ed ON ep.employee_id = ed.employee_id " +
            "WHERE ed.department = :department", nativeQuery = true)
    List<Employee> findEmployeesByDepartment(String department);
}

