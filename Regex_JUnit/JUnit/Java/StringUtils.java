package org.example;

class StringUtils{
    public String rev(String str){
        StringBuilder sb = new StringBuilder(str) ;
        return sb.reverse().toString();
    }

    public boolean isPalindrome(String str){
        StringBuilder sb = new StringBuilder(str) ;
        return (sb.reverse().toString().equals(str)) ;
    }

    public String toUpper(String str){
        return str.toUpperCase();
    }
}