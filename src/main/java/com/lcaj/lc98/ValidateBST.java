package com.lcaj.lc98;

import datastructures.basic.tree.TreeNode;

/**
 * Created by wangdehao on 18/11/27.
 */
public class ValidateBST {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);
        System.out.println(isValidBST(root1));


        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(6);
        System.out.println(isValidBST(root2));

        TreeNode root3 = new TreeNode(10);
        root3.left = new TreeNode(5);
        root3.right = new TreeNode(15);
        root3.right.left = new TreeNode(6);
        root3.right.right = new TreeNode(20);
        System.out.println(isValidBST(root3));


    }

    public static boolean isValidBST(TreeNode root) {
//        return isValidBSTHeap(root);
        return isValidBSTMinMax(root);
    }

    public static boolean isValidBSTMinMax(TreeNode root) {
        return isValidBSTMinMaxRecursion(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isValidBSTMinMaxRecursion(TreeNode root, int minValue, int maxValue) {
        if (root == null) {
            return true;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (root.val < minValue || !isValidBSTMinMaxRecursion(left, minValue, root.val)) {
            return false;
        }
        if (root.val > maxValue || !isValidBSTMinMaxRecursion(right, root.val, maxValue)) {
            return false;
        }

        return true;
    }

    // incorrect solution: should check min or max instead of left or right! TURN OUT TO BE HEAP
    public static boolean isValidBSTHeap(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left != null) {
            if (left.val > root.val || !isValidBST(left)) {
                return false;
            }
        }
        if (right != null) {
            if (right.val < root.val || !isValidBST(right)) {
                return false;
            }
        }
        return true;
    }
}
