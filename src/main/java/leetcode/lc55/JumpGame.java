package leetcode.lc55;


/**
 * Created by wangdehao on 18/11/11.
 */
public class JumpGame {


    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        int[] nums1 = {3, 2, 1, 0, 4};
        int[] nums2 = {2, 0, 0};
        int[] nums3 = {2, 5, 0, 0};

        System.out.println(canJump(nums));
        System.out.println(canJump(nums1));
        System.out.println(canJump(nums2));
        System.out.println(canJump(nums3));
    }

    public static boolean canJump(int[] nums) {
//        return canJumpRecursive(nums, 0);
//        return canJumpMemoFinal(nums);
//        return canJumpPaint(nums);
//        return canJumpMemo(nums);
        return canJumpGreedy(nums);
    }

    public static boolean canJumpGreedy(int[] nums) {
        int n = nums.length;
        int reach = 0;
        for (int i = 0; i < n; ++i) {
            // clever: "i > reach" means current index is unreachable
            if (i > reach || reach >= n - 1) break;
            reach = reach > i + nums[i] ? reach : i + nums[i];
        }
        return reach >= n - 1;
    }

    private static boolean canJumpMemoFinal(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }
        int[] memo = new int[nums.length];
        canJumpMemoRecursive(nums, memo, 0);
        return memo[0] == 1;
    }

    private static void canJumpMemoRecursive(int[] nums, int[] memo, int fromIdx) {
        if (memo[fromIdx] != 0) {
            return;
        }
        int lastIdx = nums.length - 1;
        int maxSteps = nums[fromIdx];
        if (fromIdx + maxSteps >= lastIdx) {
            memo[fromIdx] = 1;
        } else {
            for (int i = 1; i <= maxSteps; i++) {
                if (memo[fromIdx + i] == 0) {
                    canJumpMemoRecursive(nums, memo, fromIdx + i);
                } else if (memo[fromIdx + i] == -1) {
                    continue;
                } else {
                    memo[fromIdx] = 1;
                    return;
                }
            }
            memo[fromIdx] = -1;
        }
    }

    // operational but taking too much time
    public static boolean canJumpRecursive(int[] nums, int fromIdx) {
        if (fromIdx == nums.length - 1) {
            return true;
        }
        if (fromIdx > nums.length - 1) {
            return false;
        }
        int maxSteps = nums[fromIdx];
        for (int i = 1; i <= maxSteps; i++) {
            if (canJumpRecursive(nums, fromIdx + i)) {
                return true;
            }
        }
        return false;
    }

    // operational but taking too much time
    public static boolean canJumpPaint(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }
        boolean[] paint = new boolean[nums.length];
        canJumpPaintRecursive(nums, paint, 0);
        return paint[nums.length - 1];
    }

    private static void canJumpPaintRecursive(int[] nums, boolean[] paint, int fromIdx) {
        for (int i = 1; i <= nums[fromIdx] && fromIdx + i < nums.length; i++) {
            paint[fromIdx + i] = true;
            canJumpPaintRecursive(nums, paint, fromIdx + i);
        }
    }

    // memo: backwards 
    // TODO: 18/11/11
    public static boolean canJumpMemo(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return true;
        }
        // indicating where can jump from r->l

        // NOTES: use true/false cannot mark visited or not, should use other marker
//        boolean[][] memo = new boolean[length][length];
//        directUpdate(nums, memo);
//        memoUpdate(memo, 0, length - 1);

        // 0:unvisited, 1:v-good, -1:v-bad
        int[][] memoMarker = new int[length][length];
        memoUpdateMarker(nums, memoMarker, 0, length - 1);
        return memoMarker[0][length - 1] == 1;
    }

    // time satisfies the limit, but memory does not
    private static void memoUpdateMarker(int[] nums, int[][] memo, int l, int r) {
        if (memo[l][r] == 0) {
            if (l == r) {
                memo[l][r] = 1;
                return;
            } else if (nums[l] >= r - l) {
                memo[l][r] = 1;
                return;
            }
            for (int k = l + 1; k < r; k++) {
                memoUpdateMarker(nums, memo, l, k);
                memoUpdateMarker(nums, memo, k, r);
                if (memo[l][k] == 1 && memo[k][r] == 1) {
                    memo[l][r] = 1;
                    return;
                }
            }
            memo[l][r] = -1;
        }


    }

    private static void memoUpdate(boolean[][] memo, int l, int r) {
        if (memo[l][r]) {
            return;
        }
        for (int k = l + 1; k < r; k++) {
            memoUpdate(memo, l, k);
            memoUpdate(memo, k, r);
            memo[l][r] = memo[l][k] && memo[k][r];
            if (memo[l][r]) {
                return;
            }
        }
    }

    private static void directUpdate(int[] nums, boolean[][] memo) {
        for (int i = 0; i < memo.length - 1; i++) {
            for (int j = i + 1; j < memo.length; j++) {
                if (nums[i] >= j - i) {
                    memo[i][j] = true;
                }
            }
        }
    }
}
