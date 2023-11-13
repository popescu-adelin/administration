package com.api.administration.Models;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue
    public UUID id;

    public String name;

    public String description;

    public int parentId;

    @OneToMany(mappedBy = "department")
    public List<Employee> employees;
}
