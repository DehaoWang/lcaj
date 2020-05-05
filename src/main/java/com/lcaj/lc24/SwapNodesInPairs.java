package com.lcaj.lc24;

import datastructures.basic.linkedlist.ListNode;

/**
 * Created by wangdehao on 18/5/2.
 */
public class SwapNodesInPairs {

    public static void main( String[] args ) {
        int[][] m = {
//                {1, 2, 3, 4, 5, 6},
                {1, 2, 3, 4, 5, 6 },
        };
        ListNode[] lists = ListNode.getListFrom2dArray(m);
        for(ListNode listNode: lists){
            ListNode swaped = swapPairs(listNode);
            ListNode.printListNode(swaped);
        }

    }

    public static ListNode swapPairs(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre2 = dummy;
        ListNode pre = head;
        ListNode curr = pre.next;
        while(curr != null){
            // relink: swap √
            pre.next = curr.next;
            pre2.next = curr;
            curr.next = pre;

            // iteration
            if(pre.next != null){
                pre2 = pre;
                curr = pre.next.next;
                pre = pre.next;
            }
            else {
                break;
            }
        }

        return dummy.next;

    }
}
