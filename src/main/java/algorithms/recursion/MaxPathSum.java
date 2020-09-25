package algorithms.recursion;

import algorithms.utils.TreeUtils;
import datastructures.basic.tree.TreeNode;

public class MaxPathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        TreeUtils.inorderTraversal(root);
        System.out.println(maxPathSum(root));

        // following up: zigzag path?

        TreeNode root1 = new TreeNode(-3);
        System.out.println(maxPathSum(root1));

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        System.out.println(maxPathSum(root2));

        TreeNode root3 = new TreeNode(2);
        root3.left = new TreeNode(-1);
        System.out.println(maxPathSum(root3));

        System.out.println("*********");
        System.out.println(maxPassing(root.left));
        System.out.println(maxPassing(root.right));
        System.out.println(maxPathSum(root.left));
        System.out.println(maxPathSum(root.right));
    }

    public static int maxPathSum(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        return Math.max(maxPassing(root), Math.max(maxPathSum(root.left), maxPathSum(root.right)));
    }

    public static int maxPassing(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.val + Math.max(maxPassing(node.left), 0) + Math.max(maxPassing(node.right), 0);
    }
}
