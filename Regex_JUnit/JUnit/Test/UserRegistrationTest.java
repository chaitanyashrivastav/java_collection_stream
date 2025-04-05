package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRegistrationTest {
UserRegistration ur = new UserRegistration();
    @Test
    void test_method_registerUser() {
        boolean result = ur.registerUser("divyam" ,"divyammanchanda89@ho_","helloWorld@123");
        assertTrue(result , "the input fields are not correctly typed");
    }
}