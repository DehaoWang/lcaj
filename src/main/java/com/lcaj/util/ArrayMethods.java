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
        System.out.println();
        for (double i : nums) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }

    public static void printArray(String[] string) {
        for (String s : string) {
            System.out.print(s + ", ");
        }
        System.out.println();
    }

    public static void printArray(boolean[] bools) {
        for (Boolean b : bools) {
            System.out.print(b + ", ");
        }
        System.out.println();
    }

    public static void heapAdjustMin(int[] heap, int length, boolean isMin) {
        for(int i = 0; i < length; i++){
            for (int j = length - 1; j > i; j -= 2) {
                int parent = (j - 1) / 2;
                int left = parent * 2 + 1;
                int right = parent * 2 + 2;
                heapShiftMin(heap, parent, left, right, isMin);
            }
        }
    }

    private static void heapShiftMin(int[] heap, int p, int l, int r, boolean isMin) {
        if (r >= heap.length) {
            if ((isMin && heap[l] < heap[p])
                    || (!isMin && heap[l] > heap[p])) {
                swap(heap, l, p);
            }
            return;
        }

        int maxIdx;
        int minIdx;
        if (heap[l] > heap[r]) {
            maxIdx = heap[l] > heap[p] ? l : p;
            minIdx = heap[r] < heap[p] ? r : p;
        } else {
            maxIdx = heap[r] > heap[p] ? r : p;
            minIdx = heap[l] < heap[p] ? l : p;
        }
        if (isMin && minIdx != p) {
            swap(heap, minIdx, p);
        } else if (!isMin && maxIdx != p) {
            swap(heap, maxIdx, p);
        }
    }


}
