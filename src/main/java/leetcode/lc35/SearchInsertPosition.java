package leetcode.lc35;

/**
 * Created by wangdehao on 18/10/28.
 */
public class SearchInsertPosition {

    // NOTES:
    // binary search
    // p = l+r/2, watch out loop bug!
    // empty case
    // out of range
    // edge case
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int[] nums2 = {};
        int[] nums3 = {1, 2, 2};
        int target = 5;
        int target2 = 7;
        int target3 = 2;
        System.out.println(searchInsert(nums, target2));
    }

    public static int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
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
                return p;
            }
        }
        // l = r - 1
        if (nums[r] < target) {
            return r + 1;
        }
        else if (nums[l] == target) {
            return l;
        } else {
            return r;
        }
    }
}
