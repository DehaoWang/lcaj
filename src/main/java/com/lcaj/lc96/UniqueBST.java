package com.lcaj.lc96;

/**
 * Created by wangdehao on 18/11/27.
 */
public class UniqueBST {
    public static void main(String[] args) {
        for (int i = 1; i < 5; i++) {
            System.out.println("i = " + i + ", uniqueBST num = " + numTrees(i));
        }

    }

    public static int numTreesDP(int n) {
        // recursive
        if (n <= 2) {
            return n;
        } else {
            int result = 0;
            // as root: f(n-1) as left
            result += numTreesDP(n - 1);
            // intersect
            // ??? too complicate

            return result;
        }
    }

    public static int numTrees(int n) {
//        return numTreesPickRoot(n);
//        return numTreesDP(n);
        return numTreesPickRootMemo(n);
    }

    private static int numTreesPickRootMemo(int n) {
        int[] memo = new int[n + 1];
        memo[0] = memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                memo[i] += memo[j - 1] * memo[i - j];
            }
        }
        return memo[n];
    }

    public static int numTreesPickRoot(int n) {
        if (n <= 1) {
            return 1;
        } else {
//        fix root, generate left & right
            int result = 0;
            for (int i = 1; i <= n; i++) {
                // left
                int l = numTreesPickRoot(i - 1);
                int r = numTreesPickRoot(n - i);
                result += l * r;
            }
            return result;
        }
    }
}
