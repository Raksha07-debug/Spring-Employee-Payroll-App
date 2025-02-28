package com.example.employeepayrollappdevelopment.model;

import com.example.employeepayrollappdevelopment.dto.EmployeePayrollDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="employees")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String gender;
    private int salary;
    private String note;
    private LocalDate startDate;
    private String profilePic;
    private List<String> department;

    public Employee(int id, EmployeePayrollDTO employeePayroll) {
        this.id=id;
        this.name = employeePayroll.name;
        this.salary = employeePayroll.salary;
        this.gender=employeePayroll.gender;
        this.startDate=employeePayroll.startDate;
        this.note=employeePayroll.note;
        this.profilePic=employeePayroll.profilePic;
        this.department=employeePayroll.department;
    }

}
