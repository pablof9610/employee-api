package com.personal.me.EmployeeManagement.repository;

import com.personal.me.EmployeeManagement.model.AreaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AreaRepository extends JpaRepository<AreaModel, Long> {
    AreaModel findByName(String name);
}
