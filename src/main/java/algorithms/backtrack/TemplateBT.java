package algorithms.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TemplateBT {
    public static final int SUBSETS = 0;
    public static final int COMBINATIONS = 1;
    public static final int PERMUTATIONS = 2;

    public static List<List<Integer>> backtrackTemplate(int[] nums, int k, int type) {
        LinkedList<Integer> track = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        backtrack(res, track, nums, k, 0, type);
        return res;
    }

    /**
     * backtrack template
     */
    // result = []
    // def backtrack(路径, 选择列表):
    //     if 满足结束条件:
    //         result.add(路径)
    //         return ? "subsets do not return, go to bottom"
    //     for 选择 in 选择列表:
    //         做选择
    //         backtrack(路径, 选择列表)
    //         撤销选择
    public static void backtrack(List<List<Integer>> res, LinkedList<Integer> track, int[] nums, int k, int start, int type) {
        if (track.size() >= k) {
            res.add(new ArrayList<>(track));
            if (type != SUBSETS) {
                return;
            }
        }
        for (int i = start; i < nums.length; i++) {
            // variant implementations
            int startIdx = start;
            if (type != PERMUTATIONS) {
                startIdx = i + 1;

            } else if (track.contains(nums[i])) {
                continue;
            }

            // forward
            track.add(nums[i]);
            // backtrack - dfs
            backtrack(res, track, nums, k, startIdx, type);
            // withdraw
            track.removeLast();
        }
    }
}
