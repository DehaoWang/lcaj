package lcwc.wc187;

import java.util.*;

public class ConditionalLongestSubArray {
    public static void main(String[] args) {
//        int[] nums = {8, 2, 4, 7};
//        System.out.println(longestSubarray(nums, 4));

        int[] nums1 = {10, 1, 2, 4, 7, 2};
//        System.out.println(longestSubarrayDP(nums1, 5));
        System.out.println(longestSubarraySwTreeMap(nums1, 5));
        System.out.println(longestSubarraySwPrev(nums1, 5));
//        System.out.println(longestSubarraySwDeque(nums1, 5));

        int[] nums2 = {4, 2, 2, 2, 4, 4, 2, 2};
//        System.out.println(longestSubarrayDP(nums1, 5));
        System.out.println(longestSubarraySwTreeMap(nums2, 0));
        System.out.println(longestSubarraySwPrev(nums2, 0));
//        System.out.println(longestSubarraySwDeque(nums2, 0));


        Deque<Integer> maxQ = new ArrayDeque<>();
        Deque<Integer> minQ = new ArrayDeque<>();
        for (int n : nums1) {
            while (!maxQ.isEmpty() && n > maxQ.peekLast()) maxQ.pollLast();
            while (!minQ.isEmpty() && n < minQ.peekLast()) minQ.pollLast();
            maxQ.offer(n);
            minQ.offer(n);
            System.out.println("maxQ = " + maxQ);
            System.out.println("minQ = " + minQ);
        }

    }

    // DP: dp(i) = longest subarray ended at i
    // dp(i) = max(dp(i-1) + 1, 1)
    public static int longestSubarrayDP(int[] nums, int limit) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int currMin = nums[0];
        int currMax = nums[0];
        int maxLen = 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];
            if (Math.abs(n - currMin) <= limit && Math.abs(n - currMax) <= limit) {
                dp[i] = dp[i - 1] + 1;
                currMin = Math.min(n, currMin);
                currMax = Math.max(n, currMax);
            } else {
                // problem: should go back to find -> better solution SW
//                while (...){
//
//                }
                dp[i] = 1;
                currMin = n;
                currMax = n;
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    // SW
    public static int longestSubarraySwTreeMap(int[] nums, int limit) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int l = 0;
        int r = 0;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(nums[l], 1);
        int maxLen = 1;
        while (r < nums.length) {
            // update maxLen by r - l + 1
            if (valid(treeMap, limit)) {
                maxLen = Math.max(maxLen, r - l + 1);
                r++;
                if (r < nums.length) {
                    treeMap.put(nums[r], treeMap.getOrDefault(nums[r], 0) + 1);
                }
            } else {
                if (treeMap.get(nums[l]) == 1) {
                    treeMap.remove(nums[l]);
                } else {
                    treeMap.put(nums[l], treeMap.getOrDefault(nums[l], 0) - 1);
                }
                l++;
            }
        }
        return maxLen;
    }

    public static boolean valid(TreeMap<Integer, Integer> treeMap, int limit) {
        int max = treeMap.lastKey();
        int min = treeMap.firstKey();
        return max - min <= limit;
    }

    public static int longestSubarraySwPrev(int[] nums, int limit) {
        int maxLen = 0;
        int l = 0;
        int r = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        while (r < nums.length) {
            max = Math.max(max, nums[r]);
            min = Math.min(min, nums[r]);
            if (max - min <= limit) {
                maxLen = Math.max(maxLen, r - l + 1);
                r++;
            } else {
                if (nums[r] == max) {
                    //there is a min at the left
                    while (nums[l] != min) {
                        l++;
                    }
                    l++;
                    // important: update min, like prevMin
                    min = nums[l];
                    int iterate = l;
                    while (iterate < r) {
                        min = Math.min(min, nums[iterate]);
                        iterate++;
                    }
                } else {
                    //there is a max at the left
                    while (nums[l] != max) {
                        l++;
                    }
                    l++;
                    // important: update max, like prevMax
                    max = nums[l];
                    int iterate = l;
                    while (iterate < r) {
                        max = Math.max(max, nums[iterate]);
                        iterate++;
                    }
                }
            }

        }
        return maxLen;
    }

    // TODO: 2020-05-04  
    public static int longestSubarraySwDeque(int[] nums, int limit) {
        Deque<Integer> maxQ = new ArrayDeque<>();
        Deque<Integer> minQ = new ArrayDeque<>();
        int l = 0;
        int r = 0;
        int maxLen = 1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        maxQ.offer(nums[r]);
        minQ.offer(nums[r]);
        while (r < nums.length) {
            max = Math.max(max, nums[r]);
            min = Math.min(min, nums[r]);
            if (max - min <= limit) {
                maxLen = Math.max(maxLen, r - l + 1);
                r++;
                if (r < nums.length) {
//                    while (!maxQ.isEmpty() && nums[r] > maxQ.peekLast()) {
//                        maxQ.pollLast();
//                    }
//                    while (!minQ.isEmpty() && nums[r] < minQ.peekLast()) {
//                        minQ.pollLast();
//                    }
                    maxQ.offer(nums[r]);
                    minQ.offer(nums[r]);
                }

            } else {
                if (maxQ.peek() == nums[l]) {
                    maxQ.poll();
                }
                if (minQ.peek() == nums[l]) {
                    minQ.poll();
                }
                l++;
            }
        }
        return r - l + 1;
    }
}
