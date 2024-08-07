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

//    public String employeeJsonFormatter(List<EmployeeModel> employeeList) {
//        String employeeJsonFormatted = null;
//        for (EmployeeModel employee : employeeList) {
//            employeeJsonFormatted += "{\"firstName" +
//                    "\": \"" +employee.getFirstName()+"\"},";
//        }
//        System.out.println(employeeJsonFormatted);
//        return employeeJsonFormatted;
//    }
}
