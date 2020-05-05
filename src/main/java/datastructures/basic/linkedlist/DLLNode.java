package datastructures.basic.linkedlist;

public class DLLNode {
    // Definition for doubly-linked list.
    public int key;
    public int val;
    public DLLNode prev;
    public DLLNode next;

    public DLLNode(int x) {
        val = x;
    }

    public DLLNode(int key, int value) {
        this.key = key;
        this.val = value;
    }

    public static DLLNode getListFromArray(int[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        DLLNode first = new DLLNode(a[0]);
        DLLNode prev = first;
        DLLNode curr = first;
        for (int i = 1; i < a.length; i++) {
            curr.next = new DLLNode(a[i]);
            curr = curr.next;
            curr.prev = prev;
            prev = curr;
        }
        return first;
    }

    public static void printListNode(DLLNode l) {
        DLLNode curr = l;
        System.out.println("Printing Node List");
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void printListNodeRev(DLLNode l) {
        DLLNode curr = l;
        System.out.println("Printing Node List");
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.prev;
        }
        System.out.println();
    }
}
