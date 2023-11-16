package com.api.administration.Repository;

import com.api.administration.Models.Department;
import com.api.administration.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface IDepartmentRepository extends JpaRepository<Department, UUID> {
    Optional<Department> findByName(String name);
}
