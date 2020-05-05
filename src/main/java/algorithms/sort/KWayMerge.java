package algorithms.sort;

import datastructures.basic.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KWayMerge {
    public static void main(String[] args) {
        List<ListNode> lists = new ArrayList<>();
        int[][] matrix = {
                {2, 4, 5},
                {1, 3},
                {1, 4, 7}
        };
        for (int[] array : matrix) {
            ListNode list = ListNode.getListFromArray(array);
            lists.add(list);
        }

        ListNode merged = mergeKLists(lists);
        ListNode.printListNode(merged);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> listFormed = convertArrToList(lists);
        return mergeKLists(listFormed);
    }

    // assuming lists are all sorted
    public static ListNode mergeKLists(List<ListNode> lists) {
        if(lists == null || lists.isEmpty()){
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.size(), Comparator.comparingInt(a -> a.val));
        for (ListNode head : lists) {
            if (head != null) {
                pq.offer(head);
            }
        }
        while (!pq.isEmpty()) {
            ListNode curr = pq.poll();
            ListNode next = curr.next;

            insertAfterNode(tail, curr);
//            insertAfterNode(dummy, curr);
//            System.out.println(curr.val);
            if (next != null) {
                pq.offer(next);
            }
            tail = curr;
        }
        return dummy.next;
    }

    public static void insertAfterNode(ListNode prev, ListNode curr) {
        curr.next = prev.next;
        prev.next = curr;
    }

    public static List<ListNode> convertArrToList(ListNode[] lists) {
        List<ListNode> listFormed = new ArrayList<>();
        for (ListNode listNode : lists) {
            listFormed.add(listNode);
        }
        return listFormed;
    }
}
