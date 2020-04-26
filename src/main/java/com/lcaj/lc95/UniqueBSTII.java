package com.lcaj.lc95;

import com.lcaj.lc94.BTInOrderTraversal;
import datastructures.basics.TreeNode;
import algorithms.util.TreeMethods;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangdehao on 18/11/27.
 */
public class UniqueBSTII {
    public static void main(String[] args) {
        List<TreeNode> trees = generateTrees(3);
        for (TreeNode treeNode : trees) {
            List<Integer> treePrintInorder = BTInOrderTraversal.inorderTraversal(treeNode);
            List<Integer> treePrintPreorder = BTInOrderTraversal.preorderTraversal(treeNode);
            TreeMethods.preorderTraversalRecursive(treeNode);
            System.out.println(treePrintInorder);
            System.out.println(treePrintPreorder);
            System.out.println("***");
        }
    }

    public static List<TreeNode> generateTrees(int n) {
        // fix root, generate left & right respectively
        if (n == 0) {
            return new ArrayList<>();
        }
        List<TreeNode> trees = generateTreesRange(1, n);

        return trees;
    }

    public static List<TreeNode> generateTreesRange(int l, int r) {
        List<TreeNode> treeNodes = new ArrayList<>();
        // very easy to get bug
        if (l > r) {
            treeNodes.add(null);
//        }
//        if (l == r) {
//            treeNodes.add(new TreeNode(l));
//        } else if (l == r - 1) {
//            TreeNode headL = new TreeNode(l);
//            headL.right = new TreeNode(r);
//            treeNodes.add(headL);
//            TreeNode headR = new TreeNode(r);
//            headL.left = new TreeNode(l);
//            treeNodes.add(headR);
        } else {
            for (int i = l; i <= r; i++) {
                // i as root
                List<TreeNode> leftList = generateTreesRange(l, i - 1);
                List<TreeNode> rightList = generateTreesRange(i + 1, r);
                for (TreeNode left : leftList) {
                    for (TreeNode right : rightList) {
                        TreeNode root = new TreeNode(i);
                        root.left = left;
                        root.right = right;
                        treeNodes.add(root);
                    }
                }
            }
        }

        return treeNodes;
    }
}
