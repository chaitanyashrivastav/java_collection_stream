package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseConnectionTest {
    DatabaseConnection db ;

    @BeforeEach
    void setup(){
        db = new DatabaseConnection();
        db.connect();
    }

    @AfterEach
    void teardown(){
        db.disconnect();
    }

    @Test
    void testConnectionIsEstablished() {
        assertTrue(db.isConnected());
    }

    @Test
    void testConnectionIsClosed() {
        db.disconnect() ;
        assertFalse(db.isConnected());
    }
}