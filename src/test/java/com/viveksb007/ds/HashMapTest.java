package com.viveksb007.ds;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

public class HashMapTest {

    @Test
    public void basicMapFunctions() {
        HashMap<String, Integer> map = new HashMap<>();
        String key = "abcd";
        map.put(key, key.length());
        assertEquals(4, map.getValue(key).intValue());
        String key1 = "xyz";
        map.put(key1, key1.length());
        assertEquals(3, map.getValue(key1).intValue());
        assertNull(map.getValue("yoman"));
    }


}
