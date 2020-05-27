package leetcode.lc16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wangdehao on 18/4/25.
 */
public class ThreeSumClosest {
    public static void main(String args[]){
//        int[] testInt = {-1, 2, 1, -4, -1};
//        int target = 1;

//        int[] testInt = {0, 1, 2};
//        int target = 3;

        int[] testInt = {0, 2, 1, -3};
        int target = 1;

        System.out.println(threeSumClosest(testInt, target));
    }

    public static int threeSumClosest(int[] nums, int target){
        for(int k = 0; k < nums.length; k++){
            System.out.println(nums[k]);
        }
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length < 3){
            return 0;
        }
        Arrays.sort(nums);

        int ans = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length-2; i++){
            int lo = i+1, hi = nums.length-1;
            while(lo < hi){
                int sum = nums[i] + nums[lo] + nums[hi];
                if(Math.abs(target - sum) < Math.abs(target - ans)){
                    ans = sum;
                }
                if(sum == target){
                    return ans;
                }
                if(sum > target){
                    hi--;
                }
                else if(sum < target){
                    lo++;
                }
            }
        }

        return ans;
    }
}
