package com.api.administration.Services.Interfaces;

import com.api.administration.DTOs.EmployeeDTO;
import com.api.administration.Models.Employee;

import java.util.Collection;

public interface IEmployeeService {
    public Collection<EmployeeDTO> getEmployees();
    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO);
}
