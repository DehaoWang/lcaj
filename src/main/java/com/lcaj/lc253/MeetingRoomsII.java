package com.lcaj.lc253;

import java.util.*;

/**
 * Created by wangdehao on 19/5/13.
 */
public class MeetingRoomsII {
    public static void main(String[] args) {
        int[][] intervals = {
                {0, 30},
                {5, 10},
                {15, 20},
        };
        System.out.println(minMeetingRooms(intervals));
        System.out.println(minMeetingRoomsIndividual(intervals));

        int[][] intervals2 = {
                {7, 10},
                {2, 4},
        };
        System.out.println(minMeetingRooms(intervals2));
        System.out.println(minMeetingRoomsIndividual(intervals2));

        int[][] intervals3 = {
                {2, 15},
                {36, 45},
                {9, 29},
                {16, 23},
                {4, 9},
        };
        System.out.println(minMeetingRooms(intervals3));
        System.out.println(minMeetingRoomsIndividual(intervals3));

        int[][] intervals4 = {
                {9, 10},
                {4, 9},
                {4, 17},
        };
        System.out.println(minMeetingRooms(intervals4));
        System.out.println(minMeetingRoomsIndividual(intervals4));

        int[][] intervals5 = {
                {1, 5},
                {8, 9},
                {8, 9},
        };
        System.out.println(minMeetingRooms(intervals5));
        System.out.println(minMeetingRoomsIndividual(intervals5));
    }

    public static int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        TreeSet<Integer> earliestTimeTree = new TreeSet<>();
        int roomNumNeeded = 1;
        earliestTimeTree.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            // best?
            int earliestTime = earliestTimeTree.first();
            if (intervals[i][0] < earliestTime) {
                roomNumNeeded++;
            } else {
                earliestTimeTree.pollFirst();
            }
            earliestTimeTree.add(intervals[i][1]);
        }
        return roomNumNeeded;
    }

    public static int minMeetingRoomsIndividual(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
            return 0;
        }
        int len = intervals.length;
        int[] starts = new int[len];
        int[] ends = new int[len];
        for (int i = 0; i < len; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int sp = 0;
        int ep = 0;
        int roomNum = 0;
        while (sp < len) {
            if (starts[sp] < ends[ep]) {
                roomNum++;
            } else {
                ep++;
            }
            sp++;
        }
        return roomNum;
    }

}
