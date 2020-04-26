package com.lcaj.lc105;

import datastructures.basics.TreeNode;
import algorithms.util.TreeMethods;

/**
 * Created by wangdehao on 18/11/30.
 */
public class BTConstructInPre {
    public static void main(String[] args) {

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode root = buildTree(preorder, inorder);
        TreeMethods.preorderTraversal(root);
        TreeMethods.inorderTraversal(root);
        TreeMethods.postorderTraversal(root);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        // Recursive
        return buildTreePreInRecursive(preorder, 0, inorder, 0, inorder.length - 1);
    }

    public static TreeNode buildTreePreInRecursive(int[] preorder, int preL, int[] inorder, int inL, int inR) {
        if (preL >= preorder.length || inL > inR) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preL]);
        int inIdx = 0;
        for (int i = inL; i <= inR; i++) {
            if (inorder[i] == preorder[preL]) {
                inIdx = i;
            }
        }

        root.left = buildTreePreInRecursive(preorder, preL + 1, inorder, inL, inIdx - 1);
        root.right = buildTreePreInRecursive(preorder, preL + inIdx - inL + 1, inorder, inIdx + 1, inR);

        return root;
    }

}
