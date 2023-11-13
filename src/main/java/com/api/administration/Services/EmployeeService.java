package com.api.administration.Services;

import com.api.administration.DTOs.EmployeeDTO;
import com.api.administration.DTOs.Mappers.IMapper;
import com.api.administration.Models.Employee;
import com.api.administration.Repository.IEmployeeRepository;
import com.api.administration.Services.Interfaces.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;


@Service
public class EmployeeService implements IEmployeeService {
    private final IEmployeeRepository _employeeRepository;
    private final IMapper _mapper;

    @Autowired
    public EmployeeService(IEmployeeRepository employeeRepository, IMapper mapper){
        _employeeRepository=employeeRepository;
        _mapper=mapper;
    }

    public Collection<EmployeeDTO> getEmployees(){
        var employees = _employeeRepository.findAll();
        return employees.stream()
                .map(_mapper::toDto)
                .collect(Collectors.toList());
    }

    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO){
        var employee = _mapper.to(employeeDTO);
      var addedEmployee =  _employeeRepository.save(employee);
      return _mapper.toDto(addedEmployee);
    }
}
