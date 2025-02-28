package com.example.employeepayrollappdevelopment.dto;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data; //lombok used to auto generate getter and setter methods.
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@ToString
public class EmployeePayrollDTO {
    @NotEmpty(message = "Name cannot be empty")
    @Pattern(regexp = "^[A-Z][a-zA-Z]{1,}(?: [A-Z][a-zA-Z]{1,})+$", message = "Name must contain both first name and last name, each starting with a capital letter and be at least 2 characters long")
    public String name;

    @Min(value = 1000, message = "Salary must be at least 1000")
    @Max(value = 1000000, message = "Salary cannot exceed 1,000,000")
    public int salary;
    public String gender;
    public LocalDate startDate;
    public String note;
    public String profilePic;
    public List<String> department;


}