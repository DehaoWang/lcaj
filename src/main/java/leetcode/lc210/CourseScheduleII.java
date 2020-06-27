package leetcode.lc210;

import algorithms.bfs.TopologicalSort;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        return TopologicalSort.findOrder(numCourses, prerequisites);
    }
}
