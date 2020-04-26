package com.lcaj.lc108;

import datastructures.basics.TreeNode;
import com.lcaj.util.TreeMethods;

/**
 * Created by wangdehao on 18/12/3.
 */
public class ConvertArrayToBST {
    public static void main(String[] args) {

//        int[] nums = {-10, -3, 0, 5, 9};
        int[] nums = {0};
        TreeNode root = sortedArrayToBST(nums);
        TreeMethods.inorderTraversal(root);
        TreeMethods.preorderTraversal(root);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return null;
        } else {
            return sortedArrayToBSTRecursive(nums, 0, len - 1);
        }
    }

    public static TreeNode sortedArrayToBSTRecursive(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        } else if (l == r) {
            return new TreeNode(nums[l]);
        } else if (l == r - 1) {
            // p = l
            TreeNode root = new TreeNode(nums[l]);
            root.right = new TreeNode(nums[r]);
            return root;
        }
        int p = (l + r) / 2;
        TreeNode root = new TreeNode(nums[p]);
        root.left = sortedArrayToBSTRecursive(nums, l, p - 1);
        root.right = sortedArrayToBSTRecursive(nums, p + 1, r);
        return root;
    }
}
