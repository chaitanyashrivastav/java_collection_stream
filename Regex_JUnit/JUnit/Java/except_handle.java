package org.example;

class except_handle{
    public void divide(int a, int b){
        if(b == 0 ){
            throw new ArithmeticException("denominator can't be 0") ;
        }
    }
}