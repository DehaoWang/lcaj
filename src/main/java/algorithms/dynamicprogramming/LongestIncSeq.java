package algorithms.dynamicprogramming;

import algorithms.utils.MatrixUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class LongestIncSeq {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(longestIncSeq(nums));
        System.out.println(longestIncSeqBin(nums));

        System.out.println(longestIncSeqReview(nums));
        System.out.println(longestIncSeqBinReview(nums));

        int[][] envelopes = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        int[][] envelopes1 = {{1, 2}, {2, 3}, {3, 4}, {3, 5}, {4, 5}, {5, 5}, {5, 6}, {6, 7}, {7, 8}};
        int[][] envelopes2 = {{1, 2}, {2, 100}, {3, 4}, {3, 5}, {4, 5}, {5, 5}, {5, 6}, {6, 7}, {7, 8}};
        System.out.println(maxEnvelopes(envelopes1));
        System.out.println(yySolution(envelopes1));
        System.out.println(maxEnvelopes(envelopes));
        System.out.println(yySolution(envelopes));

        System.out.println(maxEnvelopes(envelopes2));
        System.out.println(yySolution(envelopes2));
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


    // review on 200517
    public static int longestIncSeqReview(int[] nums) {
        // dp(i) = max length ending at i
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int[] dp = new int[nums.length];
        int maxLen = 1;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    public static int longestIncSeqBinReview(int[] nums) {
        // tails(i) = min right with length of i+1
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int[] tails = new int[nums.length];
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            int l = 0;
            int r = maxLen;
            int target = nums[i];
            while (l < r) {
                int m = l + (r - l) / 2;
                if (target > tails[m]) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            tails[l] = target;
            // append
            if (l == maxLen) {
                maxLen++;
            }
        }
        return maxLen;
    }

    public static int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                } else {
                    return b[1] - a[1];
                }
            }
        });
//        MatrixUtils.printMatrix(envelopes);
        int[] tails = new int[envelopes.length];
        int maxLen = 0;
        int curr = -1;

        for (int i = 0; i < envelopes.length; i++) {
            int target = envelopes[i][1];
            int l = 0;
            int r = maxLen;
            while (l < r) {
                int m = l + (r - l) / 2;
                if (target > tails[m]) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            tails[l] = target;
            // append
            if (l == maxLen) {
                maxLen++;
            }
        }
        return maxLen;
    }

    // coding interview for yy
    public static int yySolution(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                } else {
                    return a[1] - b[1];
                }
            }
        });
        int ans = 0;
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < envelopes.length; i++) {
            int[] cur = envelopes[i];
            if (!visited.contains(cur)) {
                visited.add(i);
            } else {
                continue;
            }
            int one_ans = 1;
            for (int j = i + 1; j < envelopes.length; j++) {
                int[] nxt = envelopes[j];
                if (nxt[0] > cur[0] && nxt[1] > cur[1]) {
                    one_ans++;
                    cur = nxt;
                    visited.add(j);
                }
            }
            ans = Math.max(ans, one_ans);
        }
        return ans;
    }
}