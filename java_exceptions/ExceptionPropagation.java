package com.bridgelabz.collections.exceptionhandling;

public class ExceptionPropagation {
    public static void method2(){
        method1();
    }

    private static void method1() {
        throw new ArithmeticException("division by zero");
    }

    public static void main(String[] args) {
        try{
            method2();
        } catch (Exception e) {
            System.out.println("Handled exception in main");
        }
    }
}
