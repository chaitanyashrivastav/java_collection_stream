package org.example;

import org.junit.jupiter.api.Test;

import java.time.format.DateTimeParseException;

import static org.junit.jupiter.api.Assertions.*;

class DateFormatterTest {
    DateFormatter df = new DateFormatter() ;
    @Test
    void test_method_formatDate() {
        assertEquals("01-04-2025",df.formatDate("2025-04-01"),"Invalid date format");
    }

    @Test
    void test_method_formatDate_Exception(){
        assertThrows(DateTimeParseException.class ,
                () -> {
            df.formatDate("abcd-ef-gh");
        }) ;
    }

}