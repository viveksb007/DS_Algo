package com.viveksb007;

import java.util.Arrays;

public class SplitTest {

    public static void main(String[] args) {
        String str = "/a/b/c/ce";
        System.out.println(Arrays.toString(str.split("/")));
        str = "abbbb     bss  sa";
        System.out.println(Arrays.toString(str.split(" ")));
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
