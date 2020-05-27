package leetcode.lc47;

import java.util.*;

public class PermutationsII {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(permuteUnique(nums));
    }


    public static List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();
        Arrays.sort(nums);
        permuteUniqueBacktrack(nums, res, track, new boolean[nums.length]);
        return res;
    }

    private static void permuteUniqueBacktrack(int[] nums, List<List<Integer>> res, LinkedList<Integer> track, boolean[] visited) {
        int len = nums.length;
        if (track.size() == len) {
            res.add(new LinkedList<>(track));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if ((i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) || visited[i]) {
                    continue;
                } else {
                    track.add(nums[i]);
                    visited[i] = true;
                    permuteUniqueBacktrack(nums, res, track, visited);
                    track.removeLast();
                    visited[i] = false;
                }
            }
        }
    }
}
