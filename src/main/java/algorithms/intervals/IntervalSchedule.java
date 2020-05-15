package algorithms.intervals;

import java.util.Arrays;
import java.util.Comparator;

public class IntervalSchedule {
    public static void main(String[] args) {
        int[][] intvs = {{1, 3}, {2, 4}, {3, 6}};
        System.out.println(intervalScheduleSortEndsToSeparate(intvs));
        System.out.println(intervalScheduleSortStartsToMerge(intvs));
        System.out.println(eraseOverlapIntervals(intvs));
    }

    public static int intervalScheduleSortEndsToSeparate(int[][] intervals) {
        if (intervals.length == 0) return 0;
        // 按 end 升序排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        // 至少有一个区间不相交
        int count = 1;
        // 排序后，第一个区间就是 x
        int end = intervals[0][1];
        for (int[] interval : intervals) {
            int start = interval[0];
            if (start >= end) {
                // 找到下一个选择的区间了
                count++;
                end = interval[1];
            }
        }
        return count;
    }

    // TODO: 2020-05-15 Merge 
    public static int intervalScheduleSortStartsToMerge(int[][] intervals) {
        if (intervals.length == 0) return 0;
        // 按 end 升序排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        // 至少有一个区间不相交
        int count = 1;
        // 排序后，第一个区间就是 x
        int start = intervals[0][0];
        for (int[] interval : intervals) {
            int end = interval[1];
            if (start >= end) {
                // 找到下一个选择的区间了
                count++;
                start = interval[1];
            }
        }
        return count;
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        return intervals.length - intervalScheduleSortEndsToSeparate(intervals);
    }
}
