package com.api.administration.Controller;

import com.api.administration.DTOs.DepartmentDTO;
import com.api.administration.DTOs.EmployeeDTO;
import com.api.administration.DTOs.MoveDepartmentDto;
import com.api.administration.Models.Department;
import com.api.administration.Repository.IDepartmentRepository;
import com.api.administration.Services.Interfaces.IDepartmentService;
import com.api.administration.Services.Interfaces.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
    private final IDepartmentService _departmentService;

    @Autowired
    public DepartmentController(IDepartmentService departmentService){
        _departmentService=departmentService;
    }

    @GetMapping()
    public List<DepartmentDTO> getEmployees(){
        return _departmentService.getDepartments();
    }

    @PostMapping()
    public DepartmentDTO addEmploye(@RequestBody DepartmentDTO departmentDto){
        var department = _departmentService.addDepartment(departmentDto);
        return department;
    }

    @PutMapping()
    public ResponseEntity<Department> updateEmployee(@RequestBody Department departmentDto){
        var department = _departmentService.updateDepartment(departmentDto);
        if(department == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(department);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable String id){
        var isDeleted = _departmentService.deleteDepartment(id);
        if(!isDeleted){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().build();
    }

    @PutMapping("/moveDepartment")
    public ResponseEntity<Void> moveDepartment(@RequestBody MoveDepartmentDto data){
        _departmentService.moveDepartmentToExistingDepartment(data.departmentName, data.targetDepartmentName);
        return  ResponseEntity.ok().build();
    }
}
