package leetcode.lc207;

import java.util.*;
import algorithms.bfs.TopologicalSort;

/**
 * Created by wangdehao on 19/4/16.
 */
public class CourseSchedule {
    public static void main(String[] args) {
        int[][] pre = {{1, 0}};
        System.out.println(canFinish(2, pre));
        System.out.println(TopologicalSort.canFinish(2, pre));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> iMap = new HashMap<>();
        Map<Integer, Integer> interDegrees = new HashMap<>();
        for (int[] pair : prerequisites) {
            int curr = pair[1];
            int next = pair[0];
            List<Integer> list = iMap.get(curr);
            if (list == null) {
                list = new ArrayList<>();
                iMap.put(curr, list);
            }
            list.add(next);
            if (!interDegrees.containsKey(curr)) {
                interDegrees.put(curr, 0);
            }
            if (!interDegrees.containsKey(next)) {
                interDegrees.put(next, 0);
            }
            interDegrees.put(next, interDegrees.get(next) + 1);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (Integer curr : iMap.keySet()) {
            if (interDegrees.get(curr) == 0) {
                queue.offer(curr);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            Integer curr = queue.poll();
            count++;
            if (iMap.containsKey(curr)) {
                for (Integer next : iMap.get(curr)) {
                    interDegrees.put(next, interDegrees.get(next) - 1);
                    if (interDegrees.get(next) == 0) {
                        queue.offer(next);
                    }
                }
            }
        }
        System.out.println(count);
        System.out.println(iMap);
        System.out.println(interDegrees);
        return count == interDegrees.size();
    }
}
