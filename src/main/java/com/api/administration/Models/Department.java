package com.api.administration.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "Departments")
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
