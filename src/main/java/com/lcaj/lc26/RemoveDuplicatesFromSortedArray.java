package com.lcaj.lc26;

/**
 * Created by wangdehao on 18/5/3.
 */
public class RemoveDuplicatesFromSortedArray {
    public static void main( String[] args ) {
        int[][] m = {
                {1, 1, 2},
                {0, 0, 1, 1, 1, 2, 2, 3, 3, 4},
//                {1, 2, 3, 4, 5},
//                {1, 2, 3, 4, 5, 6},
//                {1, 2, 3, 4, 5, 6, 7},
        };
        for(int[] nums: m){
            System.out.println("final length=" + removeDuplicates(nums));
        }
    }

    public static int removeDuplicates(int[] nums) {
        if(nums.length <= 0){
            return 0;
        }
        int pre = nums[0];
        int j = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != pre){
                nums[j] = nums[i];
                pre = nums[j];
                j++;
            }else {

            }
        }
        for(int k = 0; k < j; k++){
            System.out.print(nums[k]+" ");
        }
        System.out.println();

        return j;
    }
}
