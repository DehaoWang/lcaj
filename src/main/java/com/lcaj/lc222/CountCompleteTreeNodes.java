package com.lcaj.lc222;

import algorithms.recursion.NodeCounting;
import algorithms.utils.TreeUtils;
import datastructures.basics.tree.TreeNode;

public class CountCompleteTreeNodes {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        TreeUtils.bfsTraversal(root);

        System.out.println(NodeCounting.countNodesForCompleteBT(root));
    }
}
