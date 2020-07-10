package com.viveksb007.lc;

import java.util.Arrays;

public class MeetingRooms2 {

    public static void main(String[] args) {
        MeetingRooms2 meetingRooms2 = new MeetingRooms2();
        int[][] meetings = new int[][]{
                {0, 30},
                {5, 10},
                {15, 20},
                {18, 20}
        };
        int rooms = meetingRooms2.findMinRooms(meetings);
        System.out.println(rooms); // should be 3
    }

    private int findMinRooms(int[][] meetings) {
        int n = meetings.length;
        int[] start = new int[n];
        int[] end = new int[n];
        int i = 0, j = 0;
        for (int[] temp : meetings) {
            start[i] = temp[0];
            end[i++] = temp[1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int max = 0;
        int count = 0;
        i = 0;
        while (i < n) {
            if (start[i] < end[j]) {
                count++;
                max = Math.max(max, count);
                i++;
            } else {
                count--;
                j++;
            }
        }
        return count;
    }

}
