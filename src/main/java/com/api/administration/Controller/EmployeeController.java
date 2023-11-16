package com.api.administration.Controller;

import com.api.administration.DTOs.EmployeeDTO;
import com.api.administration.Services.Interfaces.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.web.client.HttpClientErrorException.*;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    private final IEmployeeService _employeeService;

    @Autowired
    public EmployeeController(IEmployeeService employeeService){
        _employeeService=employeeService;
    }

    @GetMapping()
    public Collection<EmployeeDTO> getEmployees(){
        return _employeeService.getEmployees();
    }

    @PostMapping()
    public EmployeeDTO addEmploye(@RequestBody EmployeeDTO employeeDTO){
        var employee = _employeeService.addEmployee(employeeDTO);
        return employee;
    }

    @PutMapping()
    public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody EmployeeDTO employeeDTO){
        var employee = _employeeService.updateEmployee(employeeDTO);
        if(employee == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable String id){
        var isDeleted = _employeeService.deleteEmployeeById(id);
        if(!isDeleted){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().build();
    }
}
