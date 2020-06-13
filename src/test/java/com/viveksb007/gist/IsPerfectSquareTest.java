package com.viveksb007.gist;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class IsPerfectSquareTest {

    private IsPerfectSquare isPerfectSquare;

    @BeforeClass
    public void setUp() {
        isPerfectSquare = new IsPerfectSquare();
    }

    @Test
    public void shouldReturnTrueForPerfectSquare() {
        assertTrue(isPerfectSquare.test(81));
        assertTrue(isPerfectSquare.test(36));
    }

    @Test
    public void shouldReturnFalseIfNumberIsNotPerfectSquare() {
        assertFalse(isPerfectSquare.test(8));
        assertFalse(isPerfectSquare.test(15));
    }

}
