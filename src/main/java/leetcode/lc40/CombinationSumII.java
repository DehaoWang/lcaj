package leetcode.lc40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wangdehao on 18/11/2.
 */
public class CombinationSumII {

    // NOTES:
    // backtracking approach
    public static void main(String[] args) {
        int[] candidates = {2, 3, 5};

        int[] candidates2 = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        List<List<Integer>> res = combinationSumII(candidates2, target);
        System.out.println(res);

    }

    public static List<List<Integer>> combinationSumII(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        // problem 3.1: avoid duplication
        Arrays.sort(candidates);
        backtrackForCombinationSumII(candidates, target, results, new ArrayList<>(), 0);
        return results;
    }

    // problem 2: should use position instead of value for distinction
    public static void backtrackForCombinationSumII(int[] candidates, int target, List<List<Integer>> results, List<Integer> tempList, int position) {

        if (target < 0) {
            return;
        } else if (target == 0) {
//            // problem 1: BUG easily, add object may generate modification problems
            results.add(new ArrayList<>(tempList));
        } else {
            for (int i = position; i < candidates.length; i++) {
                // problem 3.2: avoid duplication
                if (i > position && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                tempList.add(candidates[i]);
//            // problem 2: BUG easily, use i instead of position (position is not variable!)
                backtrackForCombinationSumII(candidates, target - candidates[i], results, tempList, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
