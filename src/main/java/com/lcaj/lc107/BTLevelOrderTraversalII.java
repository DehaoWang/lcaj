package com.lcaj.lc107;

import datastructures.basic.tree.TreeNode;
import algorithms.utils.TreeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by wangdehao on 18/11/30.
 */
public class BTLevelOrderTraversalII {
    public static void main(String[] args) {
        TreeNode root3 = new TreeNode(3);
        root3.left = new TreeNode(9);
        root3.right = new TreeNode(20);

        root3.right.left = new TreeNode(15);
        root3.right.right = new TreeNode(7);
        root3.left.left = new TreeNode(2);
        root3.left.right = new TreeNode(1);
        System.out.println(levelOrderBottom(root3));
        TreeUtils.bfsTraversal(root3);
        TreeUtils.dfsTraversal(root3);
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelNodes = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();
                levelNodes.add(curr.val);
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            result.add(0, levelNodes);
        }
        return result;
    }
}
