package playground;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> res = comboSum(candidates, target);
        System.out.println(res);


        int[] candidates1 = new int[]{2, 3, 5};
        int target1 = 8;
        List<List<Integer>> res1 = comboSum(candidates1, target1);
        System.out.println(res1);

        int[] candidates2 = new int[]{1, 2, 5};
        int target2 = 8;
        List<List<Integer>> res2 = comboSum(candidates2, target2);
        System.out.println(res2);
    }

    public static List<List<Integer>> comboSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> track = new ArrayList<>();
        // backtrack: try option, go deep, then withdraw
        backtrack(result, track, candidates, target, 0);
        return result;
    }

    public static void backtrack(List<List<Integer>> result, List<Integer> track, int[] candidates, int target, int start) {
        if (target < 0) { // invalid case
            return;
        } else if (target == 0) { // target found
            result.add(new ArrayList<>(track));
        } else { //
            for (int i = start; i < candidates.length; i++) {
                // action: add option to track
                track.add(candidates[i]);

                // update target, then go backtracking
                int newTarget = target - candidates[i];
                backtrack(result, track, candidates, newTarget, i);

                // withdraw action
                track.remove(track.size() - 1);
            }
        }
    }
}
