package leetcode.lc27;

/**
 * Created by wangdehao on 18/5/3.
 */
public class RemoveElement {
    public static void main( String[] args ) {
        int[][] m = {
                {3, 2, 2, 3},
                {0, 1, 2, 2, 3, 0, 4, 2},
//                {1, 2, 3, 4, 5},
//                {1, 2, 3, 4, 5, 6},
//                {1, 2, 3, 4, 5, 6, 7},
        };
        for(int[] nums: m){
            System.out.println("final length=" + removeElement(nums, 2));
        }

    }

    public static int removeElement(int[] nums, int val) {
        if(nums.length == 0){
            return 0;
        }

        int j = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[j] = nums[i];
                j++;
            }
        }
        for(int k = 0; k < j; k++){
            System.out.print(nums[k]+" ");
        }
        System.out.println();
        return j;
    }
}
