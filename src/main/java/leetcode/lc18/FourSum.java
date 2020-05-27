package leetcode.lc18;

import java.util.*;

/**
 * Created by wangdehao on 18/4/28.
 */
public class FourSum {
    public static void main(String[] args){
        int[][] testI = {
//                {1, 0, -1, 0, -2, 2},
//                {-3, -2, -1, 0, 0, 1, 2, 3},
                {-1, 0, -5, -2, -2, -4, 0, 1, -2},
        };
        for(int[] a: testI){
            System.out.println(String.format("res=%s", fourSum(a, -9)));
        }

    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        int len = nums.length;
        if(len < 4){
            return res;
        }

        Arrays.sort(nums);

        for(int i = 0; i < len - 3; i ++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            for(int j = i + 1; j < len - 2; j++){
                if(j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                int curr = nums[i] + nums[j];
                int lo = j + 1, hi = len - 1;
                while (lo < hi)
                if(curr + nums[lo] + nums[hi] < target){
                    lo++;
                }
                else if(curr + nums[lo] + nums[hi] > target){
                    hi--;
                }
                else {
//                    System.out.println(String.format("i=%d, j=%d, lo=%d, hi=%d",i,j,lo,hi));
//                    res.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
                    set.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
                    lo++;
                    hi--;
                    if(nums[lo] == nums[lo-1] && nums[hi] == nums[hi+1]){
                        lo++;
                        hi--;
                    }
                }
            }
        }
        res.addAll(set);

        return res;
    }
}
