package algorithms.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TemplateISTBD {
    public static final int DISJOINT = 0;
    public static final int UNION = 1;

    public static List<int[]> intervalSchedule(int[][] intervals, boolean sortStarts, int type) {
        List<int[]> res = new ArrayList<>();
        if (intervals == null || intervals.length == 0) {
            return new ArrayList<>();
        }
        // 按 end 升序排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return sortStarts ? a[0] - b[0] : a[1] - b[1];
            }
        });
        // 至少有一个区间不相交
        int count = 1;
        // 排序后，第一个区间就是 x
        int end = intervals[0][1];

//        int i = type == DISJOINT && ! sortStarts
        if (type == DISJOINT)

            for (int i = 0; i < intervals.length; i++) {
                int[] interval = intervals[i];
                int start = interval[0];
                if (start >= end) {
                    // 找到下一个选择的区间了
                    count++;
                    end = interval[1];
                }
            }
        return res;
    }
}
