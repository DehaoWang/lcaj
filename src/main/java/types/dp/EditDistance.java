package types.dp;

import com.lcaj.util.MatrixMethods;

import java.util.ArrayList;
import java.util.List;

public class EditDistance {

    static class NodeDP {
        final static char INSERT = 'I';
        final static char DELETE = 'D';
        final static char MODIFY = 'M';
        final static char REMAIN = 'R';
        final static char DEF = '#';

        int val;
        char choice;
        // [i] insert
        // [d] delete
        // [m] modify
        // [r] remain
        String ele = "";

        public NodeDP(int v, char c) {
            this.val = v;
            this.choice = c;
        }
    }

    public static void main(String[] args) {
        String[] sourceList = {
                "horse",
                "intention"
        };
        String[] targetList = {
                "ros",
                "execution"
        };
        for (int i = 0; i < sourceList.length; i++) {
            System.out.println(minDistanceDP(sourceList[i], targetList[i]));
            NodeDP[][] nodeDPS = minDistanceNodeDP(sourceList[i], targetList[i]);
            System.out.println(minDistance(nodeDPS));
            printNodeVals(nodeDPS);
            printNodeChoices(nodeDPS);
            System.out.println(operations(nodeDPS));
        }
    }

    public static int minDistanceDP(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        int[][] dp = new int[lenS + 1][lenT + 1];
        for (int i = 1; i <= lenS; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= lenT; j++) {
            dp[0][j] = j;
        }
//        MatrixMethods.printMatrix(dp);
        for (int i = 1; i <= lenS; i++) {
            for (int j = 1; j <= lenT; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = multiMin(
                            1 + dp[i - 1][j - 1],   // modify
                            1 + dp[i - 1][j],       // delete
                            1 + dp[i][j - 1]        // insert
                    );
                }
            }
        }
        MatrixMethods.printMatrix(dp);
        return dp[lenS][lenT];
    }

    public static int multiMin(int i, int d, int m) {
        return Math.min(Math.min(i, d), m);
    }

    public static NodeDP[][] minDistanceNodeDP(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        NodeDP[][] dp = new NodeDP[lenS + 1][lenT + 1];
        for (int i = 0; i <= lenS; i++) {
            for (int j = 0; j <= lenT; j++) {
                dp[i][j] = new NodeDP(0, NodeDP.DEF);
            }
        }
        for (int i = 1; i <= lenS; i++) {
            dp[i][0].val = i;
        }
        for (int j = 1; j <= lenT; j++) {
            dp[0][j].val = j;
        }
//        MatrixMethods.printMatrix(dp);
        for (int i = 1; i <= lenS; i++) {
            for (int j = 1; j <= lenT; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    update(dp[i][j], dp[i - 1][j - 1].val, NodeDP.REMAIN, s.charAt(i - 1));  // remain
                } else {
                    updateOp(dp[i][j],
                            1 + dp[i][j - 1].val,
                            1 + dp[i - 1][j].val,
                            1 + dp[i - 1][j - 1].val,
                            s.charAt(i - 1),
                            t.charAt(j - 1)
                    );
                }
            }
        }
//        MatrixMethods.printMatrix(dp);
        return dp;
    }

    private static void update(NodeDP nodeDP, int val, char choice, char c) {
        nodeDP.val = val;
        nodeDP.choice = choice;
        nodeDP.ele = c + "";
    }

    private static void updateOp(NodeDP nodeDP, int i, int d, int m, char cS, char cT) {
        if (i <= d && i <= m) {
            nodeDP.val = i;
            nodeDP.choice = NodeDP.INSERT;
            nodeDP.ele = cT + "";
        } else if (d <= i && d <= m) {
            nodeDP.val = d;
            nodeDP.choice = NodeDP.DELETE;
            nodeDP.ele = cS + "";
        } else {
            nodeDP.val = m;
            nodeDP.choice = NodeDP.MODIFY;
            nodeDP.ele = cS + " -> " + cT;
        }
    }

    public static void printNodeChoices(NodeDP[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j].choice + " ");
            }
            System.out.println();
        }
    }

    private static void printNodeVals(NodeDP[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j].val + " ");
            }
            System.out.println();
        }
    }

    private static int minDistance(NodeDP[][] nodeDPS) {
        int r = nodeDPS.length;
        int c = nodeDPS[0].length;
        return nodeDPS[r - 1][c - 1].val;
    }

    private static List<String> operations(NodeDP[][] nodeDPS) {
        List<String> res = new ArrayList<>();
        int i = nodeDPS.length - 1;
        int j = nodeDPS[0].length - 1;
        while (i >= 0 && j >= 0) {
            NodeDP nodeDP = nodeDPS[i][j];
            res.add(nodeDP.choice + ":" + nodeDP.ele);
            if (nodeDP.choice == NodeDP.INSERT) {
                j--;
            } else if (nodeDP.choice == NodeDP.DELETE) {
                i--;
            } else {
                i--;
                j--;
            }
        }
        return res;
    }
}
