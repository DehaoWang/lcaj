package algorithms.dynamicprogramming;

public class MaxSubArraySum {
    public static void main(String[] args) {
        int[] nums = {2, 3, 4, -6, 5, -12, 3, -5, 8};
        int maxSubArraySum = maxSubArraySum(nums);
        System.out.println(maxSubArraySum);
    }

    private static int maxSubArraySum(int[] nums) {
        int thisSum = 0;
        int maxSum = 0;

        for (int i = 0; i < nums.length; i++) {
            thisSum += nums[i];
            if (thisSum < 0) {
                thisSum = 0;
            }

            maxSum = thisSum > maxSum ? thisSum : maxSum;

        }

        return maxSum;
    }

}
