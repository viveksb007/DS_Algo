package com.viveksb007.algo;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class RabinKarpAlgoTest {

    @Test
    public void shouldReturnTrueIfPatternFound() {
        RabinKarpAlgo rabinKarpAlgo = new RabinKarpAlgo();
        assertTrue(rabinKarpAlgo.find("THIS IS A TEST TEXT", "TEST"));
        assertTrue(rabinKarpAlgo.find("AABAACAADAABAABA", "AABA"));
        assertFalse(rabinKarpAlgo.find("AABAACAADAABAABA", "ABCD"));
        assertTrue(rabinKarpAlgo.find("asdasdfgvivek", "vivek"));
    }

}
