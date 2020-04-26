package com.lcaj.lc21;

import datastructures.basics.linkedlist.ListNode;

/**
 * Created by wangdehao on 18/4/28.
 */
public class MergeTwoSortedList {

    public static void main( String[] args ) {
        int[] a1 = {1, 2, 4};
        ListNode l1 = ListNode.getListFromArray(a1);

        int[] a2 = {1, 3, 4};
        ListNode l2 = ListNode.getListFromArray(a2);

        ListNode merged = mergeTwoLists(l1, l2);
        ListNode.printListNode(merged);

    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode c1 = l1, c2 = l2;
        ListNode dummy = new ListNode(0), curr = dummy;
        ListNode pre = dummy;


        while(c1 != null && c2 != null){
            pre = curr;
            if(c1 != null && c2 != null) {
//                System.out.println(String.format("c1=%d, c2=%d, curr=%d, pre=%d", c1.val, c2.val, curr.val, pre.val));
                if(c1.val < c2.val){
                    curr = new ListNode(c1.val);
                    c1 = c1.next;
                }
                else {
                    curr = new ListNode(c2.val);
                    c2 = c2.next;
                }
                pre.next = curr;
            }
        }
        pre = curr;
        if(c1 == null){
            pre.next = c2;
        }
        else {
            pre.next = c1;
        }

        return dummy.next;
    }
}
