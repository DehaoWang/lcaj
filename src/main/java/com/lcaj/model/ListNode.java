package com.lcaj.model;

/**
 * Created by wangdehao on 18/4/12.
 */
public class ListNode {
    // Definition for singly-linked list.
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
    }

    public static ListNode getListFromArray(int[] a){
        if(a.length <= 0){
            return null;
        }
        ListNode first = new ListNode(a[0]);
        ListNode curr = first;
        for(int i = 1; i < a.length; i++){
            curr.next = new ListNode(a[i]);
            curr = curr.next;
        }
        return first;
    }

    public static void printListNode(ListNode l){
        System.out.println("Printing Node List");
        while (l != null){
            System.out.println(l.val);
            l = l.next;
        }
    }

    // auxiliary method
    public static ListNode reverseList(ListNode l){
        ListNode dummyNode = new ListNode(0);
        while(l != null){
            // temp
            ListNode temp = l.next;

            // concat
            l.next = dummyNode.next;
            dummyNode.next = l;

            // move
            l = temp;
        }
        return dummyNode.next;
    }
}
