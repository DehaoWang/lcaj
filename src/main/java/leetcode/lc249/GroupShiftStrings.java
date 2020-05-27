package leetcode.lc249;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangdehao on 19/5/13.
 */
public class GroupShiftStrings {
    public static void main(String[] args) {
        String[] strings = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        System.out.println(groupStrings(strings));

        for (String s : strings) {
            System.out.println(s + "," + getDown2A(s));
        }
    }

    public static List<List<String>> groupStrings(String[] strings) {

        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> down2Group = new HashMap<>();
        for (String string : strings) {
            String down = getDown2A(string);
            List<String> group = down2Group.get(down);
            if (group == null) {
                group = new ArrayList<>();
                down2Group.put(down, group);
            }
            group.add(string);
        }
        for (List<String> group : down2Group.values()) {
            result.add(group);
        }
        return result;
    }

    private static String getDown2A(String string) {
        if (string == null || string.length() == 0) {
            return string;
        }
        String key = "";
        char[] chars = string.toCharArray();
        int diff = chars[0] - 'a';
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c - diff < 'a') {
                c += 26 - diff;
            } else {
                c -= diff;
                System.out.println(c);
            }
            key += c;
        }
        return key;
    }


}
