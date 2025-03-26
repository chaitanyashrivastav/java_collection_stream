package com.bridgelabz.collections.exceptionhandling.bankingsytem;

public class InsufficientBalanceException extends Exception{
    private String message;

    public InsufficientBalanceException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
