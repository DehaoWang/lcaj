package leetcode.lc30;

import java.util.*;

/**
 * Created by wangdehao on 18/5/4.
 */
public class SubstringWithConcatenationOfAllWords {
    public static void main( String[] args ) {
        Map<String, String[]> samples = new HashMap<>();
        samples.put("barfoothefoobarman", new String[]{"foo", "bar"});
        samples.put("wordgoodstudentgoodword", new String[]{"word", "student"});
        samples.put("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"});
        samples.put("foobarfoobar", new String[]{"foo", "bar"});

        for(String key : samples.keySet()){
            String[] value = samples.get(key);
            System.out.println(findSubstringConcatFirst(key, value));
        }
    }

    public List<Integer> findSubstring(String s, String[] words) {




        return new ArrayList<>();
    }

    // too complex
    public static List<Integer> findSubstringConcatFirst(String s, String[] words) {
        for(String w : words){
            if(s.indexOf(w) < 0){
                return new ArrayList<>();
            }
        }
        List<Integer> indicies = new ArrayList<>();
        List<String> wordList = Arrays.asList(words);
        Set<String> concatenations = concatStrings(wordList);
        System.out.println("concatenations="+concatenations);
        for(String concat : concatenations){
            List<Integer> allIdx = allIndexOf(s, concat);
            indicies.addAll(allIdx);
        }
        return indicies;
    }

    public static List<Integer> allIndexOf(String s, String concat) {
        List<Integer> allIdx = new ArrayList<>();
        int first = 0;
        while(first < s.length()){
            int idx = s.indexOf(concat, first);
            if(idx >= 0){
                allIdx.add(idx);
                first = idx+1;
            }
            else {
                break;
            }
        }
        return allIdx;
    }

    public static Set<String> concatStrings(List<String> words) {
        Set<String> concatenations = new HashSet<>();
        int len = words.size();
        if(len == 0){
            return concatenations;
        }
        if(len == 1){
            concatenations.addAll(words);
            return concatenations;
        }
        for(int i = 0 ; i < len; i++){
            String s = words.get(i);

            List<String> rest = new ArrayList<>();

            for(int j = 0; j < len; j++){
                if(j != i)
                rest.add(words.get(j));
            }

            Set<String> restConcat = concatStrings(rest);
            for(String rc: restConcat){
                concatenations.add(s+rc);
                concatenations.add(rc+s);
            }
        }

        return concatenations;
    }

    //
    public static List<Integer> findSubstringIndexMap(String s, String[] words) {
        List<Integer> indicies = new ArrayList<>();
        List<Integer> wordIndicies = new ArrayList<>();
        for(String w: words){
            int idx = s.indexOf(w);
//            s.
            wordIndicies.add(idx);
        }

//        List<Integer> indicies = getConsecutive

        return new ArrayList<>();
    }
}
