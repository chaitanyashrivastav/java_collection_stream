package org.example ;

class UserRegistration{
    boolean registerUser(String username, String email, String password) throws IllegalArgumentException{
        if (username == null || username.isEmpty()){
            throw new IllegalArgumentException("username cant be null") ;
        }
        if (email == null || !email.matches( "^[A-Za-z0-9+_.-]+@(.+)$" )){
            throw new IllegalArgumentException("Email not written correctly") ;
        }
        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException("Password can't be shorter than 8 characters");
        }
        return true ;
    }
}