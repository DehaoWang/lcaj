package types.twopointers;

import datastructures.basics.ListNode;

public class CycledLinkedList {
    public static void main(String[] args) {
//        ListNode list = ListNode.getListFromArray(new int[]{0, 1, 2, 3, 4, 5});
//        ListNode.printListNode(list);

        ListNode node0 = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node2;

//        ListNode.printListNode(node0);
        System.out.println(hasCycle(node0));
        System.out.println(getStartOfCycle(node0).val);
    }

    public static boolean hasCycle(ListNode head) {
        ListNode p = head;
        ListNode q = head;

        while (q != null && q.next != null) {
            p = p.next;
            q = q.next.next;
            if (p == q) {
                return true;
            }
        }
        return false;
    }

    public static ListNode getStartOfCycle(ListNode head) {
        ListNode p = head;
        ListNode q = head;

        // cycle length = k, [q - start = m], [start - q = k - m]
        while (q != null && q.next != null) {
            p = p.next;
            q = q.next.next;
            if (p == q) {
                break;
            }
        }
        // [head - start = k - m]
        q = head;
        while (q != p) {
            p = p.next;
            q = q.next;
        }
        return p;
    }
}
