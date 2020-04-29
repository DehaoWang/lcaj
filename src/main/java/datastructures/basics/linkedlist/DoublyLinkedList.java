package datastructures.basics.linkedlist;


import datastructures.basics.tree.TreeDllNode;

public class DoublyLinkedList {
    public static DLLNode head;
    public static DLLNode tail;

    public static TreeDllNode tdHead;
    public static TreeDllNode tdTail;

    public DoublyLinkedList(int[] a) {
        if (a == null || a.length == 0) {
            return;
        }
        head = new DLLNode(a[0]);
        DLLNode prev = head;
        DLLNode curr = head;
        for (int i = 1; i < a.length; i++) {
            curr.next = new DLLNode(a[i]);
            curr = curr.next;
            curr.prev = prev;
            prev = curr;
        }
        tail = curr;
    }

    public DoublyLinkedList() {

    }

    public DoublyLinkedList(TreeDllNode head) {
        this.tdHead = head;
    }

    public static void print() {
        DLLNode.printListNode(head);
        DLLNode.printListNodeRev(tail);
    }

    public static void printTD() {
        TreeDllNode.printListNode(tdHead);
        TreeDllNode.printListNodeRev(tdTail);
    }
}
