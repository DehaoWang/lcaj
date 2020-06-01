package algorithms.recursion;

import datastructures.basic.linkedlist.DLLNode;
import datastructures.basic.linkedlist.DoublyLinkedList;
import datastructures.basic.tree.TreeDllNode;
import datastructures.basic.tree.TreeNode;

import java.util.Stack;

public class ConvertBtToDll {
    public static void main(String[] args) {
//        TreeDllNode root = new TreeDllNode(4);
//        root.left = new TreeDllNode(2);
//        root.right = new TreeDllNode(6);
//        root.left.left = new TreeDllNode(1);
//        root.left.right = new TreeDllNode(3);
//        root.right.left = new TreeDllNode(5);
//        root.right.right = new TreeDllNode(7);
////        TreeMethods.inorderTraversal(root);
//
//        DoublyLinkedList doublyLinkedList = convertBtToDll(root);
//        // TODO: 2020-05-02 implementation
//        doublyLinkedList.printTD();


        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(6);
        root2.left.left = new TreeNode(1);
        root2.left.right = new TreeNode(3);
        root2.right.left = new TreeNode(5);
        root2.right.right = new TreeNode(7);

        TreeNode[] dll = getHeadOfDllFromBT(root2);
        TreeNode head = dll[0];
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.right;
        }
        System.out.println();

        TreeNode tail = dll[1];
        while (tail != null) {
            System.out.print(tail.val + " -> ");
            tail = tail.left;
        }

        System.out.println();

        TreeNode root3 = new TreeNode(4);
        root3.left = new TreeNode(2);
        root3.right = new TreeNode(6);
        root3.left.left = new TreeNode(1);
        root3.left.right = new TreeNode(3);
        root3.right.left = new TreeNode(5);
        root3.right.right = new TreeNode(7);

        transformBtToDll2(root3);

        while (first != null) {
            System.out.print(first.val + " -> ");
            first = first.right;
        }
        System.out.println();


        while (last != null) {
            System.out.print(last.val + " -> ");
            last = last.left;
        }
        System.out.println();

    }

    public static DoublyLinkedList convertBtToDll(TreeDllNode root) {
//        DoublyLinkedList doublyLinkedList = getDllRec(root);
        DoublyLinkedList doublyLinkedList = getDllInorderStack(root);

        return doublyLinkedList;
    }

    public static DoublyLinkedList getDllRec(TreeDllNode curr) {
        if (curr == null) {
            return null;
        }
        DLLNode dllNode = new DLLNode(curr.val);
        DoublyLinkedList left = getDllRec(curr.left);
        DoublyLinkedList right = getDllRec(curr.right);
        left.tail.next = dllNode;
        dllNode.prev = left.tail;
        right.head.prev = dllNode;
        dllNode.next = right.head;

        return left;
    }

    public static DoublyLinkedList getDllInorderStack(TreeDllNode curr) {
        if (curr == null) {
            return null;
        }
        TreeDllNode dummy = new TreeDllNode(-1);
        boolean first = true;
        TreeDllNode pred = dummy;
        Stack<TreeDllNode> stack = new Stack<>();
        while (!stack.isEmpty() || curr != null) {

            if (curr != null) {
                pred = curr;
                stack.push(curr);
                curr = curr.left;

            } else {
                curr = stack.pop();
                System.out.println(curr.val);

//                dummy.next = curr;
//                curr.prev = dummy;
                if (pred != null && pred != curr) {
                    pred.next = curr;
                    curr.prev = pred;
                }
                if (first && pred != null) {
                    dummy.next = pred;
                    pred.prev = dummy;
                    first = false;
                }
                curr = curr.right;
            }


        }
        return new DoublyLinkedList(dummy.next);
    }

    public static TreeNode[] getHeadOfDllFromBT(TreeNode root) {
        if (root == null) {
            return null;
        }
        return transformBtToDll(root);
    }

    public static TreeNode[] transformBtToDll(TreeNode curr) {
        //
        TreeNode[] ans = new TreeNode[2];
        ans[0] = curr;
        ans[1] = curr;
        if (curr.left != null) {
            TreeNode[] leftDll = transformBtToDll(curr.left);
            curr.left = leftDll[1];
            leftDll[1].right = curr;
            ans[0] = leftDll[0];
        }
        if (curr.right != null) {
            TreeNode[] rightDll = transformBtToDll(curr.right);
            curr.right = rightDll[0];
            rightDll[0].left = curr;
            ans[1] = rightDll[1];
        }
        return ans;
    }

    private static TreeNode first = null;
    private static TreeNode last = null;

    public static void transformBtToDll2(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root);
    }

    public static void helper(TreeNode curr) {
        if (curr == null) {
            return;
        }
        helper(curr.left);
        if (last == null) {
            first = curr;
        } else {
            last.right = curr;
            curr.left = last;
        }
        last = curr;
        helper(curr.right);
    }
}
