package leetcode.lc134;

/**
 * Created by wangdehao on 18/12/6.
 */
public class GasStation {
    public static void main(String[] args) {

        int[][] gasMatrix = {
                {1, 2, 3, 4, 5},
                {2, 3, 4},
                {5, 1, 2, 3, 4}
        };
        int[][] costMatrix = {
                {3, 4, 5, 1, 2},
                {3, 4, 3},
                {4, 4, 1, 5, 1}
        };
        for (int i = 0; i < gasMatrix.length; i++) {
            System.out.println(canCompleteCircuit(gasMatrix[i], costMatrix[i]));
        }
    }


    public static int canCompleteCircuit(int[] gas, int[] cost) {

//        return methodBF(gas, cost);
        return methodEff(gas, cost);
//
    }

    public static int methodEff(int[] gas, int[] cost) {
        int globalSumDiff = 0;
        int localSumDiff = 0;
        int firstPos = -1;
        boolean findRes = false;
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            globalSumDiff += diff;
            localSumDiff += diff;
            // local - global
            if (diff >= 0 && !findRes) {
                firstPos = i;
                findRes = true;
            } else if (localSumDiff < 0) {
                firstPos = -1;
                localSumDiff = 0;
                findRes = false;
            }
        }
        if(globalSumDiff >= 0){
            return firstPos;
        }else {
            return -1;
        }
    }

    // too slow
    public static int methodBF(int[] gas, int[] cost) {
        int len = gas.length;
        for (int i = 0; i < len; i++) {
            int currIdx = i;
            int currGas = 0;
            int visitCnt = 0;
            while (currGas >= 0) {
                currGas += gas[currIdx] - cost[currIdx];
                currIdx = (currIdx + 1) % len;
                visitCnt++;
                if (visitCnt >= len && currGas >= 0) {
                    return i;
                }
            }
        }
        return -1;
    }
}
