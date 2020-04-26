package com.lcaj.lc250;

import datastructures.basics.tree.TreeNode;

/**
 * Created by wangdehao on 19/5/13.
 */
public class CountUnivalueSubtrees {
    public static void main(String[] args) {
        TreeNode root3 = new TreeNode(5);
        root3.left = new TreeNode(1);
        root3.right = new TreeNode(5);

        root3.left.left = new TreeNode(5);
        root3.right.right = new TreeNode(5);
        root3.left.right = new TreeNode(5);

        System.out.println(isUnivalTreeRecursive(root3.left.left));
        System.out.println(isUnivalTreeRecursive(root3.left.right));
        System.out.println(isUnivalTreeRecursive(root3.right.right));
        System.out.println(isUnivalTreeRecursive(root3.right));
        System.out.println(isUnivalTreeRecursive(root3.left));
        System.out.println(isUnivalTreeRecursive(root3));

        System.out.println(countUnivalSubtrees(root3));

    }

    private static int cntVariable;

    public static int countUnivalSubtrees(TreeNode root) {
        // recursive approach
        countUnivalSubtreesRecursive(root);
        return cntVariable;
    }

    private static void countUnivalSubtreesRecursive(TreeNode curr) {
        if (curr == null) {
            return;
        }
        if (isUnivalTreeRecursive(curr)) {
            cntVariable++;
        }
        countUnivalSubtreesRecursive(curr.left);
        countUnivalSubtreesRecursive(curr.right);
    }

    private static boolean isUnivalTreeRecursive(TreeNode curr) {
        if (curr == null) {
            return false;
        } else if (curr.left == null && curr.right == null) {
            return true;
        } else if (curr.left == null && curr.right != null && curr.val == curr.right.val) {
            return true;
        } else if (curr.right == null && curr.left != null && curr.val == curr.left.val) {
            return true;
        } else if (isUnivalTreeRecursive(curr.left) && isUnivalTreeRecursive(curr.right)
                && curr.left != null && curr.right != null
                && curr.val == curr.left.val && curr.val == curr.right.val) {
            return true;
        } else {
            return false;
        }
    }
}
