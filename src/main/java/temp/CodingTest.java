package temp;

public class CodingTest {
    public static int getIndex(int[] nums, int target){
        // binary based approach
        // special case dealing
        if(nums == null || nums.length == 0){
            return -1;
        }
        // l, r, m: pointers
        int l = 0;
        int r = nums.length - 1;
        int m = l + (r - l) / 2;
        while(l <= r){
            m = l + (r - l) / 2;
            if(target == nums[m]){
                return m;
            }
            System.out.println("l = " + l + ";r = " + r + ";m = " + m);
            if(nums[l] < nums[m]){
                // left part sorted
                if(target < nums[m] && target >= nums[l]){
                    r = m - 1;
                }else{
                    // todo: fall into right unsorted part
                    l = m + 1;
                    // shrinked as smaller problem
                }
            }else{
                // right part sorted
                if(target > nums[m] && target <= nums[r]){
                    l = m + 1;
                }else{
                    // todo: fall into left unsorted part
                    r = m - 1;
                    // shrinked as smaller problem
                }
            }
            // else if(target > nums[m]){
            //   l = m + 1;
            // }else{
            //   r = m - 1;
            // }
        }

        // return index
        return -1;
    }
}
