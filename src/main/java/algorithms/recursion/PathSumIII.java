package algorithms.recursion;

import datastructures.basics.tree.TreeNode;
import algorithms.util.TreeMethods;

public class PathSumIII {
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
        TreeMethods.inorderTraversal(root);
        System.out.println(countPathSum(root, 8));

        // following up: zigzag path?
    }

    public static int countPathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return countPassing(root, sum) + countPathSum(root.left, sum) + countPathSum(root.right, sum);
    }

    public static int countPassing(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        int count = 0;
        if (node.val == sum) {
            count++;
        }
        return count + countPassing(node.left, sum - node.val) + countPassing(node.right, sum - node.val);
    }
}
