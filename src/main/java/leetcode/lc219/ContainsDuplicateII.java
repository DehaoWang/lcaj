package leetcode.lc219;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangdehao on 19/4/17.
 */
public class ContainsDuplicateII {
    public static void main(String[] args) {
        int[][] m = {
                {1, 2, 3, 1},
        };
        for (int[] nums : m) {
            System.out.println(containsNearbyDuplicate(nums, 3));
        }
        int[] nums = {1, 0, 1, 1};
        System.out.println(containsNearbyDuplicate(nums, 1));

        int[] nums2 = {1, 2, 3, 1, 2, 3};
        System.out.println(containsNearbyDuplicate(nums2, 2));

    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer rightIndex = map.get(nums[i]);
            if (rightIndex != null && i - rightIndex <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
