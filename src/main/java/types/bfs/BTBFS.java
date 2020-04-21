package types.bfs;

import com.lcaj.model.TreeNode;

import java.util.LinkedList;
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

        binaryTreeBFS(root6);
    }

    public static void binaryTreeBFS(TreeNode root) {
        // template
        if (root == null) {
            return;
        }
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                System.out.println(curr.val);
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            depth++;
        }
        System.out.println("depth = " + depth);
    }
}
