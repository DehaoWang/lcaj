package algorithms.sort;

import algorithms.utils.ArrayUtils;

import java.util.PriorityQueue;

public class NearlySortedArray {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 1, 5, 7, 6};
        ArrayUtils.printArray(conditionalSort(nums, 2));
    }

    public static int[] conditionalSort(int[] nums, int k) {
        int[] res = new int[nums.length];
        // TODO: 2020-05-05 understanding?
        // intuition: k = 3
        // 4, 3, 2, 1, 5, 7, 6

        // 4, 4, 4, 4
        // 3, 3, 3, 3, 3
        // 2, 2, 2, 2, 2, 2
        // 1, 1, 1, 1, 1, 1, 1
        //    5, 5, 5, 5, 5, 5
        //       6, 6, 6, 6, 6
        //          7, 7, 7, 7

        // intuition: k = 2
        // 4, 3, 2, 1, 5, 7, 6
        // 4, 4, 4
        // 3, 3, 3, 3
        // 2, 2, 2, 2, 2
        //    1, 1, 1, 1, 1
        //       5, 5, 5, 5, 5
        //          7, 7, 7, 7
        //             6, 6, 6
        PriorityQueue<Integer> pq = new PriorityQueue();
        for (int i = 0; i < k + 1; i++) {
            pq.offer(nums[i]);
        }
        int l = 0;
        int r = k + 1;
        while (!pq.isEmpty()) {
            res[l] = pq.poll();
            l++;
            if (r < nums.length) {
                pq.offer(nums[r]);
                r++;
            }
        }
        return res;
    }
}
