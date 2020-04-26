package com.lcaj.lc102;

import datastructures.basics.TreeNode;
import com.lcaj.util.TreeMethods;

import java.util.*;

/**
 * Created by wangdehao on 18/11/27.
 */
public class BTLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root3 = new TreeNode(3);
        root3.left = new TreeNode(9);
        root3.right = new TreeNode(20);

        root3.right.left = new TreeNode(15);
        root3.right.right = new TreeNode(7);
        root3.left.left = new TreeNode(2);
        root3.left.right = new TreeNode(1);
        System.out.println(levelOrder(root3));
        TreeMethods.traversalBFS(root3);
        TreeMethods.traversalDFS(root3);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {

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
            result.add(levelNodes);
        }
        return result;
    }

    public static void levelOrderRecursiveWrong(TreeNode root, List<List<Integer>> result) {
        if (root == null) {
            return;
        } else {
            List<Integer> level = new ArrayList<>();
            if (root.left != null) {
                level.add(root.left.val);
            }
            if (root.right != null) {
                level.add(root.right.val);
            }
            if (!level.isEmpty()) {
                result.add(level);
            }
            levelOrderRecursiveWrong(root.left, result);
            levelOrderRecursiveWrong(root.right, result);
        }
    }
}
