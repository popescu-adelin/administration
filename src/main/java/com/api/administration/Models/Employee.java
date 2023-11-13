package com.api.administration.Models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "employees")
public class Employee{
    @Id
    @GeneratedValue
    public UUID id;

    public String name;

    @OneToOne(optional = true)
    @JoinColumn(name = "manager_id")
    public Employee manager;

    public String email;

    @ManyToOne(optional = true)
    @JoinColumn(name = "department_id")
    public Department department;
}
