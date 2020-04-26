package com.lcaj.lc101;

import datastructures.basics.tree.TreeNode;

/**
 * Created by wangdehao on 18/11/27.
 */
public class SymmetricTree {
    public static void main(String[] args) {

    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return isSymmetricTrees(root.left, root.right);
        }

    }

    private static boolean isSymmetricTrees(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left != null && right == null) {
            return false;
        } else if (left == null && right != null) {
            return false;
        } else if (left.val != right.val) {
            return false;
        } else {
            return isSymmetricTrees(left.left, right.right) && isSymmetricTrees(left.right, right.left);
        }
    }
}
