package algorithms.intervals;

import algorithms.utils.MatrixUtils;

import java.util.ArrayList;
import java.util.List;

import static algorithms.intervals.IntervalSchedule.unionSortStarts;

public class IntervalInsert {
    public static void main(String[] args) {
        int[][] intvs = {{1, 3}, {6, 9}};
        int[] newIntv = {2, 5};
        MatrixUtils.printMatrix(insertByUnion(intvs, newIntv));

    }

    public static int[][] insertByUnion(int[][] intervals, int[] newInterval) {
        int len = intervals.length;
        int[][] plusOne = new int[len + 1][2];
        for (int i = 0; i < len; i++) {
            plusOne[i] = intervals[i];
        }
        plusOne[len] = newInterval;
        return unionSortStarts(plusOne);
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> resList = new ArrayList<>();
        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }


        // step 1: (binary) search for location
        // step 2: determine end


        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 0; i < intervals.length; i++) {

        }


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
//                start = Math.min(start, currS);
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
}
