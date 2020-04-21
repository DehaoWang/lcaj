package types.dfs;

import com.lcaj.model.TreeNode;

import java.util.*;

public class BTDFS {
    public static void main(String[] args) {
        TreeNode root6 = new TreeNode(4);
        root6.left = new TreeNode(2);
        root6.right = new TreeNode(6);
        root6.left.left = new TreeNode(1);
        root6.left.right = new TreeNode(3);
        root6.right.left = new TreeNode(5);
        root6.right.right = new TreeNode(7);

        System.out.println(binaryTreeDFS(root6));
    }

    public static List<Integer> binaryTreeDFS(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        // template
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = stack.pop();

                // ordinary
//                res.add(curr.val);
                // reversed
                res.add(0, curr.val);

                if (curr.right != null) {
                    stack.push(curr.right);
                }
                if (curr.left != null) {
                    stack.push(curr.left);
                }
            }
        }
        return res;
    }
}
