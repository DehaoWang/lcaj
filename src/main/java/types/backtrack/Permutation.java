package types.backtrack;

import java.util.LinkedList;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        backtrack(res, track, nums);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, LinkedList<Integer> track, int[] nums) {
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int n : nums) {
            if (track.contains(n)) {
                continue;
            }
            track.add(n);
            backtrack(res, track, nums);
            track.removeLast();
        }
    }
}
