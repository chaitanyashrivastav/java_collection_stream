package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class EvenNumberTest {

    @ParameterizedTest
    @ValueSource(ints={2, 4, 6, 8, 10}) //handling multiple test-cases
    void testIsEven(int number) {
        assertTrue(EvenNumber.isEven(number),number+"should be even");
    }
}