package com.api.administration.Controller;

import com.api.administration.DTOs.EmployeeDTO;
import com.api.administration.Services.Interfaces.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.web.client.HttpClientErrorException.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200" )
@RequestMapping("/api/employee")
public class EmployeeController {
    private final IEmployeeService _employeeService;

    @Autowired
    public EmployeeController(IEmployeeService employeeService){
        _employeeService=employeeService;
    }

    @GetMapping()
    public ResponseEntity<List<EmployeeDTO>> getEmployees(){
        var employees = _employeeService.getEmployees();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable String id){
        var employee = _employeeService.getEmployeeById(id);
        if(employee == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employee);
    }

    @PostMapping()
    public ResponseEntity<EmployeeDTO> addEmploye(@RequestBody EmployeeDTO employeeDTO){
        var employee = _employeeService.addEmployee(employeeDTO);
        if(employee==null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(employee);
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

    @GetMapping("/getByDepartment")
    public ResponseEntity<Collection<EmployeeDTO>> getEmployeesByDepartment(@RequestParam String departmentName){
        var employees = _employeeService.getEmployeesFromDepartment(departmentName);
        return ResponseEntity.ok(employees);
    }
}
