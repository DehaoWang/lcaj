package algorithms.constraintprogramming;

import algorithms.backtrack.Permutations;
import algorithms.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ArithmeticCP {
    /**
     * send + more = money
     * https://www.coursera.org/lecture/discrete-optimization/cp-2-propagation-arithmetic-constraints-send-more-money-nHott
     */
    public static void main(String[] args) {
//        solveArithmeticCP();
//        isValidNum(192837465082L);
//        solveArithmeticCpBf();
        System.out.println(isValidNumSimplified(95671082L));
        solveArithmeticCpBfSimplified();

        System.out.println(isValidLinkedListNc(Arrays.asList(9, 5, 6, 7, 1, 0, 8, 2)));
        solveArithmeticCpBfPermutation();

    }

    // index: s - 0, e - 1, n - 2, d - 3, m - 4, o - 5, r - 6, y - 7, c1 - 8, c2 - 9, c3 - 10, c4 - 11
    public static boolean isValidArray(int[] mappings) {
        int s = mappings[0];
        int e = mappings[1];
        int n = mappings[2];
        int d = mappings[3];
        int m = mappings[4];
        int o = mappings[5];
        int r = mappings[6];
        int y = mappings[7];
        int c1 = mappings[8];
        int c2 = mappings[9];
        int c3 = mappings[10];
        int c4 = mappings[11];
        // constraint 1: no leading zeros
        if (s == 0 || m == 0) {
            return false;
        }
        // constraint 2: carry limit
        for (int i = 8; i < 12; i++) {
            if (mappings[i] > 1) {
                return false;
            }
        }
        // constraint 3: letter - digit distinction
        for (int i = 0; i < 7; i++) {
            for (int j = i + 1; j < 8; j++) {
                if (mappings[i] == mappings[j]) {
                    return false;
                }
            }
        }
        // constraint 4: addition rules
        if (c4 != m
                || c3 + s + m != o + 10 * c4
                || c2 + e + o != n + 10 * c3
                || c1 + n + r != e + 10 * c2
                || d + e != y + 10 * c1) {
            return false;
        }
        return true;
    }

    // index: s - 0, e - 1, n - 2, d - 3, m - 4, o - 5, r - 6, y - 7, c1 - 8, c2 - 9, c3 - 10, c4 - 11
    public static boolean isValidLinkedList(LinkedList<Integer> mappings) {
        int s = mappings.get(0);
        int e = mappings.get(1);
        int n = mappings.get(2);
        int d = mappings.get(3);
        int m = mappings.get(4);
        int o = mappings.get(5);
        int r = mappings.get(6);
        int y = mappings.get(7);
        int c1 = mappings.get(8);
        int c2 = mappings.get(9);
        int c3 = mappings.get(10);
        int c4 = mappings.get(11);
        // constraint 1: no leading zeros
        if (s == 0 || m == 0) {
            return false;
        }
        // constraint 2: carry limit
        for (int i = 8; i < 12; i++) {
            if (mappings.get(i) > 1) {
                return false;
            }
        }
        // constraint 3: letter - digit distinction
        for (int i = 0; i < 7; i++) {
            for (int j = i + 1; j < 8; j++) {
                if (mappings.get(i) == mappings.get(j)) {
                    return false;
                }
            }
        }
        // constraint 4: addition rules
        if (c4 != m
                || c3 + s + m != o + 10 * c4
                || c2 + e + o != n + 10 * c3
                || c1 + n + r != e + 10 * c2
                || d + e != y + 10 * c1) {
            return false;
        }
        return true;
    }

    public static void solveArithmeticCP() {
        List result = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<Integer>();
        backtrack(result, track, 0);
    }

    public static void backtrack(List result, LinkedList<Integer> track, int start) {
        if (track.size() == 12) {
            System.out.println(track);
            if (isValidLinkedList(track)) {
                result.add(track);
            }
            return;
        }
//        System.out.println(track);
        for (int i = 0; i < 10; i++) {
            track.add(i);
            backtrack(result, track, start);
            track.removeLast();
        }
    }

    public static void solveArithmeticCpBf() {
        List result = new ArrayList();
        for (long i = 0; i < 1000000000000L; i++) {
            if (i % 100000000 == 0) {
                System.out.println(i);
            }
            if (isValidNum(i)) {
                System.out.println("******************** = " + i);
                result.add(i);
            }
        }
        System.out.println("result = " + result);
    }

    // index: s - 0, e - 1, n - 2, d - 3, m - 4, o - 5, r - 6, y - 7, c1 - 8, c2 - 9, c3 - 10, c4 - 11
    private static boolean isValidNum(long i) {
        LinkedList list = new LinkedList<Integer>();
        int c4 = (int) (i % 10);
        int c3 = (int) (i / 10 % 10);
        int c2 = (int) (i / 100 % 10);
        int c1 = (int) (i / 1000 % 10);
        int y = (int) (i / 10000 % 10);
        int r = (int) (i / 100000 % 10);
        int o = (int) (i / 1000000 % 10);
        int m = (int) (i / 10000000 % 10);
        int d = (int) (i / 100000000 % 10);
        int n = (int) (i / 1000000000 % 10);
        int e = (int) (i / 10000000000L % 10);
        int s = (int) (i / 100000000000L % 10);
        list.add(s);
        list.add(e);
        list.add(n);
        list.add(d);
        list.add(m);
        list.add(o);
        list.add(r);
        list.add(y);
        list.add(c1);
        list.add(c2);
        list.add(c3);
        list.add(c4);
        boolean valid = isValidLinkedList(list);
//        System.out.println(valid);
        return valid;
    }


    private static boolean isValidNumSimplified(long i) {
        int y = (int) (i % 10);
        int r = (int) (i / 10 % 10);
        int o = (int) (i / 100 % 10);
        int m = (int) (i / 1000 % 10);
        int d = (int) (i / 10000 % 10);
        int n = (int) (i / 100000 % 10);
        int e = (int) (i / 1000000L % 10);
        int s = (int) (i / 10000000L % 10);

        if (s == 0 || m == 0) {
            return false;
        }
        if (s == e || s == n || s == d || s == m || s == o || s == r || s == y
                || e == n || e == d || e == m || e == o || e == r || e == y
                || n == d || n == m || n == o || n == r || n == y
                || d == m || d == o || d == r || d == y
                || m == o || m == r || m == y
                || o == r || o == y
                || r == y) {
            return false;
        }

        int send = s * 1000 + e * 100 + n * 10 + d;
        int more = m * 1000 + o * 100 + r * 10 + e;
        int money = m * 10000 + o * 1000 + n * 100 + e * 10 + y;

        return send + more == money;
    }

    public static void solveArithmeticCpBfSimplified() {
        List result = new ArrayList();
        for (long i = 0; i < 100000000L; i++) {
            if (isValidNumSimplified(i)) {
                result.add(i);
            }
        }
        System.out.println("result = " + result);
        System.out.println(result.size());
    }

    public static void solveArithmeticCpBfPermutation() {
        List result = new ArrayList();
        int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<List<Integer>> permutations = Permutations.permute(numbers, 8);
        for (List<Integer> permutation : permutations) {
            if (isValidLinkedListNc(permutation)) {
                result.add(permutation);
            }
        }

        System.out.println(permutations.size());
        System.out.println(result);
    }

    // index: s - 0, e - 1, n - 2, d - 3, m - 4, o - 5, r - 6, y - 7, c1 - 8, c2 - 9, c3 - 10, c4 - 11
    public static boolean isValidLinkedListNc(List<Integer> mappings) {
        int s = mappings.get(0);
        int e = mappings.get(1);
        int n = mappings.get(2);
        int d = mappings.get(3);
        int m = mappings.get(4);
        int o = mappings.get(5);
        int r = mappings.get(6);
        int y = mappings.get(7);


        // constraint 1: no leading zeros
        if (s == 0 || m == 0) {
            return false;
        }
        // constraint 3: letter - digit distinction
        for (int i = 0; i < 7; i++) {
            for (int j = i + 1; j < 8; j++) {
                if (mappings.get(i) == mappings.get(j)) {
                    return false;
                }
            }
        }
        // constraint 4: addition rules
        int send = s * 1000 + e * 100 + n * 10 + d;
        int more = m * 1000 + o * 100 + r * 10 + e;
        int money = m * 10000 + o * 1000 + n * 100 + e * 10 + y;

        return send + more == money;
    }
}
