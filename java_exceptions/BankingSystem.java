package com.bridgelabz.collections.exceptionhandling.bankingsytem;

public class BankingSystem {
    public static double withdrawl(double wamt ,double bal) throws InsufficientBalanceException,IllegalArgumentException {
        if(wamt<0){
            throw new InsufficientBalanceException("Invalid Balance amount");
        }
        if(wamt>bal){
            throw new InsufficientBalanceException("Error caught Insufficient Balance");
        }
        return bal;
    }
    public static void main(String[] args) {
        try{
            BankingSystem.withdrawl(-5,1000);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
