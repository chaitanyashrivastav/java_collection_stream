package org.example;

class PasswordValidator{
    public static boolean checkStrength(String pwd){

      if(pwd == null || pwd.length() < 8){
          return false ;
      }

      boolean hasUpper = false ;
      boolean hasDigit = false ;

      for(char ch : pwd.toCharArray()){
          if ( Character.isUpperCase(ch) ) hasUpper = true ;
          if ( Character.isDigit(ch) ) hasDigit = true ;
      }

      return hasUpper && hasDigit ;
    }
}