package com.lcaj.lc206;

import datastructures.basics.linkedlist.ListNode;

/**
 * Created by wangdehao on 19/4/16.
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        int[][] m = {
                {6},
                {6, 2, 6, 4, 5},
                {1, 2, 6, 4, 5},
                {1, 2, 6, 3, 4, 5, 6},
        };
        ListNode[] listNodes = ListNode.getListFrom2dArray(m);
        for (ListNode listNode : listNodes) {
//            ListNode rev = reverseList(listNode);
            ListNode rev = reverseList2(listNode);
            ListNode.printListNode(rev);
        }

    }

    public static ListNode reverseList2(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode curr = head;
        ListNode succ;
        while (curr != null) {
            succ = dummy.next;
            dummy.next = curr;
//            curr.next = succ;
            curr = curr.next;
            dummy.next.next = succ;
        }
        return dummy.next;
    }

    public static ListNode reverseList(ListNode head) {

        ListNode dummy = new ListNode(0);
        ListNode curr = head;

        ListNode succ;
        while (curr != null) {
            succ = dummy.next;
            dummy.next = curr;
            curr = curr.next;
            dummy.next.next = succ;
        }

        return dummy.next;
    }
}
