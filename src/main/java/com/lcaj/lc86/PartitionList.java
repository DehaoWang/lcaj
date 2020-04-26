package com.lcaj.lc86;

import datastructures.basics.linkedlist.ListNode;

/**
 * Created by wangdehao on 18/11/22.
 */
public class PartitionList {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 3, 2, 5, 2},
        };
        for (int[] numsX : matrix) {
            ListNode lnX = ListNode.getListFromArray(numsX);
            ListNode partX = partition(lnX, 3);
            ListNode.printListNode(partX);
        }
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode smallDummy = new ListNode(0);
        smallDummy.next = head;
        // pseudo code:
        // small head, large head, compare to x, add it accordingly

        // implementation
        ListNode largeDummy = new ListNode(0);
        ListNode curr = head;
        ListNode smallPred = smallDummy;
        ListNode largeCurr = largeDummy;
        while (curr != null) {
            if (curr.val >= x) {
                largeCurr.next = curr;
                largeCurr = largeCurr.next;
            } else {
                smallPred.next = curr;
                smallPred = smallPred.next;
            }
            curr = curr.next;
        }
        smallPred.next = largeDummy.next;
        // easy to get bug
        largeCurr.next = null;
        return smallDummy.next;
    }
}
