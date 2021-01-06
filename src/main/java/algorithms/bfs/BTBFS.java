package algorithms.bfs;

import datastructures.basic.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTBFS {
    public static void main(String[] args) {
        TreeNode root6 = new TreeNode(4);
        root6.left = new TreeNode(2);
        root6.right = new TreeNode(6);
        root6.left.left = new TreeNode(1);
        root6.left.right = new TreeNode(3);
        root6.right.left = new TreeNode(5);
        root6.right.right = new TreeNode(7);

        System.out.println(binaryTreeBFS(root6));
    }

    public static List<List<Integer>> binaryTreeBFS(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        // template
        if (root == null) {
            return res;
        }
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                // reversed
//                level.add(0, curr.val);
                level.add(curr.val);
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            // ordinary
            res.add(level);
            // reversed
//            res.add(0, level);
            depth++;
        }
        System.out.println("depth = " + depth);
        return res;
    }
}
