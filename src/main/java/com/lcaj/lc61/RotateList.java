package com.lcaj.lc61;

import com.lcaj.model.ListNode;

/**
 * Created by wangdehao on 18/11/11.
 */
public class RotateList {
    public static void main(String[] args) {

        ListNode head = ListNode.getListFromArray(new int[]{1, 2, 3, 4, 5});
        int k = 2;
        ListNode rotated = rotateRight(head, k);
        ListNode.printListNode(rotated);


        ListNode head1 = ListNode.getListFromArray(new int[]{});
        ListNode.printListNode(rotateRight(head1, 1));

        ListNode head2 = ListNode.getListFromArray(new int[]{2});
        ListNode.printListNode(rotateRight(head2, 1));
    }

    public static ListNode rotateRight(ListNode head, int k) {
        // circled, find new head, cut tail
        if (head == null) {
            return head;
        }
        if (head.next == null) {
            return head;
        }
        // circled
        int n = 1;
        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
            n++;
        }
        curr.next = head;
        // find new head & tail
        int move = n - k % n;
        while (move > 0) {
            head = head.next;
            curr = curr.next;
            move--;
        }
        // cut tail
        curr.next = null;
        return head;
    }
}
