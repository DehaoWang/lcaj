package leetcode.lc746;

public class MinCostClimbingStairs {
    public static void main(String[] args) {

    }

    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        } else if (cost.length == 1) {
            return cost[0];
        }
        int len = cost.length;
        int[] minCost = new int[len];
        minCost[0] = cost[0];
        minCost[1] = cost[1] + Math.min(0, cost[0]);
        for (int i = 2; i < len; i++) {
            minCost[i] = cost[i] + Math.min(minCost[i - 1], minCost[i - 2]);
        }
        return Math.min(minCost[len - 1], minCost[len - 2]);
    }
}
