package com.lcaj.lc170;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by wangdehao on 19/4/9.
 */
public class TwoSumIII {
    Set<Integer> twoSum;
    Map<Integer, Boolean> elementOccur;

    /**
     * Initialize your data structure here.
     */
    public TwoSumIII() {
        twoSum = new HashSet<>();
        elementOccur = new HashMap<>();
    }

    /**
     * Add the number to an internal data structure..
     */
    public void add(int number) {
        if (!elementOccur.containsKey(number)) {
            for (Integer ele : elementOccur.keySet()) {
                twoSum.add(number + ele);
            }
            elementOccur.put(number, true);
        } else {
            twoSum.add(2 * number);
        }
    }

    /**
     * Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        return twoSum.contains(value);
    }
}
