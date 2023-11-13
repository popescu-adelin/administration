package com.api.administration.DTOs.Mappers;

import com.api.administration.DTOs.EmployeeDTO;
import com.api.administration.Models.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface IMapper {
    IMapper INSTANCE = Mappers.getMapper(IMapper.class);

    @Mapping(source = "department.name", target = "departmentName")
    EmployeeDTO toDto(Employee employee);

    @Mapping(source = "departmentName", target = "department.name")
    Employee to(EmployeeDTO employeeDTO);
}
