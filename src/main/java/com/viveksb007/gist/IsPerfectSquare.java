package com.viveksb007.gist;

import java.util.function.Predicate;

public class IsPerfectSquare implements Predicate<Integer> {
    @Override
    public boolean test(Integer x) {
        return Math.floor(Math.sqrt(x)) == Math.sqrt(x);
    }
}
