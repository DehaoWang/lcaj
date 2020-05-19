package algorithms.faq;

import algorithms.utils.ArrayUtils;

public class PrimesCounting {
    public static void main(String[] args) {
        for (int i = 20; i < 21; i++) {
            System.out.println(i + ", " + countPrimes(i));
        }
    }

    public static int countPrimes(int n) {
        // sieve approach
        if (n <= 1) {
            return 0;
        }
        boolean[] nonPrimes = new boolean[n];
        for (int i = 2; i * i < n; i++) {
            if (!nonPrimes[i]) {
                for (int j = i; j * i < n; j++) {
                    nonPrimes[j * i] = true;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!nonPrimes[i]) {
                count++;
            }
        }
        ArrayUtils.printArray(nonPrimes);
        return count;
    }
}
