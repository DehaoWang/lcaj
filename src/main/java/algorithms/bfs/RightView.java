package algorithms.bfs;

import datastructures.basics.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightView {
    public static void main(String[] args) {
        TreeNode root6 = new TreeNode(4);
        root6.left = new TreeNode(2);
        root6.right = new TreeNode(6);
        root6.left.left = new TreeNode(1);
//        root6.left.right = new TreeNode(3);
//        root6.right.left = new TreeNode(5);
//        root6.right.right = new TreeNode(7);
        System.out.println(getRightView(root6));
    }

    public static List<Integer> getRightView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() > 0) {
            boolean visited = false;
            // failed in kuaishou interview
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (!visited) {
                    res.add(curr.val);
                    visited = true;
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
            }
        }
        return res;
    }
}
