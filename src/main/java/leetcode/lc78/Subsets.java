package leetcode.lc78;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangdehao on 18/11/21.
 */
public class Subsets {
    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
//        int[] nums = {};
        List<List<Integer>> result = subsets(nums);
        System.out.println(result);
        System.out.println(result.size());
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 0){
            return result;
        }
        backtrackForSubsets(nums, 0, new ArrayList<>(), result);
        return result;
    }

    public static void backtrackForSubsets(int[] nums, int start, List<Integer> tempList, List<List<Integer>> result) {
        // jump condition
        if (tempList.size() <= nums.length) {
            result.add(new ArrayList<>(tempList));
        }

        // node traversal
        for (int i = start; i < nums.length; i++) {
            if (tempList.contains(nums[i])) {
                continue;
            }
            tempList.add(nums[i]);
            // easy to get bug: should use "i+1" instead of "start+1"
            backtrackForSubsets(nums, i + 1, tempList, result);
            tempList.remove(tempList.size() - 1);
        }
    }
}
