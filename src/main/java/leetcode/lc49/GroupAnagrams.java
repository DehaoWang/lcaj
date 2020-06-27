package leetcode.lc49;

import algorithms.utils.StringUtils;

import java.util.*;

/**
 * Created by wangdehao on 18/11/5.
 */

public class GroupAnagrams {
    public static void main(String[] args) {

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] strs2 = {"hos", "boo", "nay", "deb", "wow", "bop", "bob", "brr", "hey", "rye", "eve", "elf", "pup", "bum", "iva", "lyx", "yap", "ugh", "hem", "rod", "aha", "nam", "gap", "yea", "doc", "pen", "job", "dis", "max", "oho", "jed", "lye", "ram", "pup", "qua", "ugh", "mir", "nap", "deb", "hog", "let", "gym", "bye", "lon", "aft", "eel", "sol", "jab"};
        List<List<String>> result = groupAnagrams(strs);
        List<List<String>> result2 = groupAnagrams(strs2);
        System.out.println(result);
        System.out.println(result2);

        System.out.println(StringUtils.getAnagramEncoding("abac"));
    }

    // attempt at 20/06/26
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<Integer, List<String>> resMap = new HashMap<>();
        for (String s : strs) {
            // hash conflict
//            Map<Character, Integer> ciMap = StringUtils.getStrMap(s);
//            int code = ciMap.hashCode();
            int code = StringUtils.myHashCode(s);
            List<String> group = resMap.get(code);
            if (group == null) {
                group = new ArrayList<>();
                resMap.put(code, group);
            }
            group.add(s);
        }
        result.addAll(resMap.values());
        return result;
    }

    // TODO: 18/11/5 discard
//    public static List<List<String>> groupAnagrams(String[] strs) {
//        // engineering approach
//        // problem 1: pop poo
//        List<List<String>> result = new ArrayList<>();
//        Map<Set<Character>, List<String>> anagramsGroup = new HashMap<>();
//
//        if(strs.length == 0){
//            return result;
//        }
//        for (String s : strs) {
//            Set<Character> elements = new HashSet<>();
//            for (int i = 0; i < s.length(); i++) {
//                elements.add(s.charAt(i));
//            }
//            List<String> anagrams = anagramsGroup.get(elements);
//            if (anagrams == null) {
//                anagrams = new ArrayList<>();
//                anagramsGroup.put(elements, anagrams);
//            }
//            anagrams.add(s);
//        }
//
//        for(Set<Character> elements: anagramsGroup.keySet()){
//            List<String> anagrams = anagramsGroup.get(elements);
//            result.add(anagrams);
//        }
//
//        return result;
//
//    }
}
