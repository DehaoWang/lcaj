package com.lcaj.lc56;

import datastructures.basic.interval.Interval;

import java.util.*;

/**
 * Created by wangdehao on 18/11/11.
 */
public class MergeIntervals {
    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        Interval i1 = new Interval(1, 4);
        Interval i2 = new Interval(0, 4);
//        Interval i3 = new Interval(3, 5);
//        List<Interval> res = merge2Intervals(i1, i2);
        intervals.add(i1);
        intervals.add(i2);
//        intervals.add(i3);

        System.out.println(merge(intervals));
    }

    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1) {
            return intervals;
        }
        List<Interval> mergedIntervals = new ArrayList<>();
        Collections.sort(intervals, new IntervalComparator());
        Interval current = new Interval();
        for (Interval interval : intervals) {
            if (mergedIntervals.isEmpty() || interval.start > current.end) {
                mergedIntervals.add(interval);
                current = interval;
            } else {
                current.end = current.end > interval.end ? current.end : interval.end;
            }
        }
        return mergedIntervals;
    }

    private static class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
        }
    }

    // divide and conquer : may not work because the subproblem is not smaller
    public static List<Interval> mergeDnC(List<Interval> intervals) {
        List<Interval> intervalList = new ArrayList<>();
        int length = intervals.size();
        if (length <= 1) {
            return intervals;
        } else if (length == 2) {
            return merge2Intervals(intervals.get(0), intervals.get(1));
        } else {
            int half = length / 2;
            List<Interval> partL = getIntervalsByLR(intervals, 0, half);
            List<Interval> partR = getIntervalsByLR(intervals, half + 1, length - 1);
        }
        return intervalList;
    }

    private static List<Interval> getIntervalsByLR(List<Interval> intervals, int l, int r) {
        List<Interval> result = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            Interval intervalOld = intervals.get(i);
            Interval intervalNew = new Interval(intervalOld.start, intervalOld.end);
            result.add(intervalNew);
        }
        return result;
    }

    public static List<Interval> merge2Intervals(Interval i1, Interval i2) {
        List<Interval> result = new ArrayList<>();
        if (i1.start > i2.end || i1.end < i2.start) {
            result.add(i1);
            result.add(i2);
        } else {
            int start = i1.start > i2.start ? i2.start : i1.start;
            int end = i1.end > i2.end ? i1.end : i2.end;
            result.add(new Interval(start, end));
        }
        return result;
    }
}
