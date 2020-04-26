package com.lcaj.lc142;

import datastructures.basics.linkedlist.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wangdehao on 18/12/10.
 */
public class LinkedListCycleII {
    public static void main(String[] args) {

    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        Set<ListNode> nodeSet = new HashSet<>();
        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
            if(nodeSet.contains(curr)){
                return curr;
            }
            nodeSet.add(curr);
        }
        return null;
    }
}
