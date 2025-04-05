package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {
    StringUtils obj = new StringUtils() ;
    @Test
    void rev() {
        assertEquals("olleh",obj.rev("hello"));
    }

    @Test
    void isPalindrome() {
        assertEquals(true , obj.isPalindrome("madam"));
    }

    @Test
    void toUpper() {
        assertEquals("HELLO", obj.toUpper("hello"));
    }
}