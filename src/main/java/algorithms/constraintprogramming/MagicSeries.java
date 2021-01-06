package algorithms.constraintprogramming;

import algorithms.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MagicSeries {
    /**
     * send + more = money
     * https://www.coursera.org/lecture/discrete-optimization/cp-3-reification-element-constraint-magic-series-stable-marriage-TqUNj
     */
    public static void main(String[] args) {
        List<List<Integer>> res = getMagicSeries(5);
        System.out.println(res);
    }

    public static List getMagicSeries(int len) {
        List<List<Integer>> result = new ArrayList<>();

        int[] candidate = new int[len];
        for (int i = 0; i < Math.pow(10, len); i++) {
            convertIntToArray(candidate, i, len);
            if (isMagicSeries(candidate, len)) {
                List<Integer> magicSeries = convertArrayToList(candidate);
                result.add(magicSeries);
            }
        }
        return result;
    }

    private static List<Integer> convertArrayToList(int[] candidate) {
        List<Integer> list = new ArrayList<>();
        for (int digit : candidate) {
            list.add(digit);
        }
        return list;
    }

    private static boolean isMagicSeries(int[] candidate, int len) {
        int[] counter = new int[len];
        for (int i = 0; i < candidate.length; i++) {
            int val = candidate[i];
            if (val < len) {
                counter[val]++;
            }
        }
        for (int i = 0; i < len; i++) {
            if (candidate[i] != counter[i]) {
                return false;
            }
        }
        return true;
    }

    private static void convertIntToArray(int[] candidate, int n, int len) {
        for (int i = 0; i < len; i++) {
            candidate[len - i - 1] = n % 10;
            n = n / 10;
        }
    }
}
