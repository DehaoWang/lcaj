package com.lcaj.lc144;

import com.lcaj.lc94.BTInOrderTraversal;
import datastructures.basic.tree.TreeNode;
import algorithms.utils.TreeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by wangdehao on 18/12/10.
 */
public class BTPreOrderTraversal {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(6);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);
        TreeUtils.preorderTraversal(root);
//        List<Integer> result = BTInOrderTraversal.preorderTraversal(root);
        List<Integer> result = BTInOrderTraversal.postorderTraversal(root);

//        List<Integer> result = postorderTraversalIterative(root);
        System.out.println(result);
    }

    public static List<Integer> preorderTraversalIterative(TreeNode root) {
        List<Integer> results = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        stack.push(curr);

        while (!stack.isEmpty()) {

            TreeNode treeNode = stack.pop();
            if(treeNode != null){
                results.add(treeNode.val);
                stack.push(treeNode.right);
                stack.push(treeNode.left);
            }
        }

        return results;
    }
}
