package com.personal.me.EmployeeManagement.service;

import com.personal.me.EmployeeManagement.model.EmployeeModel;
import com.personal.me.EmployeeManagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeModel saveEmployee(EmployeeModel employeeToSave) {
        return employeeRepository.save(employeeToSave);
    }

    public List<EmployeeModel> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<EmployeeModel> findEmployeeByID(Long id) {
        return employeeRepository.findById(id);
    }

    public Optional<EmployeeModel> deleteEmployeeByID(Long id) {
        Optional<EmployeeModel> findedEmployee = findEmployeeByID(id);
        if(findedEmployee.isEmpty()) {
            return Optional.empty();
        }
        employeeRepository.delete(findedEmployee.get());
        return findedEmployee;
    }
}
