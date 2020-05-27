package leetcode.lc82;

import datastructures.basic.linkedlist.ListNode;

/**
 * Created by wangdehao on 18/11/22.
 */
public class RemoveDupFromListII {
    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 3, 4, 4, 5};
//        ListNode ln = ListNode.getListFromArray(nums);
//        ListNode dist = deleteDuplicatesRecur(ln);
//        ListNode.printListNode(dist);
//
//        int[] nums2 = {1, 1, 1, 2, 3};
//        ListNode ln2 = ListNode.getListFromArray(nums2);
//        ListNode dist2 = deleteDuplicatesRecur(ln2);
//        ListNode.printListNode(dist2);
//
//        int[] nums3 = {};
//        ListNode ln3 = ListNode.getListFromArray(nums3);
//        ListNode dist3 = deleteDuplicatesRecur(ln3);
//        ListNode.printListNode(dist3);
//
//        int[] nums4 = {1, 1, 1, 1};
//        ListNode ln4 = ListNode.getListFromArray(nums4);
//        ListNode dist4 = deleteDuplicatesRecur(ln4);
//        ListNode.printListNode(dist4);

        int[][] matrix = {
                {1, 2, 3, 3, 4, 4, 5},
                {1, 1, 1, 2, 3},
                {},
                {1, 1, 1, 1}
        };
        for (int[] numsX : matrix) {
            ListNode lnX = ListNode.getListFromArray(numsX);
            ListNode distX = deleteDuplicatesIter(lnX);
            ListNode.printListNode(distX);
        }


    }

    public static ListNode deleteDuplicatesIter(ListNode head) {
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
//                curr.next = succ;
                // remove all duplicates
                pred.next = succ;
                curr = succ;
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

    public static ListNode deleteDuplicatesRecur(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pred = new ListNode(0);
        pred.next = head;
        ListNode curr = head.next;
        ListNode succ = curr.next;
        if (head.val == curr.val) {
            // should deal with 1,1,1,2,3
            if (succ == null) {
                return succ;
            } else if (curr.val == succ.val) {
                return deleteDuplicatesRecur(succ);
            }
            return deleteDuplicatesRecur(succ);
        } else {
            // correct
            head.next = deleteDuplicatesRecur(curr);
            return head;
        }
    }
}
