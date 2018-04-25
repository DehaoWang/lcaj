package com.lcaj.lc15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wangdehao on 18/4/25.
 */
public class ThreeSum {
    public static void main(String[] args){
        int[][] testA = {{-1, 0, 1, 2, -1, -4}};
        for(int i = 0; i < testA.length; i++){
            int[] a = testA[i];
            System.out.println(String.format("a=%s, res=%s", a, threeSum(a)));
        }

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        for(int k = 0; k < nums.length; k++){
            System.out.println(nums[k]);
        }
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length < 3){
            return res;
        }
        Arrays.sort(nums);

        for(int i = 0; i < nums.length-2; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            if(nums[i] > 0){
                break;
            }
            int lo = i+1, hi = nums.length-1;
            while(lo < hi){
                if(nums[lo] + nums[hi] < -nums[i]){
                    lo++;
                }
                else if(nums[lo] + nums[hi] > -nums[i]){
                    hi--;
                }
                else {
                    res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    while(lo < hi && nums[lo] == nums[lo+1]) lo++;
                    while(lo < hi && nums[hi] == nums[hi-1]) hi--;
                    lo++;
                    hi--;
                }
            }
        }

        return res;
    }
}
