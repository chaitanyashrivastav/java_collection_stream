package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {
    PasswordValidator pv = new PasswordValidator() ;
    @Test
    void testValidPass() {
        assertTrue(pv.checkStrength("StrongPass1"));
    }

    @Test
    void testShortPassword() {
        assertFalse(PasswordValidator.checkStrength("Ab1"), "Password should be invalid (too short)");
    }

    @Test
    void testNoUppercase() {
        assertFalse(pv.checkStrength("password1"), "Password should be invalid (no uppercase letter)");
    }

    @Test
    void testNoDigit() {
        assertFalse(pv.checkStrength("Password"), "Password should be invalid (no digit)");
    }

    @Test
    void testNullPassword() {
        assertFalse(pv.checkStrength(null), "Password should be invalid (null input)");
    }

    @Test
    void testOnlyNumbers() {
        assertFalse(pv.checkStrength("12345678"), "Password should be invalid (no uppercase letter)");
    }

    @Test
    void testOnlyUppercase() {
        assertFalse(pv.checkStrength("PASSWORD"), "Password should be invalid (no digit)");
    }
}