package com.company.exceptionHandling;


public enum StaticExceptions {

    USER_NOT_FOUND(101);

    int value;
    StaticExceptions(int value) {
        this.value=value;
    }

    public int getValue(){
        return this.value;
    }
}
