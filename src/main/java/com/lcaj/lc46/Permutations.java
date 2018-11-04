package com.lcaj.lc46;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by wangdehao on 18/11/3.
 */
public class Permutations {

    // NOTES:
    // basic case: zero ele, especially 1 ele, remember to build result
    // backtracking property
    public static void main(String[] args) {
//
        int[] nums = {1, 2, 3};
        int[] nums2 = {};
        System.out.println(permute(nums));
        System.out.println(permute(nums2));

    }

    public static List<List<Integer>> permute(int[] nums) {

//        Set<Integer> numSet = new HashSet<>();
//        for (int n : nums) {
//            numSet.add(n);
//        }
//        return permuteRecursive(numSet);
        List<List<Integer>> results = new ArrayList<>();
        backtrackForPermutation(nums, new ArrayList<>(), results);
        return results;
    }

    public static void backtrackForPermutation(int[] nums, List<Integer> tempList, List<List<Integer>> results) {
        if (tempList.size() == nums.length) {
            results.add(new ArrayList<>(tempList));
        } else {
            for (int i : nums) {
                if (tempList.contains(i)) {
                    continue;
                }
                tempList.add(i);
                backtrackForPermutation(nums, tempList, results);
                tempList.remove(tempList.size() - 1);
            }
        }
    }


    public static List<List<Integer>> permuteRecursive(Set<Integer> numSet) {
        List<List<Integer>> res = new ArrayList<>();
        if (numSet.size() == 0) {
            return res;
        }
        if (numSet.size() == 1) {
            List<Integer> list = new ArrayList<>();
            for (int i : numSet) {
                list.add(i);
            }
            res.add(list);
        }
        for (int n : numSet) {
            Set<Integer> tmpSet = new HashSet<>();
            tmpSet.addAll(numSet);
            tmpSet.remove(n);
            List<List<Integer>> numListList = permuteRecursive(tmpSet);
            for (List<Integer> list : numListList) {
                List<Integer> numList = new ArrayList<>();
                numList.add(n);
                for (Integer i : list) {
                    numList.add(i);
                }
                res.add(numList);
            }
        }

        return res;
    }
}
