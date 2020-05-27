package leetcode.lc42;

import static algorithms.twopointers.TrappingRainWater.trapTwoPointers;

public class TrappingRainWater {

    public static void main(String[] args) {
        int[][] heights = {
//                {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1},
                {0, 1, 0, 2, 1}
        };
        for (int[] height : heights) {
            System.out.println(trap(height));
            System.out.println(trapTwoPointers(height));
        }
    }

    public static int trap(int[] height) {
        int res = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < height.length; i++) {
            int h = height[i];
            if (h > 0 && left == 0) {
                left = h;
            } else if (left > 0 && h <= left) {
                // accumulate by left - h
                res += left - h;
            } else if( h > left) {
                right = h;
                left = h;

            }
        }
        return 0;
    }
}
