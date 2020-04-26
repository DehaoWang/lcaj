package com.lcaj.lc23;

import com.lcaj.lc21.MergeTwoSortedList;
import datastructures.basics.ListNode;

/**
 * Created by wangdehao on 18/5/2.
 */
public class MergeKSortedLists {

    public static void main( String[] args ) {
        int[][] m = {
                {1, 4, 5},
                {1, 3, 4},
                {2, 6},
//                {2, 3, 5, 6, 7},
        };

        ListNode[] lists = ListNode.getListFrom2dArray(m);
        for(int i = 0; i < lists.length; i++){
//            ListNode.printListNode(lists[i]);
        }
//        ListNode merged = mergeKListsRecursive(lists);
        ListNode merged = mergeKListsRecursive2(lists);
        ListNode.printListNode(merged);

    }

    public static ListNode mergeKLists(ListNode[] lists) {

        return null;
    }

    // recursive: merge in pair, but stackoverflow @ judge
    public static ListNode mergeKListsRecursive(ListNode[] lists) {
        int len = lists.length;
        if(len == 1){
            return lists[0];
        }
        else if(len == 2){
            return MergeTwoSortedList.mergeTwoLists(lists[0], lists[1]);
        }
        else {
            ListNode l0 = splitAndMerge(lists, 0, len/2);
            ListNode l1 = splitAndMerge(lists, len/2, len-len/2);
            return MergeTwoSortedList.mergeTwoLists(l0, l1);
        }
    }

    public static ListNode splitAndMerge(ListNode[] lists, int idx, int length){
        ListNode[] tokens = new ListNode[length];
        System.arraycopy(lists, idx, tokens, 0, length);
        ListNode merged = mergeKListsRecursive(tokens);
        ListNode.printListNode(merged);
        return merged;
    }

    public static ListNode mergeKListsRecursive2(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        while(lists.length > 1){
            lists = mergeInPair(lists);
        }
        return lists[0];
    }

    public static ListNode[] mergeInPair(ListNode[] lists) {
        int len = lists.length;
        int halfLen = len%2 == 0 ? len/2 : len/2 + 1;
        int maxIter = len%2 == 0 ? halfLen : halfLen - 1;

        ListNode[] halfLists = new ListNode[halfLen];
        for(int i = 0; i < maxIter; i++) {
            halfLists[i] = MergeTwoSortedList.mergeTwoLists(lists[2 * i], lists[2 * i + 1]);
        }
        if(len%2 != 0){
            halfLists[halfLen-1] = lists[len-1];
        }
        for(int j = 0; j < halfLen; j++){
            ListNode.printListNode(halfLists[j]);
        }
        return halfLists;
    }
}
