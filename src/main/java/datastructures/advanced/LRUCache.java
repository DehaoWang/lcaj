package datastructures.advanced;

import datastructures.basics.linkedlist.DLLNode;
import datastructures.basics.linkedlist.DummyDoublyLinkedList;
import datastructures.basics.linkedlist.LinkedList;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class LRUCache {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2/* capacity */);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4

    }

    HashMap<Integer, DLLNode> hashList;
    DummyDoublyLinkedList doublyLinkedList;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        hashList = new HashMap<>();
        doublyLinkedList = new DummyDoublyLinkedList();
    }

    public int get(int key) {
        if (hashList.containsKey(key)) {
            DLLNode curr = hashList.get(key);
            int val = curr.val;
            put(key, val);
            return val;
        }
        return -1;
    }

    public void put(int key, int value) {
        DLLNode curr = new DLLNode(key, value);

        if (hashList.containsKey(key)) {
            DLLNode find = hashList.get(key);
            doublyLinkedList.removeNode(find);
            doublyLinkedList.addFirst(curr);
            hashList.put(key, curr);
        } else {
            if (doublyLinkedList.size() == capacity) {
                DLLNode last = doublyLinkedList.removeLast();
                hashList.remove(last.key);
            }
            doublyLinkedList.addFirst(curr);
            hashList.put(key, curr);
        }
    }
}
