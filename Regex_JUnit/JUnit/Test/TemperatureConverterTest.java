package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureConverterTest {
    TemperatureConverter tc = new TemperatureConverter() ;
    @Test
    void test_celsiusToFahrenheit() {
        assertEquals(212 , tc.celsiusToFahrenheit(100));
    }

    @Test
    void test_fahrenheitToCelsius() {
        assertEquals(100,tc.fahrenheitToCelsius(212));
    }
}