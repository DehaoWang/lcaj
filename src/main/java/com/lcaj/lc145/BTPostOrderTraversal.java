package com.lcaj.lc145;

import com.lcaj.lc94.BTInOrderTraversal;
import datastructures.basic.tree.TreeNode;
import algorithms.utils.TreeUtils;

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
        TreeUtils.postorderTraversal(root);
        List<Integer> result = BTInOrderTraversal.postorderTraversal(root);
//        List<Integer> result = preorderTraversalIterative(root);
        System.out.println(result);
    }
}
