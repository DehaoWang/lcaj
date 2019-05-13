package com.lcaj.lc245;

import com.lcaj.lc243.ShortestWordDistance;

/**
 * Created by wangdehao on 19/5/13.
 */
public class ShortestWordDistanceIII {
    public static void main(String[] args) {
        String[][] wordMatrix = {
                {"practice", "makes", "perfect", "coding", "makes"},
        };
        for (String[] words : wordMatrix) {
            System.out.println(shortestWordDistance(words, "makes", "coding"));
            System.out.println(shortestWordDistance(words, "makes", "makes"));
        }
    }

    public static int shortestWordDistance(String[] words, String word1, String word2) {
        if (word1.equals(word2)) {
            int minDistance = Integer.MAX_VALUE;
            int curr = -1;
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                if (word.equals(word1)) {
                    if (curr != -1) {
                        minDistance = Math.min(minDistance, i - curr);
                    }
                    curr = i;
                }
            }
            return minDistance;
        } else {
            return ShortestWordDistance.shortestDistance(words, word1, word2);
        }
    }
}
