package com.lcaj.lc90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wangdehao on 18/11/23.
 */
public class SubsetsII {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 2},
//                {1, 2, 3, 3, 4, 4, 5},
//                {1, 1, 1, 2, 3},
                {},
//                {1, 1, 1, 1}
        };
        for (int[] nums : matrix) {
            List<List<Integer>> result = subsetsWithDup(nums);
            System.out.println(result);
        }

    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        backtrackForSubsetsII(nums, result, new ArrayList<>(), 0);

        return result;
    }

    private static void backtrackForSubsetsII(int[] nums, List<List<Integer>> result, ArrayList<Integer> tempList, int start) {
        // jump condition
        if (tempList.size() <= nums.length) {
            result.add(new ArrayList<>(tempList));
        }
        // node traversal
        for (int i = start; i < nums.length; i++) {
            int ele = nums[i];
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            tempList.add(ele);
            backtrackForSubsetsII(nums, result, tempList, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
