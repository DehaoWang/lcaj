package algorithms.hashsearch;

import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3, 1, 3, 6};
        TwoSum twoSum = new TwoSum();
        for (int num : nums) {
            twoSum.addFast(num);
            twoSum.add(num);
        }
        System.out.println(twoSum.find(6));
        System.out.println(twoSum.findFast(6));

    }


    Map<Integer, Integer> num2Count = new HashMap<>();

    // 向数据结构中添加一个数 number
    public void addFast(int number) {
        num2Count.put(number, num2Count.getOrDefault(number, 0) + 1);
    }

    // 寻找当前数据结构中是否存在两个数的和为 value
    public boolean find(int value) {
        for (Integer num : num2Count.keySet()) {
            int rest = value - num;
            if (num == rest && num2Count.get(num) > 1) {
                return true;
            } else if (num2Count.containsKey(rest)) {
                return true;
            }
        }
        return false;
    }

    Set<Integer> sum = new HashSet<>();
    List<Integer> nums = new ArrayList<>();

    // 向数据结构中添加一个数 number
    public void add(int number) {
        nums.add(number);
        for (Integer num : nums) {
            sum.add(num + number);
        }
    }

    // 寻找当前数据结构中是否存在两个数的和为 value
    public boolean findFast(int value) {
        return sum.contains(value);
    }
}
