package com.lcaj.lc100;

import datastructures.basics.tree.TreeNode;

/**
 * Created by wangdehao on 18/11/27.
 */
public class SameTree {
    public static void main(String[] args) {

    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null && q != null) {
            return false;
        } else if (p != null && q == null) {
            return false;
        } else {
            return p.val == q.val
                    && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
