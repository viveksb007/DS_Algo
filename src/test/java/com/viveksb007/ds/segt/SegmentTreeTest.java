package com.viveksb007.ds.segt;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SegmentTreeTest {

    @Test
    public void testSegmentTreeForRangeSumQueryProblems() {
        Integer[] arr = new Integer[]{1, 3, 5, 7, 9, 11};
        SegmentTree segmentTree = new SegmentTree(arr, new SumFunction());
        int result = segmentTree.findQuery(2, 4, arr);
        assertEquals(21, result);
        segmentTree.updateElement(3, 8, arr);
        result = segmentTree.findQuery(2, 4, arr);
        assertEquals(22, result);
        segmentTree.updateElement(0, 3, arr);
        result = segmentTree.findQuery(0, 5, arr);
        assertEquals(39, result);
    }

    @Test
    public void testSegmentTreeForMinRangeQueryProblems() {
        Integer[] arr = new Integer[]{1, 3, 2, 7, 9, 11};
        SegmentTree segmentTree = new SegmentTree(arr, new MinFunction());
        int result = segmentTree.findQuery(1, 5, arr);
        assertEquals(2, result);
        segmentTree.updateElement(2, -1, arr);
        result = segmentTree.findQuery(1, 5, arr);
        assertEquals(-1, result);
        segmentTree.updateElement(5, 8, arr);
        result = segmentTree.findQuery(4, 5, arr);
        assertEquals(8, result);
    }

    @Test
    public void testSegmentTreeForRangeXORProblems() {
        Integer[] arr = new Integer[]{1, 3, 5, 7, 9, 11};
        SegmentTree segmentTree = new SegmentTree(arr, new XorFunction());
        int result = segmentTree.findQuery(1, 3, arr);
        assertEquals(1, result);
        segmentTree.updateElement(1, 10, arr);
        result = segmentTree.findQuery(1, 3, arr);
        assertEquals(8, result);
    }

    @Test
    public void testArraySizeForTreeLogic() {
        assertEquals(15, SegmentTree.findArraySizeToRepresentTree(8));
        assertEquals(15, SegmentTree.findArraySizeToRepresentTree(6));
        assertEquals(31, SegmentTree.findArraySizeToRepresentTree(10));
    }

}
