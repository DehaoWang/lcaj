package types.dfs;

import com.lcaj.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BTDFS {
    public static void main(String[] args) {
        TreeNode root6 = new TreeNode(4);
        root6.left = new TreeNode(2);
        root6.right = new TreeNode(6);
        root6.left.left = new TreeNode(1);
        root6.left.right = new TreeNode(3);
        root6.right.left = new TreeNode(5);
        root6.right.right = new TreeNode(7);

        binaryTreeDFS(root6);
    }

    public static void binaryTreeDFS(TreeNode root) {
        // template
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = stack.pop();
                System.out.println(curr.val);
                if (curr.right != null) {
                    stack.push(curr.right);
                }
                if (curr.left != null) {
                    stack.push(curr.left);
                }
            }
        }
    }
}
