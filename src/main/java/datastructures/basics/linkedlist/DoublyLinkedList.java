package datastructures.basics.linkedlist;


public class DoublyLinkedList {
    public static DLLNode head;
    public static DLLNode tail;

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

    public static void print() {
        DLLNode.printListNode(head);
        DLLNode.printListNodeRev(tail);
    }
}
