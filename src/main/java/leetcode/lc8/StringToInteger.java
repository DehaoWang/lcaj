package leetcode.lc8;


/**
 * Created by wangdehao on 18/4/20.
 */
public class StringToInteger {
    public static void main(String[] args){
        String[] strs = {
                "42"
                ,
                "  -42"
                ,
                "4193 with words"
                ,
                "-91283472332"
                ,
                "words and 987"
                ,
                "+-2"
                ,
                "   +0 123"
                ,
                " - 321"
                ,
                "++1"
                ,
                "-+1"
                ,
                "9223372036854775809"
                ,
                "-9223372036854775809"
                ,
                "   -42"
                ,
                "18446744073709551617"
        };
        for(String s: strs){
            System.out.println(String.format("origin=%-20s, atoi=%-20d, atoiGS=%-20d", s, myAtoi(s), myAtoiGS(s)));
        }

    }


    public static int myAtoi(String str) {
        long res = 0;
        boolean findNum = false;
        boolean findSign = false;
        boolean minus = false;
        int signCnt = 0;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(!findNum && !findSign && c == ' '){
                continue;
            }
//            System.out.println(String.format("c=%c, findNum=%b, findSign=%b", c, findNum, findSign));
//            if(!findNum && findSign && c == ' '){
//                return 0;
//            }
            else if(c != '+' && c != '-' && !(c >= '0' && c <= '9')){
                break;
            }
            else {
                if(!findNum){
                    if(c == '+'){
                        findSign = true;
                        signCnt++;
                    }
                    if(c == '-'){
                        minus = true;
                        findSign = true;
                        signCnt++;
                    }
                }
                if(c >= '0' && c <= '9'){
                    findNum = true;
                    res = res*10 + (c-'0');
                    if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE){
                        break;
                    }
                }
//                System.out.println(String.format("c=%s, res=%d, findNum=%b", c, res, findNum));
                if(findNum && !(c >= '0' && c <= '9')){
                    break;
                }
            }
        }
        if(signCnt > 1){
            return 0;
        }
        if(!minus){
            if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE){
                return Integer.MAX_VALUE;
            }
        }
        else{
            res = -res;
            if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
        }
        return (int)res;
    }

    // loop until invalid
    public static int myAtoiGS(String str){

        int i = 0, sign = 1, n = str.length();
        long r = 0;
        if(n == 0){
            return 0;
        }
        while(i < n && str.charAt(i) == ' '){
            i++;
        }

        if(str.charAt(i) == '+' || str.charAt(i) == '-'){
            sign = str.charAt(i) == '+' ? 1 : -1;
            i++;
        }

        while (i < n){
            int num = str.charAt(i) - '0';
            if(num < 0 || num > 9){
                break;
            }
            r = 10 * r + num;
            if(r > Integer.MAX_VALUE || r < Integer.MIN_VALUE){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            i++;
        }
        return sign * (int)r;
    }
}
