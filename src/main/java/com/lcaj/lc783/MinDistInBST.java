package com.lcaj.lc783;

import datastructures.basics.tree.TreeNode;

public class MinDistInBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        System.out.println(minDiffInBST(root));
    }

    private static int min = Integer.MAX_VALUE;
    private static Integer prev;

    public static int minDiffInBST(TreeNode root) {
        dfs(root);
        return min;
    }

    public static void dfs(TreeNode curr) {
        if (curr == null) {
            return;
        }
        dfs(curr.left);

        if(prev != null){
            min = Math.min(curr.val - prev, min);
        }

        prev = curr.val;
        dfs(curr.right);
    }
}
