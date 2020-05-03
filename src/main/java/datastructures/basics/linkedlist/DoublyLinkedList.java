package datastructures.basics.linkedlist;


import datastructures.basics.tree.TreeDllNode;

public class DoublyLinkedList {
    public static DLLNode head;
    public static DLLNode tail;
    int size = 0;

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

    public void addFirst(DLLNode curr) {
        if (head == null) {
            tail = curr;
        } else {
            curr.next = head;
            head.prev = curr;
        }
        head = curr;
        size++;
    }

    public void remove(DLLNode curr) {
        if (curr == null) {
            return;
        }
        if (curr == head) {
            removeFirst();
        } else if (curr == tail) {
            removeLast();
        } else {
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
            size--;
        }
    }

    public DLLNode removeFirst() {
        if (head == null) {
            return null;
        }
        DLLNode first = head;
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
        size--;
        return first;
    }

    public DLLNode removeLast() {
        if (tail == null) {
            return null;
        }
        DLLNode last = tail;
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        }
        size--;
        return last;
    }

    public int size() {
        return size;
    }
}
