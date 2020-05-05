package datastructures.basic.linkedlist;


public class DummyDoublyLinkedList {
    public DLLNode head = new DLLNode(-1);
    public DLLNode tail = new DLLNode(-1);
    int size = 0;


    public DummyDoublyLinkedList(int[] a) {
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

    public DummyDoublyLinkedList() {
        head.next = tail;
        tail.prev = head;
    }

    public void addFirst(DLLNode curr) {
        head.next.prev = curr;
        curr.next = head.next;

        head.next = curr;
        curr.prev = head;
        size++;
    }

    public void removeNode(DLLNode curr) {
        if (curr == null) {
            return;
        }
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        size--;
    }

    public DLLNode removeLast() {
        if (size == 0) {
            return null;
        }
        DLLNode last = tail.prev;
        removeNode(last);
        return last;
    }

    public int size() {
        return size;
    }
}
