package leetcode.lc172;

/**
 * Created by wangdehao on 19/4/10.
 */
public class FactorialTrailingZeros {
    public static void main(String[] args) {
        for (int i = 0; i < 32; i++) {
            System.out.println(i + ":" + factorial(i) + ":" + trailingZeroes(i));
        }

    }

    // recursive but stackoverflow
    public static int trailingZeroesRec(int n) {
        if (n < 5) {
            return 0;
        }
        if (n % 5 == 0) {
            return trailingZeroesRec(n - 1) + 1;
        } else {
            return trailingZeroesRec(n - 1);
        }
    }

    public static long factorial(int n) {
        if (n <= 1) {
            return n;
        } else {
            return n * factorial(n - 1);
        }
    }

    // memo
    public static int trailingZeroes(int n) {
        int[] zeroCnt = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            if (i < 5) {
                zeroCnt[i] = 0;
            } else {
                zeroCnt[i] = i % 5 == 0 ? zeroCnt[i - 1] + 1 : zeroCnt[i - 1];
            }
        }
        return zeroCnt[n];
    }

}
