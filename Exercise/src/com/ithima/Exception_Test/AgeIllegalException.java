package com.ithima.Exception_Test;

public class AgeIllegalException extends RuntimeException{
    public AgeIllegalException() {
    }

    public AgeIllegalException(String message) {
        super(message);
    }
}
