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
        plusX(root6, 1);
        TreeUtils.morrisInOrderTraversal(root6);
        plusX(root6, -1);
        TreeUtils.morrisInOrderTraversal(root6);

        TreeNode root7 = new TreeNode(4);
        root7.left = new TreeNode(2);
        root7.right = new TreeNode(6);
        root7.left.left = new TreeNode(1);
        root7.left.right = new TreeNode(3);
        root7.right.left = new TreeNode(5);
        root7.right.right = new TreeNode(8);

        System.out.println(isSameTree(root6, root7));
    }

    public static void plusX(TreeNode root, int x) {
        if (root == null) {
            return;
        }
        root.val += x;
        plusX(root.left, x);
        plusX(root.right, x);
    }

    public static boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    }


}
