package datastructures.basic.linkedlist;

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

    public static ListNode getListFromArray(int[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        ListNode first = new ListNode(a[0]);
        ListNode curr = first;
        for (int i = 1; i < a.length; i++) {
            curr.next = new ListNode(a[i]);
            curr = curr.next;
        }
        return first;
    }

    public static void printListNode(ListNode l) {
        ListNode curr = l;
        System.out.println("Printing Node List");
        while (curr != null) {
            System.out.print(curr.val + " -> ");
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            curr = curr.next;
        }
        System.out.println();
    }

    // auxiliary method
    public static ListNode reverseList(ListNode l) {
        ListNode dummyNode = new ListNode(0);
        while (l != null) {
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

    public static ListNode[] getListFrom2dArray(int[][] m) {
        ListNode[] lists = new ListNode[m.length];
        for (int i = 0; i < m.length; i++) {
            lists[i] = getListFromArray(m[i]);
        }
        return lists;
    }

    public static ListNode merge(ListNode first, ListNode second) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (first != null && second != null) {
            // insert first then second
            ListNode fN = first.next;
            curr.next = first;
            first.next = second;
            curr = second;
            // iteration
            second = second.next;
            first = fN;
        }
        return dummy.next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
