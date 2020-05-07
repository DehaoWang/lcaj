package algorithms.sort;

import algorithms.utils.ArrayUtils;

import java.util.*;

public class PancakeSort {
    public static void main(String[] args) {
        int[] cakes = {3, 2, 4, 1};
        System.out.println(pancakeSort(cakes));

        int[] cakes2 = {3, 2, 4, 1};
        System.out.println(pancakeSortMinOpsBFS(cakes2));

        int[] cakes3 = {3, 2, 4, 1};
//        QuickSort.quickSort(cakes3);
//        ArrayUtils.printArray(cakes3);
        System.out.println(pancakeSortMinOps2WayBFS(cakes3));
    }

    public static List<Integer> pancakeSort(int[] cakes) {
        List<Integer> res = new ArrayList<>();
        pancakeSortRecursive(res, cakes, cakes.length);
        return res;
    }

    public static void pancakeSortRecursive(List<Integer> res, int[] cakes, int n) {
        if (n == 1) {
            return;
        }
        int maxCake = Integer.MIN_VALUE;
        int maxCakeIndex = 0;
        for (int i = 0; i < n; i++) {
            if (cakes[i] > maxCake) {
                maxCakeIndex = i;
                maxCake = cakes[i];
            }
        }
        ArrayUtils.reverseByIndices(cakes, 0, maxCakeIndex);
        res.add(maxCakeIndex + 1);
        ArrayUtils.reverseByIndices(cakes, 0, n - 1);
        res.add(n);
        pancakeSortRecursive(res, cakes, n - 1);
    }

    // dp vs bfs?

    public static List<Integer> pancakeSortMinOps(int[] cakes) {
        List<Integer> res = new ArrayList<>();
//        pancakeSortMinOpsBFS(res, cakes);
        return res;
    }


    public static int pancakeSortMinOpsBFS(int[] cakes) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(cakes);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                if (ascending(curr)) {
                    return depth;
                }
                List<int[]> options = generate(curr);
                for (int[] option : options) {
                    queue.offer(option);
                }
            }
            depth++;
        }
        return depth;
    }

    public static boolean ascending(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] >= nums[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static List<int[]> generate(int[] curr) {
        List<int[]> res = new ArrayList<>();
        for (int i = 1; i < curr.length; i++) {
            int[] copy = ArrayUtils.copy(curr);
            ArrayUtils.reverseByIndices(copy, 0, i);
            res.add(copy);
        }
        return res;
    }

    // TODO: 2020-05-07 2 Way BFS debugging
    public static int pancakeSortMinOps2WayBFS(int[] cakes) {
        if (ascending(cakes)) {
            return 0;
        }
        int[] source = cakes;
        int[] target = ArrayUtils.copy(cakes);
        QuickSort.quickSort(target);

        Set<int[]> visited = new HashSet<>();
        Set<int[]> queueF = new HashSet<>();
        Set<int[]> queueB = new HashSet<>();
        queueF.add(source);
        queueB.add(target);
        int depth = 0;

        while (!queueF.isEmpty() && !queueB.isEmpty()) {
            Set<int[]> temp;
            if (queueF.size() > queueB.size()) {
                temp = queueF;
                queueF = queueB;
                queueB = temp;
            }
            temp = new HashSet<>();
            for (int[] curr : queueF) {
                if (visited.contains(curr)) {
                    continue;
                }
                visited.add(curr);
                if (queueB.contains(curr)) {
                    return depth;
                }
                List<int[]> options = generate(curr);
                for (int[] option : options) {
                    temp.add(option);
                }
            }
            depth++;
            // swap
            queueF = queueB;
            queueB = temp;
        }
        return -1;
    }
}
