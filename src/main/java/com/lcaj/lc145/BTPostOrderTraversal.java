package com.lcaj.lc145;

import com.lcaj.lc94.BTInOrderTraversal;
import datastructures.basics.tree.TreeNode;
import algorithms.util.TreeMethods;

import java.util.List;

/**
 * Created by wangdehao on 18/12/11.
 */
public class BTPostOrderTraversal {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(6);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);
        TreeMethods.postorderTraversal(root);
        List<Integer> result = BTInOrderTraversal.postorderTraversal(root);
//        List<Integer> result = preorderTraversalIterative(root);
        System.out.println(result);
    }
}
