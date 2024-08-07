package com.personal.me.EmployeeManagement.controller;

import com.personal.me.EmployeeManagement.model.EmployeeModel;
import com.personal.me.EmployeeManagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        Optional<EmployeeModel> employee = employeeService.findEmployeeByID(id);
        return employee.map(emp -> ResponseEntity.ok().body(emp))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity saveEmployee(@RequestBody EmployeeModel employee) {
        EmployeeModel savedEmployee = employeeService.saveEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Employee saved with ID: "+ savedEmployee.getId());
    }
}
