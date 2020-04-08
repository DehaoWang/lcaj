package com.lcaj.lc771;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
    public static void main(String[] args) {

    }

    public int numJewelsInStones(String J, String S) {
        int num = 0;
        Set<Character> jSet=  new HashSet<Character>();
        for(char j: J.toCharArray()){
            jSet.add(j);
        }
        for (char s: S.toCharArray()) {
            if (jSet.contains(s)) {
                num++;
            }
        }
        return num;
    }

    public int numJewelsInStones2(String J, String S) {
        int num = 0;
        Set<Character> jSet=  new HashSet<Character>();
        for(int i = 0; i < J.length(); i++){
            jSet.add(J.charAt(i));
        }
        for (int i = 0; i < S.length(); i++) {
            if (jSet.contains(S.charAt(i))) {
                num++;
            }
        }
        return num;
    }
}
