package com.lcaj.lc244;

import com.lcaj.model.ListNode;

import java.util.*;

/**
 * Created by wangdehao on 19/5/13.
 */
public class ShortestWordDistanceII {

    public static void main(String[] args) {

        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        ShortestWordDistanceII shortestWordDistanceII = new ShortestWordDistanceII(words);
        System.out.println(shortestWordDistanceII.shortest("coding", "practice"));
        System.out.println(shortestWordDistanceII.shortest("coding", "makes"));
        System.out.println(shortestWordDistanceII.shortest("perfect", "practice"));
    }

    Map<Set<String>, Integer> pair2Distance = new HashMap<>();
    Map<String, Integer> word2MaxIndex = new HashMap<>();
    Map<String, List<Integer>> word2Locations = new HashMap<>();

    public ShortestWordDistanceII(String[] words) {
        // approach 1: space limit exceeding
//        for (int i = 0; i < words.length; i++) {
//            String word = words[i];
//            for (String key : word2MaxIndex.keySet()) {
//                if (!key.equals(word)) {
//                    Set<String> pair = new HashSet<>();
//                    pair.addAll(Arrays.asList(word, key));
//                    Integer maxIndex = word2MaxIndex.get(key);
//                    if (pair2Distance.containsKey(pair)) {
//                        // update or not
//                        Integer minDistance = pair2Distance.get(pair);
//                        pair2Distance.put(pair, Math.min(minDistance, i - maxIndex));
//                    } else {
//                        pair2Distance.put(pair, i - maxIndex);
//                    }
//                }
//            }
//            word2MaxIndex.put(word, i);
//        }


        // approach 2
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            List<Integer> locations = word2Locations.get(word);
            if (locations == null) {
                locations = new ArrayList<>();
                word2Locations.put(word, locations);
            }
            locations.add(i);
        }
    }

    public int shortest(String word1, String word2) {
        // approach 1: space limit exceeding
//        Set<String> pair = new HashSet<>();
//        pair.addAll(Arrays.asList(word1, word2));
//        return pair2Distance.get(pair);

        // approach 2
        List<Integer> locations1 = word2Locations.get(word1);
        List<Integer> locations2 = word2Locations.get(word2);
        int i1 = 0;
        int i2 = 0;
        int minDistance = Integer.MAX_VALUE;
        while (i1 < locations1.size() && i2 < locations2.size()) {
            int loc1 = locations1.get(i1);
            int loc2 = locations2.get(i2);
            minDistance = Math.min(minDistance, Math.abs(loc2 - loc1));
            if (loc1 < loc2) {
                i1++;
            } else {
                i2++;
            }
        }
        return minDistance;
    }
}
