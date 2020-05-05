package com.lcaj.lc143;

import datastructures.basic.linkedlist.ListNode;

public class ReorderList {
    public static void main(String[] args) {
        int[][] matrix = {
                {1},
                {1, 2, 3, 4},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5, 6, 7, 8},
                {1, 2, 3, 4, 5, 6, 7, 8, 9}
        };
        for (int[] array : matrix) {
            ListNode list = ListNode.getListFromArray(array);
            reorderList(list);
            ListNode.printListNode(list);
        }
    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        // set p to the head of 2nd half
        ListNode pre = head;
        ListNode p = head;
        ListNode q = head;
        while (q != null && q.next != null) {
            pre = p;
            p = p.next;
            q = q.next.next;
        }
        // get rid of the tail in 1st half
        pre.next = null;

        // reverse 2nd half
        ListNode r = ListNode.reverseList(p);

        // merge head and r
        ListNode.merge(head, r);
    }
}
