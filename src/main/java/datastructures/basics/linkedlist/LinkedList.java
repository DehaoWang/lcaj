package datastructures.basics.linkedlist;

public class LinkedList {
    public static ListNode head;

    public LinkedList(int[] a){
        head = ListNode.getListFromArray(a);
    }

    public static void print() {
        ListNode.printListNode(head);
    }
}
