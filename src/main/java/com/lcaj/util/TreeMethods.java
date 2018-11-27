package com.lcaj.util;

import com.lcaj.model.TreeNode;

/**
 * Created by wangdehao on 18/11/27.
 */
public class TreeMethods {

    public static void inorderTraversalRecursive(TreeNode root) {
        if (root != null) {
            preorderTraversalRecursive(root.left);
            System.out.println(root.val);
            preorderTraversalRecursive(root.right);
        } else {
            System.out.println("n");
        }
    }

    public static void preorderTraversalRecursive(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            preorderTraversalRecursive(root.left);
            preorderTraversalRecursive(root.right);
        } else {
            System.out.println("n");
        }
    }

    public static void postorderTraversalRecursive(TreeNode root) {
        if (root != null) {
            preorderTraversalRecursive(root.left);
            preorderTraversalRecursive(root.right);
            System.out.println(root.val);
        } else {
            System.out.println("n");
        }
    }
}
