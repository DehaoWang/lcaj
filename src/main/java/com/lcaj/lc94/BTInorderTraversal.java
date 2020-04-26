package com.lcaj.lc94;

import datastructures.basics.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by wangdehao on 18/11/26.
 */
public class BTInOrderTraversal {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> result = preorderTraversal(root);
        System.out.println(result);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        inorderTraversalRecursive(root, result);
//        inorderTraversalIterative(root, result);

        return result;
    }

    private static void inorderTraversalIterative(TreeNode root, List<Integer> result) {
        Stack<TreeNode> stack = new Stack();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }
    }

    private static void inorderTraversalRecursive(TreeNode root, List<Integer> result) {
        if (root != null) {
            inorderTraversalRecursive(root.left, result);
            result.add(root.val);
            inorderTraversalRecursive(root.right, result);
        } else {
            result.add(0);
//            return;
        }
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        preorderTraversalRecursive(root, result);

        return result;
    }

    private static void preorderTraversalRecursive(TreeNode root, List<Integer> result) {
        if (root != null) {
            result.add(root.val);
            preorderTraversalRecursive(root.left, result);
            preorderTraversalRecursive(root.right, result);
        } else {
//            result.add(0);
        }
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        postorderTraversalRecursive(root, result);

        return result;
    }

    private static void postorderTraversalRecursive(TreeNode root, List<Integer> result) {
        if (root != null) {
            postorderTraversalRecursive(root.left, result);
            postorderTraversalRecursive(root.right, result);
            result.add(root.val);
        } else {
//            result.add(0);
        }
    }
}
