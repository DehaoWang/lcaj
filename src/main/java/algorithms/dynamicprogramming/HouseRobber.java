package algorithms.dynamicprogramming;

import datastructures.basic.tree.TreeNode;

public class HouseRobber {
    public static void main(String[] args) {
        // p1
        System.out.println(rob1(new int[]{1, 2, 3, 1}));
        System.out.println(rob1(new int[]{2, 7, 9, 3, 1}));
        System.out.println(rob1(new int[]{2, 1, 1, 2}));

        // p2
        System.out.println(rob2(new int[]{1, 2, 3, 1}));
        // p3
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        System.out.println(rob3(root));
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
    public static int rob3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] res = rob_or_not(root);
        return Math.max(res[0], res[1]);
    }

    // 0 not rob, 1 rob
    private static int[] rob_or_not(TreeNode curr) {
        if (curr == null) {
            return new int[]{0, 0};
        }
        int[] left = rob_or_not(curr.left);
        int[] right = rob_or_not(curr.right);
        int rob = curr.val + left[0] + right[0];
        int not_rob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{not_rob, rob};
    }
}
