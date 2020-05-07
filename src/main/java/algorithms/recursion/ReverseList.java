package algorithms.recursion;

import datastructures.basic.linkedlist.ListNode;

public class ReverseList {
    public static void main(String[] args) {
        ListNode head = ListNode.getListFromArray(new int[]{1, 2, 3, 4, 5, 6});
        ListNode.printListNode(head);
        head = ListNode.reverseList(head);
        ListNode.printListNode(head);

        ListNode head1 = ListNode.getListFromArray(new int[]{1, 2, 3, 4, 5, 6});
        ListNode.printListNode(head1);
        head1 = reverseList(head1);
        ListNode.printListNode(head1);

        ListNode head2 = ListNode.getListFromArray(new int[]{1, 2, 3, 4, 5, 6});
        ListNode.printListNode(head2);
        head2 = reverseN(head2, 3);
        ListNode.printListNode(head2);

        ListNode head3 = ListNode.getListFromArray(new int[]{1, 2, 3, 4, 5, 6});
        ListNode.printListNode(head3);
        head3 = reverseMN(head3, 2, 4);
        ListNode.printListNode(head3);
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    static ListNode succ = null;

    public static ListNode reverseN(ListNode head, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        if (n == 1) {
            succ = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = succ;
        return last;
    }

    public static ListNode reverseMN(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        if (m == 1) {
            return reverseN(head, n);
        }
        head.next = reverseMN(head.next, m - 1, n - 1);
        return head;
    }
}
