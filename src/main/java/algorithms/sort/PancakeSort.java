package algorithms.sort;

import algorithms.utils.ArrayUtils;
import algorithms.utils.StringUtils;

import java.util.*;

public class PancakeSort {
    public static void main(String[] args) {
        int[] cakes = {3, 2, 4, 5, 7, 6, 1};
        System.out.println(pancakeSort(cakes));

        int[] cakes2 = {3, 2, 4, 5, 7, 6, 1};
        System.out.println(pancakeSortMinOpsBFS(cakes2));

        int[] cakes3 = {3, 2, 4, 5, 7, 6, 1};
        System.out.println(pancakeSortMinOps2WayBFS(cakes3));

        int[] cakes4 = {3, 2, 4, 5, 7, 6, 1};
        System.out.println(pancakeSortLC(cakes4));


        // dp attempt
        int[] cakes5 = {3, 2, 4, 1, 7, 6, 5};
        System.out.println(pancakeSortMinOpsBFS(cakes5));

        int[] cakes6 = {3, 2, 4, 1, 7, 6, 5};
        System.out.println(pancakeSortMinOps2WayBFS(cakes6));
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

    public static List<Integer> pancakeSortMinOpsDP(int[] cakes) {
        // TODO: 2020-05-09 dp impls
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
        String source = StringUtils.arr2Str(cakes);
        int[] targetCakes = ArrayUtils.copy(cakes);
        QuickSort.quickSort(targetCakes);
        String target = StringUtils.arr2Str(targetCakes);

        Set<String> visited = new HashSet<>();
        Set<String> queueF = new HashSet<>();
        Set<String> queueB = new HashSet<>();
        queueF.add(source);
        queueB.add(target);
        int depth = 0;

        while (!queueF.isEmpty() && !queueB.isEmpty()) {
            Set<String> temp;
            if (queueF.size() > queueB.size()) {
                temp = queueF;
                queueF = queueB;
                queueB = temp;
            }
            temp = new HashSet<>();
            for (String curr : queueF) {
                if (visited.contains(curr)) {
                    continue;
                }
                visited.add(curr);
                if (queueB.contains(curr)) {
                    return depth;
                }
                List<String> options = generate(curr);
                for (String option : options) {
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

    public static List<String> generate(String curr) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i < curr.length(); i++) {
            String copy = StringUtils.copy(curr);
            String rev = StringUtils.reverseByIndices(copy, 0, i);
            res.add(rev);
        }
        return res;
    }

    public static List<Integer> pancakeSortLC(int[] A) {
        List<Integer> ans = new ArrayList();
        int N = A.length;

        Integer[] B = new Integer[N];
        for (int i = 0; i < N; ++i)
            B[i] = i + 1;
        Arrays.sort(B, (i, j) -> A[j - 1] - A[i - 1]);

        for (int i : B) {
            for (int f : ans)
                if (i <= f)
                    i = f + 1 - i;
            ans.add(i);
            ans.add(N--);
        }

        return ans;
    }
}
