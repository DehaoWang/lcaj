package com.lcaj.util;

/**
 * Created by wangdehao on 18/11/15.
 */
public class ArrayMethods {
    public static void printArray(int[] nums) {
        for (int i : nums) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void printArray(char[] str) {
        for (char i : str) {
            System.out.print(i);
        }
        System.out.println();
    }

    public static void reverseByIndices(char[] str, int l, int r) {
        while (l < r) {
            char temp = str[l];
            str[l] = str[r];
            str[r] = temp;
            l++;
            r--;
        }
    }

    public static void reverseByIndices(int[] nums, int l, int r) {
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }

    public static void printArray(double[] nums) {
        for (double i : nums) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
}
