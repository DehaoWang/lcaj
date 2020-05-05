package com.lcaj.lc110;

import com.lcaj.lc102.BTLevelOrderTraversal;
import com.lcaj.lc104.MaxDepthOfBT;
import datastructures.basic.tree.TreeNode;

/**
 * Created by wangdehao on 18/12/3.
 */
public class BalancedBinaryTree {
    public static void main(String[] args) {
        TreeNode root3 = new TreeNode(3);
        root3.left = new TreeNode(9);
        root3.right = new TreeNode(20);
        root3.right.left = new TreeNode(15);
        root3.right.right = new TreeNode(7);
        System.out.println(isBalanced(root3));
        System.out.println(isBalancedDFS(root3));

        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(2);
        root4.right = new TreeNode(3);
        root4.left.left = new TreeNode(4);
        root4.left.right = new TreeNode(5);
        root4.left.left.left = new TreeNode(6);
        root4.left.left.right = new TreeNode(7);
        System.out.println(BTLevelOrderTraversal.levelOrder(root4));
        System.out.println(isBalanced(root4));
        System.out.println(isBalancedDFS(root4));
    }

    // inefficient
    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            int depthL = MaxDepthOfBT.maxDepth(root.left);
            int depthR = MaxDepthOfBT.maxDepth(root.right);
            return isBalanced(root.left) && isBalanced(root.right) && Math.abs(depthL - depthR) <= 1;
        }
    }

    public static boolean isBalancedDFS(TreeNode root) {
        return dfsHeight(root) != -1;
    }

    public static int dfsHeight(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int dhL = dfsHeight(root.left);
            int dhR = dfsHeight(root.right);

            if (dhL == -1 || dhR == -1 || Math.abs(dhL - dhR) > 1) {
                return -1;
            } else {
                return Math.max(dhL, dhR) + 1;
            }
        }
    }
}
