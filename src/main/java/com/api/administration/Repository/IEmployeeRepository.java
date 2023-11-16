package com.api.administration.Repository;

import com.api.administration.Models.Department;
import com.api.administration.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface IEmployeeRepository extends JpaRepository<Employee, UUID> {
    Optional<Employee> findByName(String name);
}
