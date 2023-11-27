package com.api.administration.DTOs;

import com.api.administration.Models.Employee;

import java.util.List;
import java.util.UUID;

public class DepartmentDTO {
    public UUID id;
    public String name;
    public String description;
    public String parentDepartmentName;
    public List<EmployeeBriefData> employees;
}
