package interview;

import datastructures.basics.tree.TreeNode;
import algorithms.utils.TreeUtils;

import java.util.ArrayList;
import java.util.List;

public class Coding {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.right = new TreeNode(1);
        root.right.right = new TreeNode(2);
        root.right.right.right = new TreeNode(3);
        root.right.right.right.right = new TreeNode(4);
        TreeUtils.inorderTraversal(root);
        TreeUtils.preorderTraversal(root);

        TreeNode balancedRoot = getBalancedBST(root);
        TreeUtils.inorderTraversal(balancedRoot);
        TreeUtils.preorderTraversal(balancedRoot);
    }

    public static TreeNode getBalancedBST(TreeNode root) {
        if (root == null) {
            return null;
        }

        // can be refined ***
        List<Integer> list = new ArrayList<Integer>();
        getSortedNumsBSTinorder(root, list);

        int[] nums = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }

        int l = 0;
        int r = nums.length - 1;

        // TreeNode[]
        return contrustBST(nums, l, r);
    }

    public static TreeNode contrustBST(int[] nums, int l, int r) {
        // base case
        if (l > r) {
            return null;
        } else if (l == r) {
            return new TreeNode(nums[l]);
        }

        int m = l + (r - l) / 2;
        // nums[m] => list.get(m);
        TreeNode curr = new TreeNode(nums[m]);
        curr.left = contrustBST(nums, l, m - 1);
        curr.right = contrustBST(nums, m + 1, r);
        return curr;
    }

    public static void getSortedNumsBSTinorder(TreeNode curr, List<Integer> list) {
        // base case
        if (curr == null) {
            return;
        }
        // inorder traversal
        getSortedNumsBSTinorder(curr.left, list);
        list.add(curr.val);
        getSortedNumsBSTinorder(curr.right, list);
    }
}
