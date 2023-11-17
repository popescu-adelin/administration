package com.api.administration.DTOs.Mappers;

import com.api.administration.DTOs.DepartmentDTO;
import com.api.administration.DTOs.EmployeeDTO;
import com.api.administration.Models.Department;
import com.api.administration.Models.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface IMapper {
    IMapper INSTANCE = Mappers.getMapper(IMapper.class);

    @Mapping(source = "department.name", target = "departmentName")
    @Mapping(source = "manager.name", target = "managerName")
    EmployeeDTO toDto(Employee employee);

    @Mapping(source = "departmentName", target = "department.name")
    @Mapping(source = "managerName", target = "manager.name")
    Employee to(EmployeeDTO employeeDTO);

    @Mapping(source = "parentDepartment.name", target = "parentDepartmentName")
    DepartmentDTO toDto(Department department);

    @Mapping(source = "parentDepartmentName", target = "parentDepartment.name")
    Department to(DepartmentDTO departmentDTO);
}
