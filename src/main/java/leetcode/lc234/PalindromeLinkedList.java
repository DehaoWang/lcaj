package leetcode.lc234;

import datastructures.basic.linkedlist.ListNode;

/**
 * Created by wangdehao on 19/4/18.
 */
public class PalindromeLinkedList {
    public static void main(String[] args) {
        int[][] m = {
                {6},
                {6, 2, 6, 4, 5},
                {1, 2, 6, 4, 5},
                {1, 2, 6, 3, 4, 5, 6},
                {1, 2, 6, 3, 4, 5, 6, 3, 4, 6, 5, 8},
                {1, 2, 3, 3, 2, 1},
                {1, 2, 3, 4, 3, 2, 1},
        };
        ListNode[] listNodes = ListNode.getListFrom2dArray(m);
        for (ListNode listNode : listNodes) {
            System.out.println(isPalindrome(listNode));
        }
    }

    public static boolean isPalindrome(ListNode head) {
        // 1st round: find length
        // 2nd round: halve the linked list, reverse the right part
        // 3rd round: compare and determine palindrome

        // 1st
        ListNode curr = head;
        int count = 0;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        System.out.println(count);
        if (count <= 1) {
            return true;
        }

        // 2nd
        curr = head;
        int count2 = 0;
        while (count2 < (count + 1) / 2) {
            curr = curr.next;
            count2++;
        }
        System.out.println("h2=" + curr.val);
        ListNode reversed = reverseList(curr);
        ListNode.printListNode(reversed);

        // 3rd
        ListNode l = head;
        ListNode r = reversed;
        while (r != null) {
            if (l.val != r.val) {
                return false;
            }
            l = l.next;
            r = r.next;
        }

        return true;
    }

    public static ListNode reverseList(ListNode l){
        ListNode dummyNode = new ListNode(0);
        while(l != null){
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
}
