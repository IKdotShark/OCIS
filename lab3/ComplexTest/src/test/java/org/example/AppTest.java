package org.example;

import junit.framework.TestCase;

public class AppTest extends TestCase {

    public void testFactorialZero() {
        assertEquals(1, App.factorial(0));
    }

    public void testFactorialOne() {
        assertEquals(1, App.factorial(1));
    }

    public void testFactorialFive() {
        assertEquals(120, App.factorial(5));
    }

    public void testFactorialTen() {
        assertEquals(3628800, App.factorial(10));
    }

    public void testFactorialNegative() {
        try {
            App.factorial(-1);
            fail("Expected IllegalArgumentException for negative number");
        } catch (IllegalArgumentException e) {
            assertEquals("Number must be non-negative", e.getMessage());
        }
    }
}

