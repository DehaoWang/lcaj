package leetcode.lc704;

public class BinarySearch {
    public static void main(String[] args) {

    }

    public int search2(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int m;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (target > nums[m]) {
                l = m + 1;
            } else if (target < nums[m]) {
                r = m - 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int m;
        while (l < r - 1) {
            m = l + (r - l) / 2;
            if (target > nums[m]) {
                l = m;
            } else if (target < nums[m]) {
                r = m;
            } else {
                return m;
            }
        }
        if (target == nums[l]) {
            return l;
        } else if (target == nums[r]) {
            return r;
        } else {
            return -1;
        }
    }
}
