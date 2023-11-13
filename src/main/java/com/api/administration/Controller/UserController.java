package com.api.administration.Controller;

import com.api.administration.DTOs.EmployeeDTO;
import com.api.administration.Models.Employee;
import com.api.administration.Services.Interfaces.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final IEmployeeService _employeeService;

    @Autowired
    public UserController(IEmployeeService employeeService){
        _employeeService=employeeService;
    }

    @GetMapping()
    public Collection<EmployeeDTO> getEmployees(){
        return _employeeService.getEmployees();
    }

    @PostMapping()
    public EmployeeDTO addEmploye(@RequestBody EmployeeDTO employeeDTO){
        return _employeeService.addEmployee(employeeDTO);
    }
}
