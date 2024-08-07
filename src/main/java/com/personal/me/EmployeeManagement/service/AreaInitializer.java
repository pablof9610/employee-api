package com.personal.me.EmployeeManagement.service;

import com.personal.me.EmployeeManagement.model.Area;
import com.personal.me.EmployeeManagement.model.AreaModel;
import com.personal.me.EmployeeManagement.repository.AreaRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AreaInitializer {
    @Autowired
    private AreaRepository areaRepository;

    @PostConstruct
    public void init() {
        for(Area area : Area.values()) {
            if(areaRepository.findByName(area.getArea()) == null) {
                AreaModel areaModel = new AreaModel(area.getArea());
                areaRepository.save(areaModel);
            }
        }
    }
}
