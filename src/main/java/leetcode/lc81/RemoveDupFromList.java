package leetcode.lc81;

import datastructures.basic.linkedlist.ListNode;

/**
 * Created by wangdehao on 18/11/22.
 */
public class RemoveDupFromList {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 3, 4, 4, 5},
                {1, 1, 1, 2, 3},
                {},
                {1, 1, 1, 1}
        };
        for (int[] numsX : matrix) {
            ListNode lnX = ListNode.getListFromArray(numsX);
            ListNode distX = deleteDuplicates(lnX);
            ListNode.printListNode(distX);
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pred = dummy;
        ListNode curr = head;
        ListNode succ = curr.next;

        while (curr != null && succ != null) {
            if (curr.val == succ.val) {
                while (succ != null && curr.val == succ.val) {
                    succ = succ.next;
                }
                // remove redundant
                curr.next = succ;
//                pred.next = succ;
//                curr = succ;
            } else {
                pred = pred.next;
                curr = curr.next;
            }
            if (curr != null) {
                succ = curr.next;
            }
        }

        return dummy.next;
    }
}
