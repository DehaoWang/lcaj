package algorithms.recursion;

import algorithms.utils.TreeUtils;
import datastructures.basics.tree.TreeNode;

public class NodeCounting {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        TreeUtils.bfsTraversal(root);

        System.out.println(countNodesForPerfectBT(null));
        System.out.println(countNodesForPerfectBT(new TreeNode(0)));
        System.out.println(countNodesForPerfectBT(root));

        System.out.println(countNodesForSimpleBT(root));

        System.out.println(countNodesForCompleteBT(root));
    }

    public static int countNodesForCompleteBT(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode l = root;
        TreeNode r = root;
        int hl = 0;
        int hr = 0;
        while (l != null) {
            l = l.left;
            hl++;
        }
        while (r != null) {
            r = r.right;
            hr++;
        }
        if (hl == hr) {
            return (int) Math.pow(2, hl) - 1;
        } else {
            return 1 + countNodesForCompleteBT(root.left) + countNodesForCompleteBT(root.right);
        }
    }

    public static int countNodesForPerfectBT(TreeNode root) {
        int h = 0;
        while (root != null) {
            root = root.left;
            h++;
        }
        return (int) Math.pow(2, h) - 1;
    }

    public static int countNodesForSimpleBT(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodesForSimpleBT(root.left) + countNodesForSimpleBT(root.right);
    }
}
