package lcwc.wc187;

public class PlacesAway {
    public static void main(String[] args) {
        int[] nums = {1, 0, 0, 1, 0, 1};
        System.out.println(kLengthApart(nums, 2));

        int[] nums2 = {1, 0, 0, 0, 1, 0, 0, 1};
        System.out.println(kLengthApart(nums2, 2));

        int[] nums3 = {1, 1, 1, 1, 1};
        System.out.println(kLengthApart(nums3, 0));

        int[] nums4 = {0, 1, 0, 1};
        System.out.println(kLengthApart(nums4, 1));

        int[] nums5 = {};
        System.out.println(kLengthApart(nums5, 1));
    }

    public static boolean kLengthApart(int[] nums, int k) {
        boolean find = false;
        int preIdx = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (!find) {
                    find = true;
                } else if (i - preIdx <= k) {
                    return false;
                }
                preIdx = i;
            }
        }
        return true;
    }
}
