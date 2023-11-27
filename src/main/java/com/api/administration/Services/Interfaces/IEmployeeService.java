package com.api.administration.Services.Interfaces;

import com.api.administration.DTOs.EmployeeDTO;
import com.api.administration.Models.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IEmployeeService {
    public List<EmployeeDTO> getEmployees();
    public EmployeeDTO getEmployeeById(String id);
    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO);
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO);
    public Boolean deleteEmployeeById(String id);
    public Collection<EmployeeDTO> getEmployeesFromDepartment(String departmentName);
}
