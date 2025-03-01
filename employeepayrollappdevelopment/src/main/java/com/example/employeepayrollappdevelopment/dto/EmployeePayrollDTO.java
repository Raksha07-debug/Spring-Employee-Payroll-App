package com.example.employeepayrollappdevelopment.dto;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Data; //lombok used to auto generate getter and setter methods.
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@ToString
public class EmployeePayrollDTO {
    @NotEmpty(message = "Name cannot be empty")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}$", message = "Employee name Invalid")
//    @NotNull
//    public  String message;

    public String name;
    @Pattern(regexp = "male|female", message = "Gender needs to be male or female")
    public String gender;
    @Min(value = 500, message = "Min Wage should be more than 500")

    public int salary;


    @JsonFormat(pattern = "dd MM yyyy")
    @NotNull(message = "startDate should Not be Empty")
    @PastOrPresent(message = "startDate should be past or today's date")
    public LocalDate startDate;
    @NotBlank(message = "Note cannot be Empty")
    public String note;
    @NotBlank(message = "profilePic cannot be Empty")
    public String profilePic;
    @NotNull(message = "department should Not be Empty")
    public List<String> department;


}