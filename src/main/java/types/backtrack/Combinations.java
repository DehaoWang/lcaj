package types.backtrack;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Combinations {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(combine(nums, 2));
    }

    // Cnk
    public static List<List<Integer>> combine(int[] nums, int k) {
        LinkedList<Integer> track = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        backtrack(res, track, nums, k, 0);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, LinkedList<Integer> track, int[] nums, int r, int start) {
        if (r == 0) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            // apply 'start' to prune
//            if (track.contains(nums[i])) {
//                continue;
//            }
            track.add(nums[i]);
            // key: use i+1 to avoid duplication
            backtrack(res, track, nums, r - 1, i + 1);
            track.removeLast();
        }
    }
}
