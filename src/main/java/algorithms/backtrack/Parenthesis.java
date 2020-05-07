package algorithms.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Parenthesis {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        LinkedList<Character> chs = new LinkedList<>();
        backtrack(res, chs, n, n);
        return res;
    }

    public static void backtrack(List<String> res, LinkedList<Character> chs, int l, int r) {
        if (l == 0 && r == 0) {
            res.add(chList2String(chs));
            return;
        }
        if (l < r) {
            chs.add(')');
            backtrack(res, chs, l, r - 1);
            chs.removeLast();
        }
        if (l > 0) {
            chs.add('(');
            backtrack(res, chs, l - 1, r);
            chs.removeLast();
        }
    }

    public static String chList2String(List<Character> chs) {
        String s = "";
        for (Character ch : chs) {
            s += ch;
        }
        return s;
    }
}
