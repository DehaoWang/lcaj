package leetcode.lc77;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by wangdehao on 18/11/15.
 */
public class Combinations {
    public static void main(String[] args) {

        // 1,2,3,4 -> [1,2], [1,3] ... [3,4]

        List<List<Integer>> result = combine(10, 7);
        System.out.println(result);
        System.out.println(result.size());

        List<List<Integer>> result2 = combineLC(10, 7);
        System.out.println(result2);
        System.out.println(result2.size());
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (k <= 0) {
            return result;
        }
        Set<Set<Integer>> resultSet = new HashSet<>();
        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i - 1] = i;
        }
        backtrackForCombination(k, nums, new ArrayList<>(), result);
//        backtrackForCombinationSet(k, nums, new HashSet<>(), resultSet);
        List<List<Integer>> combinations = filter(result);

        return combinations;
//        return result;
    }

    private static List<List<Integer>> filter(List<List<Integer>> result) {
        List<List<Integer>> filteredResult = new ArrayList<>();
        Set<Set<Integer>> setResult = new HashSet<>();
        for (List<Integer> permutation : result) {
            Set<Integer> resultSet = new HashSet<>(permutation);
            setResult.add(resultSet);
        }
        for (Set<Integer> combination : setResult) {
            List<Integer> combList = new ArrayList<>(combination);
            filteredResult.add(combList);
        }
        return filteredResult;
    }

    public static void backtrackForCombination(int k, int[] nums, List<Integer> tempList, List<List<Integer>> result) {
        if (tempList.size() == k) {
            result.add(new ArrayList<>(tempList));
        }
        for (int i : nums) {
            if (tempList.contains(i)) {
                continue;
            }
            tempList.add(i);
            backtrackForCombination(k, nums, tempList, result);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void backtrackForCombinationSet(int k, int[] nums, Set<Integer> tempList, Set<Set<Integer>> result) {
        if (tempList.size() == k) {
            result.add(new HashSet<>(tempList));
        }
        for (int i = k; i < nums.length; i++) {
            if (tempList.contains(nums[i])) {
                continue;
            }
            tempList.add(i);
            backtrackForCombinationSet(k, nums, tempList, result);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static List<List<Integer>> combineLC(int n, int k) {
        List<List<Integer>> combs = new ArrayList<>();
        combine(combs, new ArrayList<>(), 1, n, k);
        return combs;
    }
    public static void combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
        if(k==0) {
            combs.add(new ArrayList<>(comb));
            return;
        }
        for(int i=start;i<=n;i++) {
            comb.add(i);
            combine(combs, comb, i+1, n, k-1);
            comb.remove(comb.size()-1);
        }
    }
}
