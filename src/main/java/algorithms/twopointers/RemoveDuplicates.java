package algorithms.twopointers;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] nums1 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 4, 4, 6, 7, 7, 9};
        System.out.println(removeDuplicates(nums));
        System.out.println(removeDuplicates(nums1));
    }

    public static int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 1;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }
}
