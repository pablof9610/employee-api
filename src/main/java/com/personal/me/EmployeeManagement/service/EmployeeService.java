package com.personal.me.EmployeeManagement.service;

import com.personal.me.EmployeeManagement.exception.EmployeeNullPropException;
import com.personal.me.EmployeeManagement.exception.EmployeeWageValueException;
import com.personal.me.EmployeeManagement.model.EmployeeModel;
import com.personal.me.EmployeeManagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeModel saveEmployee(EmployeeModel employeeToSave) {
        if (employeeToSave.getFirstName() == null)
            throw new EmployeeNullPropException("first name");

        if (employeeToSave.getLastName() == null)
            throw new EmployeeNullPropException("last name");

        if (employeeToSave.getArea() == null)
            throw new EmployeeNullPropException("area");

        if (employeeToSave.getWage() < 500)
            throw new EmployeeWageValueException();

        return employeeRepository.save(employeeToSave);
    }

    public List<EmployeeModel> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public EmployeeModel findEmployeeByID(Long id) {
        Optional<EmployeeModel> findedEmployee = employeeRepository.findById(id);
        if (findedEmployee.isEmpty())
            throw new NoSuchElementException();

        return findedEmployee.get();
    }

    public EmployeeModel deleteEmployeeByID(Long id) {
        EmployeeModel employeeToDelete = findEmployeeByID(id);
        employeeRepository.delete(employeeToDelete);
        return employeeToDelete;
    }

    public EmployeeModel updateEmployeeByID(Long id, EmployeeModel newEmployeeData) {
        EmployeeModel findedEmployee = findEmployeeByID(id);
        findedEmployee.matchEmployees(newEmployeeData);
        return findedEmployee;
    }
}
