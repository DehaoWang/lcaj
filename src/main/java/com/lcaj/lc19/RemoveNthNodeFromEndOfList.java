package com.lcaj.lc19;

import datastructures.basic.linkedlist.ListNode;

/**
 * Created by wangdehao on 18/4/28.
 */
public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args){
        int[][] testI = {
                {1, 2, 3, 4, 5, 6, 7},
                {1, 2},
        };
        for(int[] a: testI){

            ListNode l = ListNode.getListFromArray(a);
            ListNode.printListNode(l);

            ListNode res = removeNthFromEndGS(l, 2);
            ListNode.printListNode(res);

        }

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int l = 0;
        ListNode cur = dummy;
        while(cur.next != null){
            cur = cur.next;
            l++;
        }
        System.out.println("l="+l);
        int c = 0;
        ListNode pre = dummy;
        cur = dummy;
        while(c <= l - n){
            pre = cur;
            cur = cur.next;
            c++;
        }
        System.out.println("c="+c+", cur="+cur.val+", pre="+pre.val);

        pre.next = cur.next;
        return dummy.next;
    }

    public static ListNode removeNthFromEndGS(ListNode head, int n){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode p = head;
        ListNode q = head;

        for(int i = 0; i < n; i++)
        {
            q = q.next;
        }
        while(q != null)
        {
            prev = p;
            p = p.next;
            q = q.next;
        }

        prev.next = p.next;

        return dummy.next;
    }

}
