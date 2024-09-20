package com.example.tarea3_20182693.model.bean;

import jakarta.persistence.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "jobs")
public class Job {

    @Id
    @Column(name = "job_id")
    private String jobId;

    @Column(name = "job_title", nullable = false)
    private String jobTitle;

}
