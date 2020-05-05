package com.lcaj.lc203;

import datastructures.basic.linkedlist.ListNode;

/**
 * Created by wangdehao on 19/4/15.
 */
public class RemoveLinkedListElement {
    public static void main(String[] args) {
        int[][] m = {
                {6},
                {6, 2, 6, 4, 5},
                {1, 2, 6, 4, 5},
                {1, 2, 6, 3, 4, 5, 6},
        };
        ListNode[] listNodes = ListNode.getListFrom2dArray(m);
        for (ListNode listNode : listNodes) {
            ListNode left = removeElements(listNode, 6);
            ListNode.printListNode(left);
        }

    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = head;
        ListNode pred = dummy;
        while (curr != null) {
            if (curr.val == val) {
                pred.next = curr.next;
            } else {
                pred = pred.next;
            }
            curr = curr.next;
        }

        return dummy.next;
    }
}
