package com.viveksb007.algo;

public class TernarySearch {

    public int search(int[] arr, int n, int target) {
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid1 = l + (r - l) / 3;
            int mid2 = r - (r - l) / 3;
            if (arr[mid1] == target)
                return mid1;
            else if (arr[mid2] == target)
                return mid2;
            else if (arr[mid1] > target)
                r = mid1 - 1;
            else if (arr[mid2] < target)
                l = mid2 + 1;
            else {
                l = mid1 + 1;
                r = mid2 - 1;
            }
        }
        return -1;
    }

}
