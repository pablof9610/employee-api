package com.personal.me.EmployeeManagement.exception;

import lombok.Getter;

@Getter
public class EmployeeNullPropException extends RuntimeException {
    private final String field;

    public EmployeeNullPropException(String field) {
        this.field = field;
    }
}
