package algorithms.bfs;

import algorithms.utils.ArrayUtils;

import java.util.*;

public class TopologicalSort {
    public static void main(String[] args) {
        int[][] pre = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[][] pre1 = {{1, 0}};
        System.out.println(canFinish(2, pre1));
//        ArrayUtils.printArray(findOrder(3, pre1));
//        ArrayUtils.printArray(solution(3, pre1));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] finishOrder = findOrder(numCourses, prerequisites);
        ArrayUtils.printArray(finishOrder);
        return finishOrder.length != 0;
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        if (prerequisites == null || prerequisites.length == 0) {
            for (int i = 0; i < result.length; i++) {
                result[i] = result.length - 1 - i;
            }
            return result;
        }
        Map<Integer, List<Integer>> iMap = new HashMap<>();
        int[] interDegreeArray = new int[numCourses];
        for (int[] pair : prerequisites) {
            int curr = pair[1];
            int next = pair[0];
            List<Integer> list = iMap.get(curr);
            if (list == null) {
                list = new ArrayList<>();
                iMap.put(curr, list);
            }
            list.add(next);
            interDegreeArray[next]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < interDegreeArray.length; i++) {
            if (interDegreeArray[i] == 0) {
                queue.offer(i);
            }
        }
        int idx = 0;
        while (!queue.isEmpty()) {
            Integer curr = queue.poll();
            result[idx] = curr;
            idx++;
            if (iMap.containsKey(curr)) {
                for (Integer next : iMap.get(curr)) {
                    interDegreeArray[next]--;
                    if (interDegreeArray[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
        }

        if (idx == numCourses) {
            return result;
        }
        return new int[0];
    }


    public static int[] solution(int numCourses, int[][] prerequisites) {
        boolean isPossible = true;
        Map<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();
        int[] indegree = new int[numCourses];
        int[] topologicalOrder = new int[numCourses];

        // Create the adjacency list representation of the graph
        for (int i = 0; i < prerequisites.length; i++) {
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];
            List<Integer> lst = adjList.getOrDefault(src, new ArrayList<Integer>());
            lst.add(dest);
            adjList.put(src, lst);

            // Record in-degree of each vertex
            indegree[dest] += 1;
        }

        // Add all vertices with 0 in-degree to the queue
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int i = 0;
        // Process until the Q becomes empty
        while (!q.isEmpty()) {
            int node = q.remove();
            topologicalOrder[i++] = node;

            // Reduce the in-degree of each neighbor by 1
            if (adjList.containsKey(node)) {
                for (Integer neighbor : adjList.get(node)) {
                    indegree[neighbor]--;

                    // If in-degree of a neighbor becomes 0, add it to the Q
                    if (indegree[neighbor] == 0) {
                        q.add(neighbor);
                    }
                }
            }
        }

        // Check to see if topological sort is possible or not.
        if (i == numCourses) {
            return topologicalOrder;
        }

        return new int[0];
    }

}
