package algorithms.binarysearch;

import algorithms.utils.ArrayUtils;

public class CapacityForPackages {
    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        System.out.println(canFinish(10, weights, 5));
//        System.out.println(canFinishD(15, weights, 5));
        System.out.println(shipWithinDays(weights, 5));
    }

    public static int canFinishD(int m, int[] weights, int d) {
        int i = 0;
        int sum = 0;
        int days = 1;
        while (i < weights.length) {
            if (sum + weights[i] > m) {
                sum = 0;
                days++;
            } else {
                sum += weights[i];
                i++;
            }
        }
        return days;
    }

    public static int shipWithinDays(int[] weights, int D) {
        int l = ArrayUtils.minimax(weights)[1];
        int r = ArrayUtils.summary(weights);
        while (l < r) {
            int m = l + (r - l) / 2;
            if (canFinish(m, weights, D)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    public static boolean canFinish(int m, int[] weights, int d) {
        int i = 0;
        int sum = 0;
        int days = 1;
        while (i < weights.length) {
            if (sum + weights[i] > m) {
                sum = 0;
                days++;
            } else {
                sum += weights[i];
                i++;
            }
        }
        return days <= d;
    }
}
