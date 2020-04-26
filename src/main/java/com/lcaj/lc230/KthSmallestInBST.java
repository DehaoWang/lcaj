package com.lcaj.lc230;

import datastructures.basics.tree.TreeNode;

/**
 * Created by wangdehao on 19/4/17.
 */
public class KthSmallestInBST {
    static int count = 0;

    public static void main(String[] args) {

    }

    public int kthSmallest(TreeNode root, int k) {

        return inorderTraversalRecursive(root, k);
    }

    public static int inorderTraversalRecursive(TreeNode curr, int k) {
        if (curr != null) {
            inorderTraversalRecursive(curr.left, k);
            if (count == k) {
                return curr.val;
            }
            inorderTraversalRecursive(curr.right, k);
            k++;
        }
        return 0;
    }
}
