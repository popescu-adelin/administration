package com.api.administration.Repository;

import com.api.administration.Models.Department;
import com.api.administration.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IEmployeeRepository extends JpaRepository<Employee, UUID> {
    Optional<Employee> findByName(String name);
    List<Employee> findByDepartmentName(String departmentName);

    List<Employee> findByManagerId(UUID id);
}
