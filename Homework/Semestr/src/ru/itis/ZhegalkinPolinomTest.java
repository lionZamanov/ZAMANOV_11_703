package ru.itis;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZhegalkinPolinomTest {
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    private ZhegalkinPolinom zhegalkinPolinom = new ZhegalkinPolinom("X2&X-3+X1&X2&X3");
    private ZhegalkinPolinom zhegalkinPolinom2 = new ZhegalkinPolinom("X2&X-3+X1&X2&X3+X1&X2");
    private byte[] a = {0, 1, 0, 1};

    @Test
    public void testGetString() throws Exception {
        assertEquals("X2&X-3+X1&X2&X3", zhegalkinPolinom.toString());
    }

    @Test
    public void testGetSum() throws Exception {
        //assertEquals("0", zhegalkinPolinom.sum(zhegalkinPolinom1).toString());

        assertEquals("X1&X2", zhegalkinPolinom.sum(zhegalkinPolinom2).toString());

    }

    @Test
    public void testGetValue() throws Exception {
        assertEquals(0, zhegalkinPolinom.value(a));
    }

    @Test
    public void testSortByLength() throws Exception {
        zhegalkinPolinom2.sortByLength();
        assertEquals("X1&X2&X3+X2&X-3+X1&X2", zhegalkinPolinom2.toString());
    }

    @Test
    public void testPolinomWith() throws Exception {
        zhegalkinPolinom2.polinomWith((byte)2);
        assertEquals("X2&X-2+X2&X2&X2+X2&X2", zhegalkinPolinom2.toString());
    }

}