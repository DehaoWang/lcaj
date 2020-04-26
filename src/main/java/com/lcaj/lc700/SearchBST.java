package com.lcaj.lc700;

import datastructures.basics.TreeNode;

public class SearchBST {
    public static void main(String[] args) {

    }

    public TreeNode searchBstRecursive(TreeNode root, int val) {
        if (root == null) {
            return null;
        } else {
            if (root.val == val) {
                return root;
            } else if (root.val > val) {
                return searchBstRecursive(root.left, val);
            } else {
                return searchBstRecursive(root.right, val);
            }
        }
    }

    public TreeNode searchBstIterative(TreeNode root, int val) {
        if (root == null) {
            return null;
        } else {
            while (root != null) {
                if (root.val == val) {
                    return root;
                } else if (root.val > val) {
                    root = root.left;
                } else {
                    root = root.right;
                }
            }
        }
        return null;
    }
}
