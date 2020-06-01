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


        ListNode head4 = ListNode.getListFromArray(new int[]{1, 2, 3, 4, 5, 6});
        ListNode.printListNode(head4);
        head4 = reverseKGroup(head4, 2);
        ListNode.printListNode(head4);

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

    public static ListNode reverse(ListNode a) {
        ListNode pred, curr, next;
        pred = null;
        curr = a;
        next = a;
        while (curr != null) {
            next = curr.next;
            // 逐个结点反转
            curr.next = pred;
            // 更新指针位置
            pred = curr;
            curr = next;
        }
        // 返回反转后的头结点
        return pred;
    }

    public static ListNode reverse(ListNode a, ListNode b) {
        ListNode pred, curr, next;
        pred = null;
        curr = a;
        next = a;
        while (curr != b) {
            next = curr.next;
            // 逐个结点反转
            curr.next = pred;
            // 更新指针位置
            pred = curr;
            curr = next;
        }
        // 返回反转后的头结点
        return pred;
    }


    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        // 区间 [a, b) 包含 k 个待反转元素
        ListNode a, b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            // 不足 k 个，不需要反转，base case
            if (b == null) return head;
            b = b.next;
        }
        // 反转前 k 个元素
        ListNode newHead = reverse(a, b);
        // 递归反转后续链表并连接起来
        a.next = reverseKGroup(b, k);
        return newHead;
    }
}
