package com.viveksb007.ques;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

// https://practice.geeksforgeeks.org/problems/largest-number-formed-from-an-array/0
/*
* Here's a super short template to do the sorting right away :

Collections.sort(people,new Comparator<Person>(){
   @Override
   public int compare(final Person lhs,Person rhs) {
     //TODO return 1 if rhs should be before lhs
     //     return -1 if lhs should be before rhs
     //     return 0 otherwise (meaning the order stays the same)
     }
 });
if it's hard to remember, try to just remember that it's similar (in terms of the sign of the number) to:

 lhs-rhs
That's in case you want to sort in ascending order : from smallest number to largest number.
* */
public class LargestNumberFormedFromAnArray {

    public static void main(String[] args) throws IOException {
        LargestNumberFormedFromAnArray largestNumberFormedFromAnArray = new LargestNumberFormedFromAnArray();
        largestNumberFormedFromAnArray.solve();
    }

    private void solve() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(reader.readLine());
            String[] nums = reader.readLine().split(" ");
            Arrays.sort(nums, (s1, s2) -> {
                int i = 0, j = 0;
                while (i < s1.length() && j < s2.length()) {
                    if (s1.charAt(i) > s2.charAt(j)) {
                        return -1;
                    } else if (s1.charAt(i) < s2.charAt(j)) {
                        return 1;
                    }
                    i++;
                    j++;
                }
                String s1s2 = s1 + s2;
                String s2s1 = s2 + s1;
                return s2s1.compareTo(s1s2);
            });
            StringBuilder sb = new StringBuilder();
            for (String str : nums) {
                sb.append(str);
            }
            pw.println(sb.toString());
        }
        pw.close();
    }

}
