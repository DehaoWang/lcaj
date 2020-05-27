package leetcode.lc169;

/**
 * Created by wangdehao on 19/4/9.
 */
public class MajorityElement {
    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 3, 3, 2};
        int[] nums2 = {1, 2, 3, 4, 4};
        System.out.println(majorityElement(nums));
        System.out.println(majorityElement(nums2));
    }

    public static int majorityElement(int[] nums) {
        int count = 0;
        Integer majorEle = null;
        for (int n : nums) {
            if (count == 0) {
                majorEle = n;
            }
            if (n == majorEle) {
                count++;
            } else {
                count--;
            }
        }

        return majorEle;
    }
}
