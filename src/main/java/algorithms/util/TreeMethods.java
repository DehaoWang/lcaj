package algorithms.util;

import datastructures.basics.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by wangdehao on 18/11/27.
 */
public class TreeMethods {

    public static final String DELIMETER = " ";
    private static final String NULL_NODE = "x";

    public static void inorderTraversalRecursive(TreeNode root) {
        if (root != null) {
            inorderTraversalRecursive(root.left);
            System.out.print(root.val + DELIMETER);
            inorderTraversalRecursive(root.right);
        } else {
            System.out.print(NULL_NODE + DELIMETER);
        }
    }

    public static void preorderTraversalRecursive(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + DELIMETER);
            preorderTraversalRecursive(root.left);
            preorderTraversalRecursive(root.right);
        } else {
            System.out.print(NULL_NODE + DELIMETER);
        }
    }

    public static void postorderTraversalRecursive(TreeNode root) {
        if (root != null) {
            postorderTraversalRecursive(root.left);
            postorderTraversalRecursive(root.right);
            System.out.print(root.val + DELIMETER);
        } else {
            System.out.print(NULL_NODE + DELIMETER);

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

    public static void preorderTraversal(TreeNode root) {
        System.out.println("pre order: ");
        preorderTraversalRecursive(root);
        System.out.println();
    }

    public static void inorderTraversal(TreeNode root) {
        System.out.println("in order: ");
        inorderTraversalRecursive(root);
        System.out.println();
    }

    public static void postorderTraversal(TreeNode root) {
        System.out.println("post order: ");
        postorderTraversalRecursive(root);
        System.out.println();
    }
}
