package leetcode.lc231;

/**
 * Created by wangdehao on 19/4/18.
 */
public class PowerOfTwo {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println("i=" + i + ", isP2=" + isPowerOfTwo(i));
        }

    }

    public static boolean isPowerOfTwo(int n) {
        while (n > 1) {
            if (n % 2 != 0) {
                return false;
            }
            n = n / 2;
        }

        return n == 1;
    }
}
