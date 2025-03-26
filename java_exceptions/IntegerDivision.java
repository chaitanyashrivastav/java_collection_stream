package com.bridgelabz.collections.exceptionhandling;

import java.util.Scanner;

public class IntegerDivision {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        try{
            int n=sc.nextInt();
            int n2=sc.nextInt();
            int ans=n/n2;
            System.out.println(ans);
        } catch (ArithmeticException e) {
            System.out.println("Error caught: "+e.getMessage());
        }finally {
            System.out.println("Operation completed");
        }
    }
}
