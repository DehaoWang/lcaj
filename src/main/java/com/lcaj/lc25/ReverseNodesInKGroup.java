package com.lcaj.lc25;

import datastructures.basics.linkedlist.ListNode;

/**
 * Created by wangdehao on 18/5/2.
 */
public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        int[][] m = {
                {1, 2, 3},
                {1, 2, 3, 4},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5, 6},
                {1, 2, 3, 4, 5, 6, 7},
        };
        ListNode[] lists = ListNode.getListFrom2dArray(m);
        for(ListNode listNode: lists){
            ListNode kReversed = reverseKGroup(listNode, 3);
            ListNode.printListNode(kReversed);
        }

    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null){
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode nextHead = head;
        ListNode curr = head;

        while(nextHead != null){

            // find nextHead
            ListNode preNextHead = nextHead;
            int cntAll = 0;
            for(int i = 0; i < k && nextHead != null; i++){
                nextHead = nextHead.next;
                cntAll++;
            }


            // CORE LOGIC:
            // if not able to collect K elements, use pre next head
            // else, go reverse
            if(cntAll < k){
                pre.next = preNextHead;
                break;
            }
            else {
                pre.next = nextHead;
            }
            int cnt = k;

            while(cnt > 0 && curr != null){
                // temp

                ListNode temp = curr.next;

                // concat
                curr.next = pre.next;
                pre.next = curr;

                // move
                curr = temp;
                cnt--;
            }

            for(int i = 0; i < k && pre != null; i++){
                pre = pre.next;
            }

        }

        return dummy.next;
    }

}
