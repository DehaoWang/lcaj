package algorithms.bitoperations;

public class BitOperations {
    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {
            System.out.println("erase last one of " + i + " = " + eraseLastOne(i));
            System.out.println("hamming weight of " + i + " = " + hammingWeight(i));
            System.out.println("is Power Of Two of " + i + " = " + isPowerOfTwo(i));

        }
    }

    public static int eraseLastOne(int n) {
        return n & (n - 1);
    }

    public static int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n = eraseLastOne(n);
            res++;
        }
        return res;
    }

    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return eraseLastOne(n) == 0;
    }
}
