package com.lcaj.util;

import com.lcaj.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by wangdehao on 18/11/27.
 */
public class TreeMethods {

    public static void inorderTraversalRecursive(TreeNode root) {
        if (root != null) {
            preorderTraversalRecursive(root.left);
            System.out.println(root.val);
            preorderTraversalRecursive(root.right);
        } else {
            System.out.println("n");
        }
    }

    public static void preorderTraversalRecursive(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            preorderTraversalRecursive(root.left);
            preorderTraversalRecursive(root.right);
        } else {
            System.out.println("n");
        }
    }

    public static void postorderTraversalRecursive(TreeNode root) {
        if (root != null) {
            preorderTraversalRecursive(root.left);
            preorderTraversalRecursive(root.right);
            System.out.println(root.val);
        } else {
            System.out.println("n");
        }
    }

    public static void traversalBFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode tn = queue.poll();
            if (tn != null) {
                System.out.println(tn.val);
                queue.add(tn.left);
                queue.add(tn.right);
            }
        }
    }

    public static void traversalDFS(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode tn = stack.pop();
            if (tn != null) {
                System.out.println(tn.val);
                stack.add(tn.right);
                stack.add(tn.left);
            }
        }
    }
}
