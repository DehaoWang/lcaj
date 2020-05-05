package com.lcaj.lc148;

import datastructures.basic.linkedlist.ListNode;

/**
 * Created by wangdehao on 18/12/11.
 */
public class SortList {
    public static void main(String[] args) {
        int[][] matrix = {
//                {4, 3, 1, 5, 2},
                {4, 19, 14, 5, -3, 1, 8, 5, 11, 15},
        };
        for (int[] nums : matrix) {
            ListNode result = ListNode.getListFromArray(nums);
            ListNode.printListNode(result);

            ListNode.printListNode(sortList(result));
        }

//        int[][] matrix2 = {
////                {1, 3, 4},
////                {2, 5},
//                {1, 3, 4},
//                {2, 5},
//        };
//        ListNode l0 = ListNode.getListFromArray(matrix2[0]);
//        ListNode l1 = ListNode.getListFromArray(matrix2[1]);
//        ListNode lm = mergeLists(l0, l1);
//        ListNode.printListNode(lm);
    }

    public static ListNode sortList(ListNode head) {
        // break situations
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return head;
        }

        // split
        ListNode leftHead = head;
        ListNode leftTail = getMiddleOfList(head);
        ListNode rightHead = leftTail.next;
        leftTail.next = null;

        // recursive sort
        ListNode sortedLeftHead = sortList(leftHead);
        ListNode sortedRightHead = sortList(rightHead);

        // merge
        ListNode mergedHead = mergeLists(sortedLeftHead, sortedRightHead);

        return mergedHead;
    }

    private static ListNode mergeLists(ListNode sortedLeftHead, ListNode sortedRightHead) {
        if (sortedLeftHead == null) {
            return sortedRightHead;
        } else if (sortedRightHead == null) {
            return sortedLeftHead;
        } else {
            ListNode leftCurr = sortedLeftHead;
            ListNode rightCurr = sortedRightHead;
            ListNode dummy = new ListNode(0);
            ListNode mergeCurr = dummy;

            while (leftCurr != null && rightCurr != null) {
                if (leftCurr.val < rightCurr.val) {
                    mergeCurr.next = leftCurr;
                    leftCurr = leftCurr.next;
                } else if (leftCurr.val >= rightCurr.val) {
                    mergeCurr.next = rightCurr;
                    rightCurr = rightCurr.next;
                }
                mergeCurr = mergeCurr.next;
            }
            if (leftCurr == null) {
                mergeCurr.next = rightCurr;
            }
            if (rightCurr == null) {
                mergeCurr.next = leftCurr;
            }
            return dummy.next;
        }
    }

    private static ListNode getMiddleOfList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
