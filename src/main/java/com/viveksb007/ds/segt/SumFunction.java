package com.viveksb007.ds.segt;

public class SumFunction implements MergeFunction<Integer, Integer, Integer> {
    @Override
    public Integer apply(Integer a, Integer b) {
        if (a == null) return b;
        if (b == null) return a;
        return a + b;
    }
}
