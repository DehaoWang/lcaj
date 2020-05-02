package algorithms.utils;

import datastructures.basics.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by wangdehao on 18/11/27.
 */
public class TreeUtils {

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

    public static void bfsTraversal(TreeNode root) {
        System.out.println("bfs: ");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode tn = queue.poll();
            if (tn != null) {
                System.out.print(tn.val + DELIMETER);
                queue.add(tn.left);
                queue.add(tn.right);
            } else {
                System.out.print(NULL_NODE + DELIMETER);
            }
        }
        System.out.println();
    }

    public static void dfsTraversal(TreeNode root) {
        System.out.println("dfs: ");
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode tn = stack.pop();
            if (tn != null) {
                System.out.print(tn.val + DELIMETER);
                stack.add(tn.right);
                stack.add(tn.left);
            } else {
                System.out.print(NULL_NODE + DELIMETER);
            }
        }
        System.out.println();
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

    public static void morrisPreOrderTraversal(TreeNode root) {
        System.out.println("morris pre order: ");
        if (root == null) {
            return;
        }
        TreeNode curr = root;
        TreeNode neighbor = null;
        while (curr != null) {
            if (curr.left != null) {
                // neighbor search
                neighbor = curr.left;
                while (neighbor.right != null && neighbor.right != curr) {
                    neighbor = neighbor.right;
                }
                // neighbor address
                if (neighbor.right == null) {
                    neighbor.right = curr;
                    System.out.print(curr.val + DELIMETER);
                    curr = curr.left;
                    // CORE
                    continue;
                } else {
                    neighbor.right = null;
//                    System.out.print(curr.val + DELIMETER);
                }
            } else {
                System.out.print(curr.val + DELIMETER);
            }
            curr = curr.right;
        }
        System.out.println();
    }

    public static void morrisInOrderTraversal(TreeNode root) {
        System.out.println("morris in order: ");
        if (root == null) {
            return;
        }
        TreeNode curr = root;
        TreeNode neighbor = null;
        while (curr != null) {
            if (curr.left != null) {
                // neighbor search
                neighbor = curr.left;
                while (neighbor.right != null && neighbor.right != curr) {
                    neighbor = neighbor.right;
                }
                // neighbor address
                if (neighbor.right == null) {
                    neighbor.right = curr;
                    curr = curr.left;
                    // CORE
                    continue;
                } else {
                    neighbor.right = null;
                }
            }
            System.out.print(curr.val + DELIMETER);
            curr = curr.right;
        }
        System.out.println();
    }
}
