package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ListManagerTest {
    private ListManager obj ;
    private ArrayList<Integer> list ;

    @BeforeEach
    void setup(){
        obj = new ListManager() ;
        list = new ArrayList<>() ;
    }
    @Test
    void testaddElement() {
        obj.addElement(list , 5) ;
        assertTrue(list.contains(5));
    }

    @Test
    void testRemoveElement() {
        obj.addElement(list,4);
        obj.removeElement(list,4);
        assertFalse(list.contains(4));
    }

    @Test
    void testGetSize() {
        obj.addElement(list,4);
        obj.addElement(list,5);
        obj.addElement(list,6);
        assertEquals(3,obj.getSize(list));
    }
}