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
    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "name")
    private String name;



//    private  String message;
    private String gender;
    private int salary;
    private String note;
    private LocalDate startDate;
    private String profilePic;

    @ElementCollection
    @CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name = "employee_id"))
    @Column(name = "departments")
    private List<String> departments;

    public Employee(EmployeePayrollDTO empPayrollDTO) {
        this.updateEmployeePayrollData(empPayrollDTO);
    }

    public void updateEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
        this.name = empPayrollDTO.name;
        this.salary = empPayrollDTO.salary;
        this.gender = empPayrollDTO.gender;
        this.note = empPayrollDTO.note;
        this.startDate = empPayrollDTO.startDate;
        this.profilePic = empPayrollDTO.profilePic;
        this.departments = empPayrollDTO.department;
    }

}
