package com.viveksb007.gist;

import java.util.function.Function;

public class MultiplyBy3 implements Function<Integer, Integer> {
    @Override
    public Integer apply(Integer x) {
        return x * 3;
    }
}
