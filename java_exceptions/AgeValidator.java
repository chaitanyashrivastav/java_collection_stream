package com.bridgelabz.collections.exceptionhandling.customexception;

public class AgeValidator {
    public static void validateAge(int age) throws InvalidAgeException{
        if(age<18){
            System.out.println("Age Must be 18 or above");
        }else {
            System.out.println("Access Granted");
        }
    }
}
