package com.viveksb007.lc;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CacheTest {

    @Test
    public void testCache() {
        Cache cache = new LFUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        assertEquals(cache.get(1), 1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        assertEquals(cache.get(2), -1);       // returns -1 (not found)
        assertEquals(cache.get(3), 3);       // returns 3.
        cache.put(4, 4);    // evicts key 1.
        assertEquals(cache.get(1), -1);       // returns -1 (not found)
        assertEquals(cache.get(3), 3);       // returns 3
        assertEquals(cache.get(4), 4);       // returns 4
        assertEquals(cache.size(), 2);
        cache.put(1, 100);
        assertEquals(cache.get(1), 100);
        assertEquals(cache.get(4), -1);
        cache.put(4, 400);
        assertEquals(cache.get(1), -1);
    }

}
