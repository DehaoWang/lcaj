package algorithms.backtrack;

import java.util.LinkedList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums, 2));
    }

    // Ank
    public static List<List<Integer>> permute(int[] nums, int k) {
        LinkedList<Integer> track = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        backtrack(res, track, nums, k);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, LinkedList<Integer> track, int[] nums, int r) {
        if (r == 0) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int n : nums) {
            // apply 'contains' to prune
            if (track.contains(n)) {
                continue;
            }
            track.add(n);
            backtrack(res, track, nums, r - 1);
            track.removeLast();
        }
    }
}
