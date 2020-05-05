package com.lcaj.lc2;

import datastructures.basic.linkedlist.ListNode;


/**
 * Created by wangdehao on 18/4/11.
 */
public class AddTwoNumbers {

    /**
     * test cases
     */

    public static void main(String[] args){
        int[] a1 = new int[]{2, 4, 3};
        ListNode l1 = ListNode.getListFromArray(a1);
        ListNode.printListNode(l1);

        int[] a2 = new int[]{5, 6, 4};
        ListNode l2 = ListNode.getListFromArray(a2);
        ListNode.printListNode(l2);

        ListNode sumList = addTwoNumbers(l1, l2);
        ListNode sumListGS = addTwoNumbersGS(l1, l2);
        ListNode.printListNode(sumListGS);


        // follow up: non-reversed order
        ListNode nonRevSum = addTwoNumbersNonRev(l1,l2);
        ListNode.printListNode(nonRevSum);

    }


    /**
     * algorithm
     */

    // submitted: recursive solution
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        return mergedList(l1, l2, carry);
    }

    private static ListNode mergedList(ListNode l1, ListNode l2, int carry) {
        if(l1 == null && l2 == null && carry <= 0){
            return null;
        }
        int sum = carry;

        sum += l1 != null ? l1.val : 0;
        sum += l2 != null ? l2.val : 0;

        carry = sum / 10;
        ListNode curr = new ListNode(sum % 10);

//        if(l1 != null && l2 == null){
//            curr.next = mergedList(l1.next, null, carry);
//        }
//        if(l1 == null && l2 != null){
//            curr.next = mergedList(null, l2.next, carry);
//        }
//        if(l1 != null && l2 != null){
//            curr.next = mergedList(l1.next, l2.next, carry);
//        }

        ListNode next1 = l1 != null ? l1.next : null;
        ListNode next2 = l2 != null ? l2.next : null;
        curr.next = mergedList(next1, next2, carry);

        return curr;
    }

    // good solutions: iterative solution
    public static ListNode addTwoNumbersGS(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode curr = dummyNode;
        ListNode p1 = l1;
        ListNode p2 = l2;
        int carry = 0;
        while(p1 != null || p2 != null){
            int sum = carry;
            sum += p1 != null ? p1.val : 0;
            sum += p2 != null ? p2.val : 0;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            p1 = p1 != null ? p1.next : null;
            p2 = p2 != null ? p2.next : null;
        }
        if(carry > 0){
            curr.next = new ListNode(carry);
        }
        return dummyNode.next;

    }

    // follow up: non-reversed order
    public static ListNode addTwoNumbersNonRev(ListNode l1, ListNode l2) {
        ListNode revL1 = ListNode.reverseList(l1);
        ListNode revL2 = ListNode.reverseList(l2);
        ListNode revSum = addTwoNumbersGS(revL1, revL2);
        return ListNode.reverseList(revSum);
    }


}
