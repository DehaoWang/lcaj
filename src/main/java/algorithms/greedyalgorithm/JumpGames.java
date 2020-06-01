package algorithms.greedyalgorithm;

public class JumpGames {
    public static void main(String[] args) {
        int[] jumps = {2, 3, 1, 1, 4};
        int[] jumps1 = {3, 2, 1, 0, 4};
        int[] jumps2 = {1, 2};
        int[] jumps3 = {0, 2, 3};

        System.out.println(canJump(jumps));
        System.out.println(canJump(jumps1));
        System.out.println(canJump(jumps2));
        System.out.println(canJump(jumps3));

        System.out.println(jumpDP(jumps));
        System.out.println(jumpGreedy(jumps));
    }

    public static boolean canJump(int[] nums) {
        int last = nums.length - 1;
        int farthest = 0;
        for (int i = 0; i < last; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (farthest <= i) {
                return false;
            }
        }
        return farthest >= last;
    }

    public static int jumpDP(int[] nums) {
        // 2,3,1,1,4
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 0;
        for (int i = 1; i < len; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[len - 1];
    }

    public static int jumpGreedy(int[] nums) {
        int len = nums.length;
        int end = 0;
        int farthest = 0;
        int jumps = 0;
        for (int i = 0; i < len - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == end) {
                end = farthest;
                jumps++;
            }
        }
        return jumps;
    }
}
