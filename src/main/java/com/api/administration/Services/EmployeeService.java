package com.api.administration.Services;

import com.api.administration.DTOs.EmployeeDTO;
import com.api.administration.DTOs.Mappers.IMapper;
import com.api.administration.Models.Department;
import com.api.administration.Models.Employee;
import com.api.administration.Repository.IDepartmentRepository;
import com.api.administration.Repository.IEmployeeRepository;
import com.api.administration.Services.Interfaces.IEmployeeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class EmployeeService implements IEmployeeService {
    private final IEmployeeRepository _employeeRepository;
    private final IDepartmentRepository _departmentRepository;
    private final IMapper _mapper;

    @Autowired
    public EmployeeService(IEmployeeRepository employeeRepository,
                           IMapper mapper,
                           IDepartmentRepository departmentRepository){
        _employeeRepository=employeeRepository;
        _departmentRepository=departmentRepository;
        _mapper=mapper;
    }

    public Collection<EmployeeDTO> getEmployees(){
        var employees = _employeeRepository.findAll();
        return employees.stream()
                .map(_mapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO){
        var employee = new Employee();
        employee.name=employeeDTO.name;
        employee.email=employeeDTO.email;

        if(employeeDTO.departmentName != null && !employeeDTO.departmentName.isEmpty()){
            Department department = _departmentRepository
                    .findByName(employeeDTO.departmentName)
                    .orElseGet(() -> {
                        Department newDepartment= new Department();
                        newDepartment.name = employeeDTO.departmentName;
                        newDepartment.description ="No description";
                        return _departmentRepository.save(newDepartment);
                    });

            employee.department=department;
        }

        if(employeeDTO.managerName != null && !employeeDTO.managerName.isEmpty()){
            Optional<Employee> managerOpt = _employeeRepository
                    .findByName(employeeDTO.managerName);

            Employee manager = managerOpt.orElse(null);
            employee.manager=manager;
        }

        //var employee = _mapper.to(employeeDTO);
        var addedEmployee =  _employeeRepository.save(employee);

        return _mapper.toDto(addedEmployee);
    }

    @Transactional
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO){
        var employee = _employeeRepository.
                findByName(employeeDTO.name).
                orElseGet(null);
        if(employee ==  null){
            return null;
        }

        employee.email=employeeDTO.email;

        if(employeeDTO.departmentName != null && !employeeDTO.departmentName.isEmpty()){
            Department department = _departmentRepository
                    .findByName(employeeDTO.departmentName)
                    .orElseGet(() -> {
                        Department newDepartment= new Department();
                        newDepartment.name = employeeDTO.departmentName;
                        newDepartment.description ="No description";
                        return _departmentRepository.save(newDepartment);
                    });

            employee.department=department;
        }

        if(employeeDTO.managerName != null && !employeeDTO.managerName.isEmpty()){
            Optional<Employee> managerOpt = _employeeRepository
                    .findByName(employeeDTO.managerName);

            Employee manager = managerOpt.orElse(null);
            employee.manager=manager;
        }

        //var employee = _mapper.to(employeeDTO);
        var addedEmployee =  _employeeRepository.save(employee);

        var updatedEmployee =  _mapper.toDto(addedEmployee);

        return updatedEmployee;
    }

    @Transactional
    public Boolean deleteEmployeeById(String id){
        var userId = UUID.fromString(id);
        var employee = _employeeRepository.findById(userId).orElse(null);

        if(employee == null){
            return false;
        }

        try{
            _employeeRepository.delete(employee);
        }
        catch (Exception ex){
            System.out.println(ex);
            return false;
        }

        return true;
    }

    @Override
    public Collection<EmployeeDTO> getEmployeesFromDepartment(String departmentName) {
        var employees = _employeeRepository.findByDepartmentName(departmentName);
        return employees.stream()
                .map(_mapper::toDto)
                .collect(Collectors.toList());
    }
}
