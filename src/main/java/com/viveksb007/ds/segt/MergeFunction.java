package com.viveksb007.ds.segt;

import java.util.function.BiFunction;

public interface MergeFunction<A, B, C> extends BiFunction<A, B, C> {

    default C merge(A a, B b) {
        return apply(a, b);
    }

}