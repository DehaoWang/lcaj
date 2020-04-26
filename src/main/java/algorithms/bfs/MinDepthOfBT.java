package algorithms.bfs;

import datastructures.basics.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

import static com.lcaj.lc111.MinDepthOfBT.minDepth;

public class MinDepthOfBT {
    public static void main(String[] args) {
//        TreeNode root3 = new TreeNode(3);
//        root3.left = new TreeNode(9);
//        root3.right = new TreeNode(20);
//        root3.right.left = new TreeNode(15);
//        root3.right.right = new TreeNode(7);
//        System.out.println(minDepth(root3));
//        System.out.println(minDepthBFS(root3));
//
//
//        TreeNode root4 = new TreeNode(1);
//        root4.left = new TreeNode(2);
//        System.out.println(minDepth(root4));
//        System.out.println(minDepthBFS(root4));
//
//
//        TreeNode root5 = new TreeNode(2);
//        root5.left = new TreeNode(1);
//        root5.right = new TreeNode(3);
//        root5.right.left = new TreeNode(4);
//        root5.right.right = new TreeNode(5);
//
//        System.out.println(minDepth(root5));
//        System.out.println(minDepthBFS(root5));

        TreeNode root6 = new TreeNode(3);
        root6.left = new TreeNode(2);
        root6.right = new TreeNode(4);
        root6.left.left = new TreeNode(1);
        root6.right.right = new TreeNode(5);

        System.out.println(minDepth(root6));
        System.out.println(minDepthBFS(root6));
    }

    public static int minDepthBFS(TreeNode root) {
        // template
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 1;
        queue.add(root);
        while (!queue.isEmpty()) {
            // important
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.left == null && curr.right == null) {
                    return depth;
                }
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
