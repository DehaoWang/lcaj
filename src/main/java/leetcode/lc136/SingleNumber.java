package leetcode.lc136;

/**
 * Created by wangdehao on 18/12/7.
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[][] numMatrix = {
                {1, 2, 1, 4, 4},
                {2, 3, 2},
                {5, 1, 1, 5, 4},
                {4, 1, 1, 5, 5}
        };

        for (int[] nums : numMatrix) {
            System.out.println(singleNumber(nums));
        }
    }

    // bit operation: XOR
    public static int singleNumber(int[] nums) {

        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}
