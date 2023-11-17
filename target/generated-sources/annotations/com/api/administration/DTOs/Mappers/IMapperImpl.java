package com.api.administration.DTOs.Mappers;

import com.api.administration.DTOs.DepartmentDTO;
import com.api.administration.DTOs.EmployeeDTO;
import com.api.administration.Models.Department;
import com.api.administration.Models.Employee;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-16T23:27:17+0200",
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
        employeeDTO.managerName = employeeManagerName( employee );
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
        employee.manager = employeeDTOToEmployee( employeeDTO );
        employee.name = employeeDTO.name;
        employee.email = employeeDTO.email;

        return employee;
    }

    @Override
    public DepartmentDTO toDto(Department department) {
        if ( department == null ) {
            return null;
        }

        DepartmentDTO departmentDTO = new DepartmentDTO();

        departmentDTO.parentDepartmentName = departmentParentDepartmentName( department );
        departmentDTO.id = department.id;
        departmentDTO.name = department.name;
        departmentDTO.description = department.description;
        List<Employee> list = department.employees;
        if ( list != null ) {
            departmentDTO.employees = new ArrayList<Employee>( list );
        }

        return departmentDTO;
    }

    @Override
    public Department to(DepartmentDTO departmentDTO) {
        if ( departmentDTO == null ) {
            return null;
        }

        Department department = new Department();

        department.parentDepartment = departmentDTOToDepartment( departmentDTO );
        department.id = departmentDTO.id;
        department.name = departmentDTO.name;
        department.description = departmentDTO.description;
        List<Employee> list = departmentDTO.employees;
        if ( list != null ) {
            department.employees = new ArrayList<Employee>( list );
        }

        return department;
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

    private String employeeManagerName(Employee employee) {
        if ( employee == null ) {
            return null;
        }
        Employee manager = employee.manager;
        if ( manager == null ) {
            return null;
        }
        String name = manager.name;
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

    protected Employee employeeDTOToEmployee(EmployeeDTO employeeDTO) {
        if ( employeeDTO == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.name = employeeDTO.managerName;

        return employee;
    }

    private String departmentParentDepartmentName(Department department) {
        if ( department == null ) {
            return null;
        }
        Department parentDepartment = department.parentDepartment;
        if ( parentDepartment == null ) {
            return null;
        }
        String name = parentDepartment.name;
        if ( name == null ) {
            return null;
        }
        return name;
    }

    protected Department departmentDTOToDepartment(DepartmentDTO departmentDTO) {
        if ( departmentDTO == null ) {
            return null;
        }

        Department department = new Department();

        department.name = departmentDTO.parentDepartmentName;

        return department;
    }
}
