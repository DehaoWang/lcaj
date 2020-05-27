package leetcode.lc29;


/**
 * Created by wangdehao on 18/5/4.
 */
public class DivideTwoIntegers {
    public static void main( String[] args ) {
        int[][] m = {
                {10, 3},
                {7, -3},
                {- 7, -3},
                {-2147483648, -1}
        };
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        for(int[] a: m){
            System.out.println(String.format("dividend=%d, divisor=%d, quotient=%d", a[0], a[1], divide(a[0], a[1])));
        }

    }

    public static int divide(int dividend, int divisor) {
        long quotient = (long)dividend / divisor;
        if(quotient > Integer.MAX_VALUE || quotient < Integer.MIN_VALUE){
            return Integer.MAX_VALUE;
        }
        return (int)quotient;
    }
}
