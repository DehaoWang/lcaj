package algorithms.recursion;

import algorithms.utils.TreeUtils;
import datastructures.basics.tree.TreeNode;

public class BstOperations {
    public static void main(String[] args) {
        TreeNode root6 = new TreeNode(4);
        root6.left = new TreeNode(2);
        root6.right = new TreeNode(6);
        root6.left.left = new TreeNode(1);
        root6.left.right = new TreeNode(3);
        root6.right.left = new TreeNode(5);
        root6.right.right = new TreeNode(7);

        TreeUtils.morrisInOrderTraversal(root6);
    }

    public void plusOne(TreeNode root) {

    }
}
