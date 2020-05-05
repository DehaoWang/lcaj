package com.lcaj.lc111;

import datastructures.basic.tree.TreeNode;

/**
 * Created by wangdehao on 18/12/3.
 */
public class MinDepthOfBT {
    public static void main(String[] args) {
        TreeNode root3 = new TreeNode(3);
        root3.left = new TreeNode(9);
        root3.right = new TreeNode(20);
        root3.right.left = new TreeNode(15);
        root3.right.right = new TreeNode(7);
        System.out.println(minDepth(root3));

        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(2);
        System.out.println(minDepth(root4));
    }

    public static int minDepth(TreeNode root) {
        return minDepthRecursive(root);
    }

    public static int minDepthRecursive(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        } else {
            int minL = minDepthRecursive(root.left);
            int minR = minDepthRecursive(root.right);
            if(root.left == null){
                return minR + 1;
            }
            else if(root.right == null){
                return minL + 1;
            }
            return (minL > minR ? minR : minL) + 1;
        }
    }

}
