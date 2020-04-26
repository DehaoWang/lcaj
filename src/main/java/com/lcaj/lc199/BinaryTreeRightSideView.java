package com.lcaj.lc199;

import datastructures.basics.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by wangdehao on 19/4/12.
 */
public class BinaryTreeRightSideView {
    public static void main(String[] args) {

        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.right = new TreeNode(3);
        root3.left.right = new TreeNode(5);
        root3.right.right = new TreeNode(4);
        System.out.println(rightSideView(root3));
        System.out.println(rightSideViewBfs(root3));

        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(2);
        root4.right = new TreeNode(3);
        root4.left.left = new TreeNode(4);
        System.out.println(rightSideView(root4));
        System.out.println(rightSideViewBfs(root4));
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
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
                levelNodes.add(0, curr.val);
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }

            result.add(levelNodes.get(0));
        }
        return result;
    }

    public static List<Integer> rightSideViewBfs(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightSideViewBfsRec(result, root);
        return result;
    }

    private static void rightSideViewBfsRec(List<Integer> result, TreeNode curr) {
        if (curr != null) {
            result.add(curr.val);
        }
        if(curr.left != null){
            rightSideViewBfsRec(result, curr.left);
        }
        if(curr.right != null){
            rightSideViewBfsRec(result, curr.right);
        }
    }
}
