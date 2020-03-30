package com.viveksb007.ques.gfg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class SearchInRotatedSorted {

    public static void main(String[] args) throws IOException {
        SearchInRotatedSorted searchInRotatedSorted = new SearchInRotatedSorted();
        searchInRotatedSorted.solve();
    }

    private void solve() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(reader.readLine());
            String[] inp = reader.readLine().split(" ");
            int k = Integer.parseInt(reader.readLine());
            int[] arr = new int[inp.length];
            for (int i = 0; i < inp.length; i++) {
                arr[i] = Integer.parseInt(inp[i]);
            }
            pw.println(findIndex(arr, k));
        }
        pw.close();
    }

    private int findIndex(int[] arr, int k) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] < arr[end])
                end = mid;
            else if (arr[mid] > arr[end])
                start = mid + 1;
        }

        int rot = start;
        start = 0;
        end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int realMid = (mid + rot) % arr.length;
            if (arr[realMid] == k) {
                return realMid;
            } else if (arr[realMid] < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

}
