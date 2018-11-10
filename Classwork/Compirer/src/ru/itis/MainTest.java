package ru.itis;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void main() {
    }

    Compirer compirer = new Compirer();

    @Test
    public void test1() throws Exception {
        try {
            compirer.analyze("x1:=5;x:=7;x3:=x1+x2;");
        } catch (Exception e) {
            assertEquals("Syntax broken",
                    e.getMessage());
        }
    }

    @Test
    public void test2() throws Exception {
        try {
            compirer.analyze("x1:=5;x2:=7;x3:=x1+x2;");
        } catch (Exception e) {
            assertEquals("Syntax broken",
                    e.getMessage());
        }
    }

    @Test
    public void test3() throws Exception {
        try {
            compirer.analyze("x1:=5;x:=7;x3:=x1x2;");
        } catch (Exception e) {
            assertEquals("Syntax broken",
                    e.getMessage());
        }
    }

    @Test
    public void test4() throws Exception {
       List<Var> list = compirer.process("x1:=5;x2:=7;x3:=x1+x2;");
            assertEquals(5, list.get(0).value);
            assertEquals(7, list.get(1).value);
            assertEquals(12, list.get(2).value);
    }


}