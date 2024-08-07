package com.personal.me.EmployeeManagement.model;

public enum Area {
    DEVELOPMENT("Development"),
    HUMAN_RESOURCES("Human Resources"),
    INFRASTRUCTURE("Infrastructure") ;

    private final String area;

    Area(String name) {
        this.area = name;
    }

    public String getArea() {
        return this.area;
    }

    public static Area fromValue(String value) {
        for (Area area : Area.values()) {
            if(area.getArea().equalsIgnoreCase(value)) {
                return area;
            }
        }
        throw new IllegalArgumentException("Invalid value: "+ value);
    }
}
