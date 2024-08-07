package com.personal.me.EmployeeManagement.repository;

import com.personal.me.EmployeeManagement.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long> {
}
