package algorithms.dp;

public class LongestIncSeq {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(longestIncSeq(nums));
        System.out.println(longestIncSeqBin(nums));

    }

    public static int longestIncSeq(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 1;
        int maxLen = 1;
        for (int i = 1; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    public static int longestIncSeqBin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] bin = new int[len];
        for (int i = 0; i < len; i++) {
            bin[i] = Integer.MAX_VALUE;
        }
        bin[0] = nums[0];
        int maxLen = 1;
        for (int i = 1; i < len; i++) {
            int l = 0;
            int r = len - 1;
            while (l <= r) {
                int m = l + (r - l) / 2;
                if (nums[i] > bin[m]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            bin[l] = nums[i];
            maxLen = Math.max(maxLen, l + 1);
        }
        return maxLen;
    }
}
