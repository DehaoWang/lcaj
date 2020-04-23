package types.dp;

public class HouseRobber {
    public static void main(String[] args) {
        // p1
        System.out.println(rob1(new int[]{1, 2, 3, 1}));
        System.out.println(rob1(new int[]{2, 7, 9, 3, 1}));
        System.out.println(rob1(new int[]{2, 1, 1, 2}));

        // p2
        System.out.println(rob2(new int[]{1, 2, 3, 1}));
    }

    // PROBLEM 1: Simple Array
    public static int rob1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int len = nums.length;
        // dp design: dp(i) ~ max revenue robbing 0 ... i
        int[] dp = new int[len];
        // base case
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        // state transition
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[len - 1];
    }

    // PROBLEM 2: Cyclic Array
    public static int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int len = nums.length;
        return Math.max(robRange(nums, 0, len - 2), robRange(nums, 1, len - 1));
    }

    public static int robRange(int[] nums, int l, int r) {
        int len = nums.length;
        // dp design: dp(i) ~ max revenue robbing 0 ... i
        int[] dp = new int[len];
        // base case
        dp[l] = nums[l];
        dp[l + 1] = Math.max(nums[l], nums[l + 1]);
        // state transition
        for (int i = l + 2; i <= r; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[r];
    }

    // PROBLEM 3: Binary Tree

}
