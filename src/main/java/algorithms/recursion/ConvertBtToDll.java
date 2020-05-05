package algorithms.recursion;

import datastructures.basic.linkedlist.DLLNode;
import datastructures.basic.linkedlist.DoublyLinkedList;
import datastructures.basic.tree.TreeDllNode;

import java.util.Stack;

public class ConvertBtToDll {
    public static void main(String[] args) {
        TreeDllNode root = new TreeDllNode(4);
        root.left = new TreeDllNode(2);
        root.right = new TreeDllNode(6);
        root.left.left = new TreeDllNode(1);
        root.left.right = new TreeDllNode(3);
        root.right.left = new TreeDllNode(5);
        root.right.right = new TreeDllNode(7);
//        TreeMethods.inorderTraversal(root);

        DoublyLinkedList doublyLinkedList = convertBtToDll(root);
        // TODO: 2020-05-02 implementation 
        doublyLinkedList.printTD();
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
}
