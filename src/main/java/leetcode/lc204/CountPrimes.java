package leetcode.lc204;

/**
 * Created by wangdehao on 19/4/15.
 */
public class CountPrimes {
    public static void main(String[] args) {
        System.out.println(countPrimes(10));
        System.out.println(countPrimes(499979));

//        System.out.println(499979*499979);
    }

    public static int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                count++;
                for (int j = i; j <= (n - 1) / i; j++) {
                    notPrime[i * j] = true;
                }
            }
        }
        return count;
    }

}
