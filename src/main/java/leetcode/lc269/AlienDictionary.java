package leetcode.lc269;

import algorithms.utils.ArrayUtils;

import java.util.*;

public class AlienDictionary {
    public static void main(String[] args) {
        String[] ad = {"wrt", "wrf", "er", "ett", "rftt"};
        String[] ad1 = {"z", "x"};
        String[] ad2 = {"z", "x", "z"};
        String[] ad3 = {"z", "z"};
        String[] ad4 = {"abc", "abc"};
        System.out.println(alienOrder(ad));
        System.out.println(alienOrder(ad1));
        System.out.println(alienOrder(ad2));
        System.out.println(alienOrder(ad3));
        System.out.println(alienOrder(ad4));
    }

    public static String alienOrder(String[] words) {
        String result = "";
        Map<Character, List<Character>> cMap = new HashMap<>();
        int[] interDegrees = new int[26];
        for (int i = 0; i < words.length - 1; i++) {
            String former = words[i];
            String latter = words[i + 1];
            List<Character> pair = parsePair(cMap, former, latter);
//            System.out.println(pair);
            if (pair.isEmpty()) {
                continue;
            }
            List<Character> list = cMap.get(pair.get(0));
            if (list == null) {
                list = new ArrayList<>();
                cMap.put(pair.get(0), list);
            }
            list.add(pair.get(1));
            interDegrees[pair.get(1) - 'a']++;
        }

        Queue<Character> queue = new LinkedList<>();
        for (Character c : cMap.keySet()) {
            if (interDegrees[c - 'a'] == 0) {
                queue.offer(c);
            }
        }
//        ArrayUtils.printArray(interDegrees);
//        System.out.println(queue);
//        System.out.println(cMap);
        while (!queue.isEmpty()) {
            Character curr = queue.poll();
            result += curr;
            if (cMap.containsKey(curr)) {
                for (Character next : cMap.get(curr)) {
                    interDegrees[next - 'a']--;
                    if (interDegrees[next - 'a'] == 0) {
                        queue.offer(next);
                    }
                }
            }
        }
        return result;
    }

    public static List<Character> parsePair(Map<Character, List<Character>> cMap, String former, String latter) {
        int i = 0;
        boolean found = false;
        char resF = '.';
        char resL = '.';

        while (i < former.length() && i < latter.length()) {
            char f = former.charAt(i);
            char l = latter.charAt(i);
            if (!found && f != l) {
                found = true;
                resF = former.charAt(i);
                resL = latter.charAt(i);
            }
            if (!cMap.containsKey(f)) {
                cMap.put(f, new ArrayList<>());
            }
            if (!cMap.containsKey(l)) {
                cMap.put(l, new ArrayList<>());
            }
            i++;
        }
        if (i < former.length()) {
            while (i < former.length()) {
                if (!cMap.containsKey(former.charAt(i))) {
                    cMap.put(former.charAt(i), new ArrayList<>());
                }
                i++;
            }
        }
        if (i < latter.length()) {
            while (i < latter.length()) {
                if (!cMap.containsKey(latter.charAt(i))) {
                    cMap.put(latter.charAt(i), new ArrayList<>());
                }
                i++;
            }
        }
        if (found) {
            return Arrays.asList(resF, resL);
        } else {
            return new ArrayList<>();
        }
    }
}
