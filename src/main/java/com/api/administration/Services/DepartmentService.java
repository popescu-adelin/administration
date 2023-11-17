package com.api.administration.Services;

import com.api.administration.DTOs.DepartmentDTO;
import com.api.administration.DTOs.Mappers.IMapper;
import com.api.administration.Models.Department;
import com.api.administration.Models.Employee;
import com.api.administration.Repository.IDepartmentRepository;
import com.api.administration.Services.Interfaces.IDepartmentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DepartmentService implements IDepartmentService {
    private final IDepartmentRepository _departmentRepository;
    private final IMapper _mapper;

    @Autowired
    public DepartmentService(IDepartmentRepository departmentRepository, IMapper mapper){
        _departmentRepository=departmentRepository;
        _mapper=mapper;
    }

    @Transactional
    public List<DepartmentDTO> getDepartments() {

        var departments = _departmentRepository.findAll();
        return departments.stream()
                .map(_mapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public DepartmentDTO addDepartment(DepartmentDTO departmentDTO) {
        var department = new Department();
        department.name=departmentDTO.name;
        department.description=departmentDTO.description;

        if(departmentDTO.parentDepartmentName != null && !departmentDTO.parentDepartmentName.isEmpty()){

            department.parentDepartment= _departmentRepository
                    .findByName(departmentDTO.parentDepartmentName).orElse(null);
        }

        var addedDepartment =  _departmentRepository.save(department);

        return _mapper.toDto(addedDepartment);
    }

    @Transactional
    public DepartmentDTO updateDepartment(DepartmentDTO departmentDto) {
        var department = _departmentRepository.findByName(departmentDto.name).orElseGet(null);
        if(department==null){
            return null;
        }
        department.description=departmentDto.description;

        if(departmentDto.parentDepartmentName != null && !departmentDto.parentDepartmentName.isEmpty() && department.parentDepartment.name != departmentDto.parentDepartmentName){

            department.parentDepartment= _departmentRepository
                    .findByName(departmentDto.parentDepartmentName).orElse(null);
        }

        var addedDepartment =  _departmentRepository.save(department);

        return _mapper.toDto(addedDepartment);
    }

    @Transactional
    public Boolean deleteDepartment(String id) {
        var departmentId = UUID.fromString(id);
        var department = _departmentRepository.findById(departmentId).orElse(null);

        if(department == null){
            return false;
        }

        try{
            _departmentRepository.delete(department);
        }
        catch (Exception ex){
            System.out.println(ex);
            return false;
        }

        return true;
    }

    @Transactional
    public Boolean moveDepartmentToExistingDepartment(String departmentName, String targetDepartmentName) {
        return null;
    }
}
