package com.api.administration.Services.Interfaces;

import com.api.administration.DTOs.DepartmentDTO;
import com.api.administration.Models.Department;

import java.util.List;

public interface IDepartmentService {
    public List<DepartmentDTO> getDepartments();
    public DepartmentDTO addDepartment(DepartmentDTO department);
    public Department updateDepartment(Department department);
    public Boolean deleteDepartment(String id);
    public Boolean moveDepartmentToExistingDepartment(String departmentName,String targetDepartmentName);
}
