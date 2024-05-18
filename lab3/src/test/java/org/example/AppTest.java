package org.example;

import junit.framework.TestCase;
import junit.framework.Test;
import junit.framework.TestSuite;

public class AppTest extends TestCase {

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Test method for App.add()
     */
    public void testAdd() {
        assertEquals(5, App.add(2, 3));
    }

    /**
     * Rigorous Test :-)
     */
    public void testApp() {
        assertTrue(true);
    }
}

