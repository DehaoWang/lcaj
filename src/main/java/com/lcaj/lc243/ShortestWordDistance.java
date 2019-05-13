package com.lcaj.lc243;

/**
 * Created by wangdehao on 19/5/13.
 */
public class ShortestWordDistance {
    public static void main(String[] args) {
        String[][] wordMatrix = {
                {"practice", "makes", "perfect", "coding", "makes"},
        };
        for (String[] words : wordMatrix) {
            System.out.println(shortestDistance(words, "coding", "practice"));
            System.out.println(shortestDistance(words, "makes", "coding"));
            System.out.println(shortestDistance(words, "practice", "perfect"));

            System.out.println(shortestDistanceFaster(words, "coding", "practice"));
            System.out.println(shortestDistanceFaster(words, "makes", "coding"));
            System.out.println(shortestDistanceFaster(words, "practice", "perfect"));
        }

    }

    public static int shortestDistance(String[] words, String word1, String word2) {

        // flag: 0-not found, 1-find first, 2-find second
        int flag = 0;
        int curr1 = 0;
        int curr2 = 0;
        int distance = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.equals(word1) && flag != 2) {
                flag = 1;
                curr1 = i;
            } else if (word.equals(word2) && flag != 1) {
                flag = 2;
                curr2 = i;
            } else if (word.equals(word1) && flag == 2) {
                flag = 1;
                curr1 = i;
                distance = Math.min(distance, i - curr2);
            } else if (word.equals(word2) && flag == 1) {
                flag = 2;
                curr2 = i;
                distance = Math.min(distance, i - curr1);
            }
        }
        return distance;
    }

    public static int shortestDistanceFaster(String[] words, String word1, String word2) {

        // flag: 0-not found, 1-find first, 2-find second
        int curr1 = -1;
        int curr2 = -1;
        int distance = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.equals(word1)) {
                curr1 = i;
                if (curr2 != -1) {
                    distance = Math.min(distance, Math.abs(curr1 - curr2));
                }
            }
            if (word.equals(word2)) {
                curr2 = i;
                if (curr1 != -1) {
                    distance = Math.min(distance, Math.abs(curr1 - curr2));
                }
            }
        }
        return distance;
    }

}
