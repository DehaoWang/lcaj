package leetcode.lc137;

/**
 * Created by wangdehao on 18/12/7.
 */
public class SingleNumberII {
    public static void main(String[] args) {
        int[][] numMatrix = {
                {1, 2, 1, 4, 4, 5, 5, 5},
        };
        int two = 0;
        System.out.println(1 ^ two);
        System.out.println(~two);
        System.out.println(1 & ~two);

        for (int[] nums : numMatrix) {
            System.out.println(singleNumber(nums));
        }
    }

    public static int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int i = 0; i < nums.length; i++) {
            ones = (ones ^ nums[i]) & ~twos;
            twos = (twos ^ nums[i]) & ~ones;
        }
        return ones;
    }

}
