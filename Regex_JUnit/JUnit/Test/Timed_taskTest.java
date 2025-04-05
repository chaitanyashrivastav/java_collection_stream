package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.sql.Time;

import static org.junit.jupiter.api.Assertions.*;

class Timed_taskTest {
    @Test
    @Timeout(2) //test fails if execution time > 2 seconds
    void longRunningTask() {
        assertEquals("Task completed" , Timed_task.longRunningTask());
    }
}