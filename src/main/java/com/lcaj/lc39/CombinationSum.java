package com.lcaj.lc39;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by wangdehao on 18/11/2.
 */
public class CombinationSum {

    // NOTES:
    // backtracking approach
    public static void main(String[] args) {
        int[] candidates = {2, 3, 5};
        int target = 8;

        List<List<Integer>> res = combinationSum(candidates, target);
        System.out.println(res);

        List<List<Integer>> res2 = combinationSumCSDN(candidates, target);
        System.out.println(res2);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
//        return combinationSumRecursive(candidates, target, 0);
        List<List<Integer>> results = new ArrayList<>();
        backtrackForCombinationSum(candidates, target, results, new ArrayList<>(), 0);
        return results;
    }

    // problem 2: should use position instead of value for distinction
    public static void backtrackForCombinationSum(int[] candidates, int target, List<List<Integer>> results, List<Integer> tempList, int position) {

        if (target < 0) {
            return;
        } else if (target == 0) {
//            // problem 1: BUG easily, add object may generate modification problems
            results.add(new ArrayList<>(tempList));
        } else {
            for (int i = position; i < candidates.length; i++) {
                tempList.add(candidates[i]);
//            // problem 2: BUG easily, use i instead of position (position is not variable!)
                backtrackForCombinationSum(candidates, target - candidates[i], results, tempList, i);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    // recursive solution
    public static List<List<Integer>> combinationSumRecursive(int[] candidates, int target, int from) {
        List<List<Integer>> res = new ArrayList<>();

        if (candidates.length == 0) {
            System.out.println("debug0");
            return res;
        }
        if (from == candidates.length) {
            System.out.println("debug1");
            return res;
        }
        if (from == candidates.length - 1) {
            if (candidates[from] > target) {
                System.out.println("debug2: cf=" + candidates[from] + ", target=" + target);
                return res;
            }
            if (candidates[from] == target) {
                System.out.println("debug3: cf=" + candidates[from] + ", target=" + target);
                List<Integer> single = new ArrayList<>();
                single.add(target);
                res.add(single);
                return res;
            }
        }

        // use first i times
        int first = candidates[from];
        for (int i = 0; i < target / first + 1; i++) {
            // not use first
            if (i == 0) {
                List<List<Integer>> subSolutions = combinationSumRecursive(candidates, target, from + 1);
                res.addAll(subSolutions);
            } else {
                List<List<Integer>> subSolutions = combinationSumRecursive(candidates, target - i * first, from);
                res.addAll(subSolutions);
            }
        }
        return res;
    }


    public static List<List<Integer>> combinationSumCSDN(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        backtracking(ret, new ArrayList<>(), candidates, target, 0);
        return ret;
    }

    public static void backtracking(List<List<Integer>> ret, List<Integer> list, int[] candidates, int target, int position) {
        if (target < 0) return;
        else if (target == 0) ret.add(new ArrayList<>(list));
        else {
            for (int i = position; i < candidates.length; i++) {
                list.add(candidates[i]);
                backtracking(ret, list, candidates, target - candidates[i], i);
                list.remove(list.size() - 1);
            }
        }
    }
//    ---------------------
//    作者：wonner_
//    来源：CSDN
//    原文：https://blog.csdn.net/wonner_/article/details/80373871
//    版权声明：本文为博主原创文章，转载请附上博文链接！
}
