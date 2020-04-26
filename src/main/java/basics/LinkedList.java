package basics;

import datastructures.basics.linkedlist.ListNode;

public class LinkedList {
    public static void main(String[] args) {
        ListNode listNode = ListNode.getListFromArray(new int[]{1, 2, 3, 4, 5, 6});
//        ListNode.printListNode(reverseList(listNode));
        ListNode.printListNode(reverseListInplace(listNode));
    }

    // insert method
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = head;
        ListNode succ = curr.next;
        while (succ != null) {
            succ = curr.next;
            curr.next = dummy.next;
            dummy.next = curr;
            curr = succ;
        }
        return dummy.next;
    }

    public static ListNode reverseListInplace(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pred = head;
        ListNode curr = head.next;
        ListNode succ = head.next.next;
        pred.next = null;
        while (succ != null) {
            // different approach
//        while (succ.next != null) {
//            succ = curr.next;
            curr.next = pred;
            pred = curr;
            curr = succ;
            succ = succ.next;
        }
        curr.next = pred;

        return curr;
    }
}
