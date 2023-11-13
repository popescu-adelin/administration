package com.api.administration.DTOs.Mappers;

import com.api.administration.DTOs.EmployeeDTO;
import com.api.administration.Models.Department;
import com.api.administration.Models.Employee;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-06T10:25:37+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class IMapperImpl implements IMapper {

    @Override
    public EmployeeDTO toDto(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.departmentName = employeeDepartmentName( employee );
        employeeDTO.name = employee.name;
        employeeDTO.email = employee.email;

        return employeeDTO;
    }

    @Override
    public Employee to(EmployeeDTO employeeDTO) {
        if ( employeeDTO == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.department = employeeDTOToDepartment( employeeDTO );
        employee.name = employeeDTO.name;
        employee.email = employeeDTO.email;

        return employee;
    }

    private String employeeDepartmentName(Employee employee) {
        if ( employee == null ) {
            return null;
        }
        Department department = employee.department;
        if ( department == null ) {
            return null;
        }
        String name = department.name;
        if ( name == null ) {
            return null;
        }
        return name;
    }

    protected Department employeeDTOToDepartment(EmployeeDTO employeeDTO) {
        if ( employeeDTO == null ) {
            return null;
        }

        Department department = new Department();

        department.name = employeeDTO.departmentName;

        return department;
    }
}
