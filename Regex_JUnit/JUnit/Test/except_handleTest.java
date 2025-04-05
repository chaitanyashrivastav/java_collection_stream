package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class except_handleTest {
    except_handle obj = new except_handle() ;
    @Test
    void testDivide() {
        assertThrows(ArithmeticException.class,
                () -> {
            obj.divide(10,0);
                }
        );
    }
}