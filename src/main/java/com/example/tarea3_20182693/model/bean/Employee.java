package com.example.tarea3_20182693.model.bean;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employeeId")
    private int employeeId;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "email")
    private String email;
    @ManyToOne
    @JoinColumn(name = "department_Id")  // Especifica la columna que contiene la FK en la tabla Employee
    private Department department;

    // Relación con Job
    @ManyToOne
    @JoinColumn(name = "job_Id")  // Especifica la columna que contiene la FK para Job
    private Job job;

    // Relación con Location
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;



}