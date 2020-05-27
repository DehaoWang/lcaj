package leetcode.lc217;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by wangdehao on 19/4/16.
 */
public class ContainsDuplicate {
    public static void main(String[] args) {

        int[][] m = {
                {2, 3, 1, 2, 4, 3},
                {6},
                {6, 2, 6, 4, 5},
                {1, 2, 6, 4, 5, 8},
                {1, 2, 6, 3, 4, 5, 6},
        };
        for (int[] nums : m) {
            System.out.println(containsDuplicate(nums));
            System.out.println(containsDuplicate2(nums));
        }
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if(set.contains(i)){
                return true;
            }else {
                set.add(i);
            }
        }
        return false;
    }

    public static boolean containsDuplicate2(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i : nums) {
            if(map.containsKey(i)){
                return true;
            }else {
                map.put(i, true);
            }
        }
        return false;
    }
}
