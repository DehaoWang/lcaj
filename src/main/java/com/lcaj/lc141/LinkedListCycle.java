package com.lcaj.lc141;

import datastructures.basics.ListNode;

/**
 * Created by wangdehao on 18/12/10.
 */
public class LinkedListCycle {
    public static void main(String[] args) {

    }

    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
