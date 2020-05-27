package leetcode.lc58;

/**
 * Created by wangdehao on 18/11/11.
 */
public class LengthOfLastWord {

    public static void main(String[] args) {
        String str = "Hello World";
//        System.out.println(lengthOfLastWord(str));
        System.out.println(lengthOfLastWord(""));
        System.out.println(lengthOfLastWord("x"));
        System.out.println(lengthOfLastWord("x "));
        System.out.println(lengthOfLastWord("hello world"));
        System.out.println(lengthOfLastWord("hello world test;"));
    }

    public static int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();
        int count = 0;
        boolean leadingEmpty = true;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] != ' ') {
                count++;
                leadingEmpty = false;
            } else if (!leadingEmpty) {
                return count;
            }
        }
        return count;
    }

}
