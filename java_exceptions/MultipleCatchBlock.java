package com.bridgelabz.collections.exceptionhandling;

import java.util.Scanner;

public class MultipleCatchBlock {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        try{
            int n=sc.nextInt();
            String arr[]=new String[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.next();
            }
            int idx=sc.nextInt();

            System.out.println(arr[idx]);
            String s=null;
            System.out.println(s.length());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error caught: "+e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Error caught: "+e.getMessage());
        }
    }
}
