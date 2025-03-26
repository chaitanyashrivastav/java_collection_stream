package com.bridgelabz.collections.exceptionhandling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UncheckedException {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        try{
            int d=sc.nextInt();
            int div=sc.nextInt();
            System.out.println(d/div);
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero.");
        }catch (InputMismatchException e){
            System.out.println("Invalid input! Please enter numeric values.");
        }
    }
}
