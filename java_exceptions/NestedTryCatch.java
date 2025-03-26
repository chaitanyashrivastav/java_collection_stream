package com.bridgelabz.collections.exceptionhandling;

import java.util.Scanner;

public class NestedTryCatch {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int arr[]={20,20,40,60};
        int div= sc.nextInt();
        try{
            System.out.println("Enter the index");
            int n=sc.nextInt();
            try{
                System.out.println(arr[n]/div);
            }catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }  catch (Exception e) {
            System.out.println("An error occured");
        }
    }
}
