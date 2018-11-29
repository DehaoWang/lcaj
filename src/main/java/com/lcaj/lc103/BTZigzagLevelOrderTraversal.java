package com.lcaj.lc103;

import com.lcaj.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by wangdehao on 18/11/28.
 */
public class BTZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root3 = new TreeNode(3);
        root3.left = new TreeNode(9);
        root3.right = new TreeNode(20);

        root3.right.left = new TreeNode(15);
        root3.right.right = new TreeNode(7);
        root3.left.left = new TreeNode(2);
        root3.left.right = new TreeNode(1);
        System.out.println(zigzagLevelOrder(root3));

        List<Integer> ints = new ArrayList<>();
        System.out.println(ints);
        ints.add(1);
        System.out.println(ints);
        ints.add(0, 2);
        System.out.println(ints);
        ints.add(3);
        System.out.println(ints);
        ints.add(0, 4);
        System.out.println(ints);
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean order = true;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelNodes = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();
                if (order) {
                    levelNodes.add(curr.val);
                } else {
                    // insert into list backwards
                    levelNodes.add(0, curr.val);
                }
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }

            }
            result.add(levelNodes);
            order = !order;
        }
        return result;
    }
}
