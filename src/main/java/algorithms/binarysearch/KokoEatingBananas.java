package algorithms.binarysearch;

import algorithms.utils.ArrayUtils;


public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        System.out.println(minEatingSpeed(piles, 8));

        System.out.println(canFinish(4, piles, 8));

        int[] piles1 = {30, 11, 23, 4, 20};
        System.out.println(canFinish(22, piles1, 6));
        System.out.println(minEatingSpeed(piles1, 6));
    }

    public static int minEatingSpeed(int[] piles, int H) {
        int l = 1;
//        int r = ArrayUtils.minimax(piles)[1];
        int r = Integer.MIN_VALUE;
        for (int i = 0; i < piles.length; i++) {
            r = Math.max(r, piles[i]);
        }
        int m = 0;
        // correct 1
//        while (l <= r) {
//            m = l + (r - l) / 2;
//            if (canFinish(m, piles, H)) {
//                r = m - 1;
//            } else {
//                l = m + 1;
//            }
//        }
//        if (canFinish(m, piles, H)) {
//            return m;
//        } else {
//            return m + 1;
//        }

        // correct 2
        while (l < r) {
            m = l + (r - l) / 2;
            if (canFinish(m, piles, H)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    public static boolean canFinish(int m, int[] piles, int h) {
        int minH = 0;
        for (int i = 0; i < piles.length; i++) {
            minH += Math.ceil((double) piles[i] / m);
        }
        return minH <= h;
    }
}
