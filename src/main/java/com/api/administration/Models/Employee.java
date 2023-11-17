package com.api.administration.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Data
@Table(name = "Employees")
public class Employee{
    @Id
    @GeneratedValue
    public UUID id;

    public String name;

    @ManyToOne(optional = true)
    @JoinColumn(name = "manager_id")
    public Employee manager;

    public String email;

    @ManyToOne(optional = true)
    @JoinColumn(name = "department_id")
    public Department department;
}
