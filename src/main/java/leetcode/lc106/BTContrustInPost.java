package leetcode.lc106;

import datastructures.basic.tree.TreeNode;
import algorithms.utils.TreeUtils;

/**
 * Created by wangdehao on 18/11/30.
 */
public class BTContrustInPost {
    public static void main(String[] args) {

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode root = buildTree(inorder, postorder);
        TreeUtils.preorderTraversal(root);
        TreeUtils.inorderTraversal(root);
        TreeUtils.postorderTraversal(root);
        System.out.println(root.val);
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        // Recursive
        return buildTreePostInRecursive(postorder, postorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public static TreeNode buildTreePostInRecursive(int[] postorder, int postR, int[] inorder, int inL, int inR) {
        if (postR < 0 || inL > inR) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postR]);
        int inIdx = 0;
        for (int i = inL; i <= inR; i++) {
            if (inorder[i] == postorder[postR]) {
                inIdx = i;
            }
        }

        root.right = buildTreePostInRecursive(postorder, postR - 1, inorder, inIdx + 1, inR);
        root.left = buildTreePostInRecursive(postorder, postR + inIdx - inR - 1, inorder, inL, inIdx - 1);

        return root;
    }
}
