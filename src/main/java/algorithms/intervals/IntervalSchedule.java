package algorithms.intervals;

import algorithms.utils.ArrayUtils;
import algorithms.utils.MatrixUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class IntervalSchedule {
    public static void main(String[] args) {
        int[][] intvs = {{1, 3}, {2, 4}, {3, 6}};
        System.out.println(intervalScheduleSortEndsToSeparate(intvs));
        System.out.println(intervalScheduleSortStartsToSeparate(intvs));
        System.out.println(eraseOverlapIntervals(intvs));

        int[][] intvs1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        MatrixUtils.printMatrix(intervalScheduleSortStartsToMerge(intvs1));
        MatrixUtils.printMatrix(intervalScheduleSortEndsToMerge(intvs1));

    }


    public static int intervalScheduleSortEndsToSeparate(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }        // 按 end 升序排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        // 至少有一个区间不相交
        int count = 1;
        // 排序后，第一个区间就是 x
        int end = intervals[0][1];
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int start = interval[0];
            if (start >= end) {
                // 找到下一个选择的区间了
                count++;
                end = interval[1];
            }
        }
        return count;
    }

    public static int intervalScheduleSortStartsToSeparate(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }        // 按 end 升序排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        // 至少有一个区间不相交
        int count = 1;
        // 排序后，第一个区间就是 x
        int len = intervals.length;
        int start = intervals[len - 1][0];
        for (int i = len - 1; i >= 0; i--) {
            int[] interval = intervals[i];
            int end = interval[1];
            if (end <= start) {
                // 找到下一个选择的区间了
                count++;
                start = interval[0];
            }
        }
        return count;
    }

    public static int[][] intervalScheduleSortStartsToMerge(int[][] intervals) {
        List<int[]> resList = new ArrayList<>();
        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }
        // 按 start 升序排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int currS = interval[0];
            int currE = interval[1];
            if (currS > end) {
                // new interval
                resList.add(new int[]{start, end});
                start = currS;
                end = currE;
            } else {
                start = Math.min(start, currS);
                end = Math.max(end, currE);
            }
        }
        resList.add(new int[]{start, end});
        int[][] res = new int[resList.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = resList.get(i);
        }
        return res;
    }

    // TODO: 2020-05-15
    public static int[][] intervalScheduleSortEndsToMerge(int[][] intervals) {
        List<int[]> resList = new ArrayList<>();
        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }
        // 按 end 升序排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });

        int len = intervals.length;
        // visit backwards
        int start = intervals[len - 1][0];
        int end = intervals[len - 1][1];

        for (int i = len - 1; i >= 0; i--) {
            int[] interval = intervals[i];
            int currS = interval[0];
            int currE = interval[1];
            if (currE < start) {
                // new interval
                resList.add(new int[]{start, end});
                start = currS;
                end = currE;
            } else {
                start = Math.min(start, currS);
                end = Math.max(end, currE);
            }
        }
        resList.add(new int[]{start, end});
        int[][] res = new int[resList.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = resList.get(i);
        }
        return res;
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        return intervals.length - intervalScheduleSortEndsToSeparate(intervals);
    }

    // lc 452
    public static int finMinArrowShots(int[][] points) {
        int[][] intervals = points;
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
            if (start > end) {
                // 找到下一个选择的区间了
                count++;
                end = interval[1];
            }
        }
        return count;
    }
}
