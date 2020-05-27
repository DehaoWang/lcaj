package leetcode.lc53;

import algorithms.dynamicprogramming.MaxSubArraySum;

/**
 * Created by wangdehao on 18/11/5.
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        int[] nums2 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        System.out.println(maxSubArray(nums));
//        System.out.println(maxSubArray(nums2));
        System.out.println(MaxSubArraySum.maxSubArraySumDP(nums2));

//        System.out.println(getMaxCross(nums, 5));
    }

    public static int maxSubArray(int[] nums) {
//        return maxSubArrayDNC(nums, 0, nums.length - 1);
        return maxSubArrayDP(nums, nums.length - 1);
    }

    public static int maxSubArrayDNC(int[] nums, int l, int r) {
        // left part, right part or cross over

        if (l == r) {
            return nums[l];
        }
        if (l == r - 1) {
            int vl = nums[l];
            int vr = nums[r];
            int max1 = vl > vr ? vl : vr;
            int max2 = vl + vr > max1 ? vl + vr : max1;
            return max2;
        }

        int pivot = (l + r) / 2;
        int maxL = maxSubArrayDNC(nums, l, pivot);
        int maxR = maxSubArrayDNC(nums, pivot, r);
        int maxC = getMaxCross(nums, pivot);

        int maxLR = maxL > maxR ? maxL : maxR;
        int max = maxLR > maxC ? maxLR : maxC;

        return max;
    }

    private static int getMaxCross(int[] nums, int pivot) {
        int maxL = nums[pivot];
        int currL = 0;
        int maxR = nums[pivot];
        int currR = 0;
        for (int i = pivot; i >= 0; i--) {
            currL += nums[i];
            if (currL > maxL) {
                maxL = currL;
            }
        }
        for (int i = pivot; i < nums.length; i++) {
            currR += nums[i];
            if (currR > maxR) {
                maxR = currR;
            }
        }
        return maxL + maxR - nums[pivot];
    }


    // TODO: 18/11/7  
    public static int maxSubArrayLinear(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else {
            int max = 0;
            int sum = nums[0];
            for (int i = 1; i < nums.length; i++) {
                int x = nums[i];

            }
            return 0;
        }
    }

    // problem
    public static int maxSubArrayDP(int[] nums, int endPos) {
        if (endPos == 0) {
            return nums[0] > 0 ? nums[0] : 0;
        }else {
            int maxBefore = maxSubArrayDP(nums, endPos-1);
            if(nums[endPos] > 0) {
                return maxBefore + nums[endPos];
            }else {
                return maxBefore;
            }
        }
    }


}
