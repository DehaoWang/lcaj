package com.lcaj.lc226;

import datastructures.basics.TreeNode;
import com.lcaj.util.TreeMethods;

/**
 * Created by wangdehao on 19/4/17.
 */
public class InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode root3 = new TreeNode(3);
        root3.left = new TreeNode(9);
        root3.right = new TreeNode(20);

        root3.right.left = new TreeNode(15);
        root3.right.right = new TreeNode(7);
        root3.left.left = new TreeNode(2);
        root3.left.right = new TreeNode(1);
        TreeMethods.inorderTraversal(root3);

        TreeNode root4 = invertTree(root3);
        TreeMethods.inorderTraversal(root4);
    }

    public static TreeNode invertTree(TreeNode root) {

        invertTreeRecursive(root);

        return root;
    }

    public static void invertTreeRecursive(TreeNode curr) {
        if (curr == null) {
            return;
        }
        TreeNode temp = curr.left;
        curr.left = curr.right;
        curr.right = temp;

        invertTreeRecursive(curr.left);
        invertTreeRecursive(curr.right);
    }

}
