package algorithms.twopointers;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trapMemo(height));
        System.out.println(trapTwoPointers(height));
        System.out.println(trapTwoPointersFaster(height));
    }

    public static int trapMemo(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int len = height.length;

        int[] leftMax = new int[len];
        leftMax[0] = height[0];
        for (int i = 1; i < len; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        int[] rightMax = new int[len];
        rightMax[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            int min = Math.min(leftMax[i], rightMax[i]);
            ans += min - height[i];
        }
        return ans;
    }

    public static int trapTwoPointers(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int len = height.length;
        int ans = 0;
        int l = 0;
        int r = len - 1;
        int lMax = height[l];
        int rMax = height[r];
        while (l <= r) {
            lMax = Math.max(lMax, height[l]);
            rMax = Math.max(rMax, height[r]);

            if (lMax < rMax) {
                ans += lMax - height[l];
                l++;
            } else {
                ans += rMax - height[r];
                r--;
            }
        }
        return ans;
    }

    public static int trapTwoPointersFaster(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int len = height.length;
        int ans = 0;
        int l = 0;
        int r = len - 1;
        int lMax = height[l];
        int rMax = height[r];
        while (l <= r) {
            if (height[l] < height[r]) {
                lMax = Math.max(lMax, height[l]);
                ans += lMax - height[l];
                l++;
            } else {
                rMax = Math.max(rMax, height[r]);
                ans += rMax - height[r];
                r--;
            }
        }
        return ans;
    }
}
