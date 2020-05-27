package leetcode.lc92;

import datastructures.basic.linkedlist.ListNode;

/**
 * Created by wangdehao on 18/11/26.
 */
public class ReverseLinkedListII {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
//                {},
        };
        for (int[] nums : matrix) {
            ListNode ln = ListNode.getListFromArray(nums);
            ListNode result = reverseBetween(ln, 3, 3);
            ListNode.printListNode(result);
        }
    }


    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pred = dummy;
        ListNode curr = head;
        ListNode succ = curr.next;

        int pos = 1;
        while (pos < m) {
            pred = pred.next;
            curr = curr.next;
            succ = succ.next;
            pos++;
        }
        ListNode tail = curr;
        ListNode foll = curr;
        while (pos < n) {
            curr = succ;
            succ = succ.next;
            curr.next = foll;
            foll = curr;
            pos++;
        }
        pred.next = curr;
        tail.next = succ;

        return dummy.next;
    }
}
