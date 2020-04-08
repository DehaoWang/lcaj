package com.lcaj.lc728;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {
    public static void main(String[] args) {

        for (int i = 0; i < 23; i++) {

//            System.out.println(i + "," + isSelfDividing(i));
        }
        System.out.println(selfDividingNumbers(1, 22));
    }

    public static List<Integer> selfDividingNumbers(int left, int right) {
        List list = new ArrayList();
        for (int i = left; i <= right; i++) {
            if (isSelfDividing(i)) {
                list.add(i);
            }
        }
        return list;
    }

    private static boolean isSelfDividing(int i) {
        int q = i;
        int r;
        while (q > 0) {
            r = q % 10;
            if (r == 0 || i % r != 0) {
                return false;
            } else {
                q = q / 10;
            }
        }
        return true;
    }


}
