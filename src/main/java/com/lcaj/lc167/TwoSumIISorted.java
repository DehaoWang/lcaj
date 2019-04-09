package com.lcaj.lc167;

/**
 * Created by wangdehao on 19/4/8.
 */
public class TwoSumIISorted {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;


        int[] result = twoSum(nums, target);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int len = numbers.length;
        int i = 0;
        int j = len - 1;

        boolean found = false;
        while (i < j) {
            if (numbers[i] + numbers[j] < target) {
                i++;
            } else if (numbers[i] + numbers[j] > target) {
                j--;
            } else {
                result[0] = i + 1;
                result[1] = j + 1;
                break;
            }
        }
        return result;

    }
}
