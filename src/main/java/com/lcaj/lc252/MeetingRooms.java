package com.lcaj.lc252;

import com.lcaj.model.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by wangdehao on 19/5/13.
 */
public class MeetingRooms {
    public static void main(String[] args) {

        int[] interval1 = {7, 10};
        int[] interval2 = {2, 8};
        System.out.println(isOverlapped(interval1, interval2));

        int[][] intervals = {
                {0, 30},
                {5, 10},
                {15, 20},
                {6, 13}
        };
        System.out.println(canAttendMeetingsBF(intervals));
        System.out.println(canAttendMeetingsSort(intervals));
    }

    public static boolean canAttendMeetingsSort(int[][] intervals) {
//        List<Interval> intervalList = new ArrayList<>();
//        for (int[] interval : intervals) {
//            intervalList.add(new Interval(interval[0], interval[1]));
//        }
//        intervalList.sort(new Comparator<Interval>() {
//            @Override
//            public int compare(Interval o1, Interval o2) {
//                return o1.start - o2.start;
//            }
//        });
//        for (int i = 0; i < intervalList.size() - 1; i++) {
//
//            Interval left = intervalList.get(i);
//            Interval right = intervalList.get(i + 1);
//            if (left.end > right.start) {
//                return false;
//            }
//        }
//        return true;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }
        return true;
    }


    public static boolean canAttendMeetingsBF(int[][] intervals) {
        for (int i = 0; i < intervals.length - 1; i++) {
            int[] interval1 = intervals[i];
            for (int j = i + 1; j < intervals.length; j++) {
                int[] interval2 = intervals[j];
                if (isOverlapped(interval1, interval2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isOverlapped(int[] interval1, int[] interval2) {
        if (interval1[1] <= interval2[0] || interval2[1] <= interval1[0]) {
            return false;
        } else {
            return true;
        }
    }
}
