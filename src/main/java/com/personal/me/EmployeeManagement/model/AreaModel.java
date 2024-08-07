package com.personal.me.EmployeeManagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_area")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AreaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    public AreaModel(String name) {
        this.name = name;
    }
}
