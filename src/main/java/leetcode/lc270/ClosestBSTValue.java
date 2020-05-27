package leetcode.lc270;

import datastructures.basic.tree.TreeNode;
import algorithms.utils.TreeUtils;

/**
 * Created by wangdehao on 19/5/27.
 */
public class ClosestBSTValue {
    public static void main(String[] args) {
        TreeNode root3 = new TreeNode(4);
        root3.left = new TreeNode(2);
        root3.right = new TreeNode(5);

        root3.left.left = new TreeNode(1);
        root3.left.right = new TreeNode(3);
        TreeUtils.inorderTraversal(root3);
        System.out.println(closestValue(root3, 3.6));
        TreeNode root4 = new TreeNode(2);
        root4.left = new TreeNode(1);
        System.out.println(closestValue(root4, Integer.MAX_VALUE));
    }

    public static int closestValue(TreeNode root, double target) {
//        return closestValueRecursive(root, target);
        return closestValueIterative(root, target);
    }

    private static int closestValueIterative(TreeNode root, double target) {
        TreeNode curr = root;
        int cval = curr.val;
        while (curr != null) {
            if (Math.abs(curr.val - target) < Math.abs(cval - target)) {
                cval = curr.val;
            }
            if (curr.val > target) {
                curr = curr.left;
            } else if (curr.val < target) {
                curr = curr.right;
            } else {
                return curr.val;
            }
        }
        return cval;
    }


    // problem
    public static int closestValueRecursive(TreeNode curr, double target) {
        if (curr == null) {
            return 0;
        } else {
            int cvLeft = closestValueRecursive(curr.left, target);
            int cvRight = closestValueRecursive(curr.right, target);
            double diffL = Math.abs(cvLeft - target);
            double diffR = Math.abs(cvRight - target);
            double diffM = Math.abs(curr.val - target);
            // find min
            if (diffL < diffR && diffL < diffM) {
                return cvLeft;
            } else if (diffR < diffL && diffR < diffM) {
                return cvRight;
            } else {
                return curr.val;
            }
        }
    }
}
