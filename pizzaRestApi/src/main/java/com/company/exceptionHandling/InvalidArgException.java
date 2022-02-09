package com.company.exceptionHandling;

import java.util.function.Supplier;

public class InvalidArgException extends RuntimeException {

    private Integer code;
    public InvalidArgException(String message,Integer code) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return this.code;
    }
}
