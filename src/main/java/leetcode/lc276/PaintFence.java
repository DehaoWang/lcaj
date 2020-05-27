package leetcode.lc276;

/**
 * Created by wangdehao on 19/5/27.
 */
public class PaintFence {
    public static void main(String[] args) {

        System.out.println(numWays(3, 3));
    }

    public static int numWays(int n, int k) {

        return numWaysDP(n, k);
    }

    private static int numWaysDP(int n, int k) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return k;
        }

        int limited = k;
        int unlimited = k * (k - 1);
        for (int i = 2; i < n; i++) {
            int temp = unlimited;
            unlimited = (k - 1) * (limited + unlimited);
            limited = temp;
        }
        return limited + unlimited;
    }
}
