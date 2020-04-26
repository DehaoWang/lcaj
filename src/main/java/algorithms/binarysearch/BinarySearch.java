package algorithms.binarysearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] bsNums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(binarySearch(bsNums, 7));

        int[] bsrNums = {6, 7, 8, 9, 1, 2, 3, 4, 5};
        System.out.println(binarySearchRotated(bsrNums, 7));

        int[] bsrNumsSC = {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0};
        System.out.println(binarySearchRotated(bsrNumsSC, 1));

        int[] bsrNumsSC2 = {3, 1};
        System.out.println(binarySearchRotated(bsrNumsSC2, 1));
    }

    public static int binarySearch(int[] nums, int target) {
        // ascending case
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (target == nums[m]) {
                return m;
            }
            if (target < nums[m]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }

    public static int binarySearchRotated(int[] nums, int target) {
        // binary based approach
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (target == nums[m]) {
                return m;
            } else if (nums[l] < nums[m]) {
                // left part sorted
                if (target < nums[m] && target >= nums[l]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else if (nums[r] > nums[m]) {
                // right part sorted
                if (target > nums[m] && target <= nums[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else {
                // left could be target
                if (target == nums[l]) {
                    return l;
                } else {
                    l++;
                }
            }
        }
        // return index
        return -1;
    }
}
