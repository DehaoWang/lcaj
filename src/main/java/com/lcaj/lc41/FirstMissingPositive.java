package com.lcaj.lc41;

import com.lcaj.util.ArrayMethods;

import java.util.*;

public class FirstMissingPositive {
    public static void main(String[] args) {
        int[][] matrix = {
//                {1, 2, 0},
//                {3, 4, -1, 1},
//                {7, 8, 9, 11, 12},
                {3, 4, -1, -2, 1, 5, 16, 0, 2, 0}
        };
        for (int[] nums : matrix) {
//            System.out.println("FirstMissingPositiveSort = " + firstMissingPositiveSort(nums));
//            System.out.println("FirstMissingPositiveX= " + firstMissingPositiveX(nums));
            System.out.println("FirstMissingPositiveTS= " + firstMissingPositiveTS(nums));

        }
    }

    // O(nlogn)
    public static int firstMissingPositiveSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        Arrays.sort(nums);
        int res = 1;
        int i = 0;
        while (i < nums.length - 1) {
            if (nums[i] <= 0) {
                i++;
            } else if (nums[i + 1] == nums[i]) {
                i++;
            } else if (nums[i] == res) {
                i++;
                res++;
            } else {
                return res;
            }
        }
        if (nums[nums.length - 1] == res) {
            return res + 1;
        } else {
            return res;
        }
    }

    // O(n) ?
    public static int firstMissingPositiveX(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        Map<Integer, Boolean> numMap = new HashMap<>();
        for (int n : nums) {
            numMap.put(n, true);
        }
        int i = 1;
        while (i < numMap.size() + 1) {
            if (!numMap.containsKey(i)) {
                return i;
            } else {
                i++;
            }
        }
        return i;
    }

    // O(n)
    public static int firstMissingPositive(int[] nums) {
        int res = 1;
        int posMax = Integer.MAX_VALUE;
        for (int i : nums) {
            if (i <= 0) {
                continue;
            } else {
                posMax = i < posMax ? i : posMax;
            }
        }
        return posMax == Integer.MAX_VALUE ? 1 : posMax;
    }

    // O(n) ?
    public static int firstMissingPositiveTS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        int n = nums.length;
        boolean hasOne = false;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                hasOne = true;
            } else if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }
        }
        if (!hasOne) {
            return 1;
        }
        ArrayMethods.printArray(nums);
        for (int i = 0; i < n; i++) {
            int v = Math.abs(nums[i]);
            if (v == n) {
                nums[0] = -Math.abs(nums[0]);
            } else {
                nums[v] = -Math.abs(nums[v]);
            }
        }
        ArrayMethods.printArray(nums);
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                return i;
            }
        }
        if (nums[0] > 0) {
            return n;
        }
        return n + 1;
    }
}
