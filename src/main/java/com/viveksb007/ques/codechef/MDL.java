package com.viveksb007.ques.codechef;

public class MDL {

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int t = reader.nextInt();
        while (t-- > 0) {
            int n = reader.nextInt();
            int minVal = Integer.MAX_VALUE, minIndex = 0;
            int maxVal = Integer.MIN_VALUE, maxIndex = 0;
            for (int i = 0; i < n; i++) {
                int temp = reader.nextInt();
                if (temp < minVal) {
                    minVal = temp;
                    minIndex = i;
                }
                if (temp > maxVal) {
                    maxVal = temp;
                    maxIndex = i;
                }
            }
            if (minIndex < maxIndex) {
                System.out.println(minVal + " " + maxVal);
            } else {
                System.out.println(maxVal + " " + minVal);
            }
        }
    }

}
