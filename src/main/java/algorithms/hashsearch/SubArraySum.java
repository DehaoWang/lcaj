package algorithms.hashsearch;

import java.util.HashMap;
import java.util.Map;

public class SubArraySum {
    public static void main(String[] args) {
        int[] nums = {3, 5, 2, -2, 4, 1};
        System.out.println(subArraySum(nums, 5));
    }

    public static int subArraySum(int[] nums, int k) {
        Map<Integer, Integer> prevSum = new HashMap<>();
        prevSum.put(0, 1);
        int ans = 0;
        int currSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            int rest = currSum - k;
            if (prevSum.containsKey(rest)) {
                ans += prevSum.get(rest);
            }
            prevSum.put(currSum, prevSum.getOrDefault(currSum, 0) + 1);
        }
        return ans;
    }
}
