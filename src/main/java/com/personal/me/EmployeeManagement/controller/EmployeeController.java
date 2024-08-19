package com.personal.me.EmployeeManagement.controller;

import com.personal.me.EmployeeManagement.model.EmployeeModel;
import com.personal.me.EmployeeManagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<EmployeeModel> getEmployees() {
        return employeeService.findAllEmployees();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<EmployeeModel> getEmployee(@PathVariable Long id) {
        var employeeFounded = employeeService.findEmployeeByID(id);
        return ResponseEntity.status(HttpStatus.OK).body(employeeFounded);
    }

    @PostMapping
    public ResponseEntity<EmployeeModel> saveEmployee(@RequestBody EmployeeModel employee) {
        var savedEmployee = employeeService.saveEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedEmployee);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<EmployeeModel> deleteEmployeeByID(@PathVariable Long id) {
        var employeeDeleted = employeeService.deleteEmployeeByID(id);
        return ResponseEntity.status(HttpStatus.OK).body(employeeDeleted);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<EmployeeModel> updateEmployeeByID(@PathVariable Long id, @RequestBody EmployeeModel employeeToUpdate) {
        var employeeUpdated = employeeService.updateEmployeeByID(id, employeeToUpdate);
        return ResponseEntity.status(HttpStatus.OK).body(employeeUpdated);
    }
}
