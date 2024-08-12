package com.personal.me.EmployeeManagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_employee")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;

    // MAPEIA O ENUM COMO STRING
    @Enumerated(EnumType.STRING)
    @Column(name = "area", nullable = false)
    private Area area;

    private String specialization;
    private int wage;

    public void matchEmployees(EmployeeModel employeeUpdated) {
        this.setFirstName(employeeUpdated.getFirstName());
        this.setLastName(employeeUpdated.getLastName());
        this.setLastName(employeeUpdated.getLastName());
        this.setSpecialization(employeeUpdated.getSpecialization());
        this.setWage(employeeUpdated.getWage());
    }
}
