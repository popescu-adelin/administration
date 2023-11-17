package com.api.administration.DTOs;

import com.api.administration.Models.Department;
import com.api.administration.Models.Employee;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;
import java.util.UUID;

public class DepartmentDTO {
    public UUID id;
    public String name;
    public String description;

    public String parentDepartmentName;
    public List<Employee> employees;
}
