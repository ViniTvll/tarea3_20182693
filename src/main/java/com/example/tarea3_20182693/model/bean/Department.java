package com.example.tarea3_20182693.model.bean;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private int departmentId;
    @Column(name = "department_name", nullable = false)
    private String departName;
    private Location location;


    @Override
    public String toString() {
        return departName;
    }


}