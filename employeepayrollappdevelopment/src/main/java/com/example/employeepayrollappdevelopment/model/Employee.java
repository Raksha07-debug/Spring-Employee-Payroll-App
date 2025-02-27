package com.example.employeepayrollappdevelopment.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="employees")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String role;
    private String department;
    private int salary;
}
