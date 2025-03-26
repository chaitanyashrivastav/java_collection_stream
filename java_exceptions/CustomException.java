package com.bridgelabz.collections.exceptionhandling.customexception;

import java.util.Scanner;

import static com.bridgelabz.collections.exceptionhandling.customexception.AgeValidator.validateAge;

public class CustomException {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter age: ");
        try{
            int age=sc.nextInt();
            validateAge(age);
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter a valid age.");
        }
    }


}
