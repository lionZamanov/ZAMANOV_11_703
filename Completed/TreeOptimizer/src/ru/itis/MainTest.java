package ru.itis;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }



    @Test
    public void test() throws Exception {
        assertEquals(7, Main.treeOptimize(1));
        assertEquals(4, Main.treeOptimize(2));
    }

}