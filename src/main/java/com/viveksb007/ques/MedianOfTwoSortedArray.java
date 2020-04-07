package com.viveksb007.ques;

// https://www.youtube.com/watch?v=LPFhl65R7ww
public class MedianOfTwoSortedArray {

    public static void main(String[] args) {
        MedianOfTwoSortedArray medianOfTwoSortedArray = new MedianOfTwoSortedArray();
        int[] x = new int[]{23, 26, 31, 35};
        int[] y = new int[]{3, 5, 7, 9, 11, 16};
        double median = medianOfTwoSortedArray.findMedian(x, y);
        System.out.println(median); // 13.5
        x = new int[]{1, 2, 3, 4, 5};
        y = new int[]{6, 7, 8, 9, 10};
        median = medianOfTwoSortedArray.findMedian(x, y);
        System.out.println(median); // 5.5
    }

    private double findMedian(int[] x, int[] y) {
        if (x.length > y.length) {
            return findMedian(y, x);
        }
        int start = 0;
        int end = x.length;
        while (start <= end) {
            int partX = (start + end) / 2;
            int partY = (x.length + y.length + 1) / 2 - partX;
            int maxLeftX, maxLeftY, minRightX, minRightY;
            maxLeftX = (partX == 0) ? Integer.MIN_VALUE : x[partX - 1];
            minRightX = (partX == x.length) ? Integer.MAX_VALUE : x[partX];
            maxLeftY = (partY == 0) ? Integer.MIN_VALUE : y[partY - 1];
            minRightY = (partY == y.length) ? Integer.MAX_VALUE : y[partY];
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((x.length + y.length) % 2 == 0)
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / (double) 2;
                return Math.max(maxLeftX, maxLeftY);
            } else if (maxLeftX > minRightY)
                end = partX - 1;
            else start = partX + 1;
        }
        return 0;
    }

}
