package com.lcaj.lc34;

import com.lcaj.lc31.NextPermutation;

/**
 * Created by wangdehao on 18/10/28.
 */
public class FindPositionsInSortedArray {

    // NOTES:
    // binary search
    // p = l+r/2, watch out loop bug!
    // empty case
    // out of range
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] nums2 = {};
        int[] nums3 = {1, 2, 2};
        int target = 8;
        int target2 = 6;
        int target3 = 2;
        NextPermutation.printNums(searchRange(nums, target));
        NextPermutation.printNums(searchRange(nums2, target2));
        NextPermutation.printNums(searchRange(nums3, target3));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums.length == 0) {
            return res;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l < r - 1) {
            int p = (l + r) / 2;
            if (target < nums[p]) {
                r = p;
            } else if (target > nums[p]) {
                l = p;
            } else {
                int i = p;
                while (i >= 0 && nums[i] >= target) {
                    i--;
                }
                res[0] = i + 1;
                int j = p;
                while (j < nums.length && nums[j] <= target) {
                    j++;
                }
                res[1] = j - 1;
                return res;
            }
        }
        // l = r - 1
        if (nums[l] == target && nums[r] == target) {
            res[0] = l;
            res[1] = r;
        } else if (nums[l] == target && nums[r] != target) {
            res[0] = res[1] = l;
        } else if (nums[l] != target && nums[r] == target) {
            res[0] = res[1] = r;
        }
        return res;
    }
}
