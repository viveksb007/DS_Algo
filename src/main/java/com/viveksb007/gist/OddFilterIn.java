package com.viveksb007.gist;

import java.util.function.Predicate;

public class OddFilterIn implements Predicate<Integer> {
    @Override
    public boolean test(Integer x) {
        return x % 2 != 0;
    }
}
