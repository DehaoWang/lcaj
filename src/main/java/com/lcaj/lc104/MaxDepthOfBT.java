package com.lcaj.lc104;

import datastructures.basics.tree.TreeNode;

/**
 * Created by wangdehao on 18/11/29.
 */
public class MaxDepthOfBT {
    public static void main(String[] args) {
        TreeNode root3 = new TreeNode(3);
        root3.left = new TreeNode(9);
//        root3.right = new TreeNode(20);
//
//        root3.right.left = new TreeNode(15);
//        root3.right.right = new TreeNode(7);
//        root3.left.left = new TreeNode(2);
//        root3.left.right = new TreeNode(1);
        System.out.println(maxDepth(root3));
    }

    public static int maxDepth(TreeNode root) {
        return maxDepthRecursive(root);
    }

    public static int maxDepthRecursive(TreeNode root) {

        if (root == null) {
            return 0;
        } else {
            int maxL = maxDepthRecursive(root.left);
            int maxR = maxDepthRecursive(root.right);
            return (maxL > maxR ? maxL : maxR) + 1;
        }
    }
}
