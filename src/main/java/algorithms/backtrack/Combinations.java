package algorithms.backtrack;

import java.util.LinkedList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int k = 2;

        System.out.println(combine(nums, k));

        System.out.println(TemplateBT.backtrackTemplate(nums, k, TemplateBT.COMBINATIONS));
    }

    // Cnk
    public static List<List<Integer>> combine(int[] nums, int k) {
        LinkedList<Integer> track = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        backtrack(res, track, nums, k, 0);
        return res;
    }

    public static void backtrack(List<List<Integer>> res, LinkedList<Integer> track, int[] nums, int k, int start) {
        if (track.size() >= k) {
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
            backtrack(res, track, nums, k, i + 1);
            track.removeLast();
        }
    }
}
