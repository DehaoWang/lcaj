package algorithms.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SubSets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        System.out.println(subsets(nums));

        System.out.println(TemplateBT.backtrackTemplate(nums, 0, TemplateBT.SUBSETS));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(res, track, nums, 0, 0);

        return res;
    }

    public static void backtrack(List<List<Integer>> res, LinkedList<Integer> track, int[] nums, int k, int start) {
        res.add(new LinkedList<>(track));
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
