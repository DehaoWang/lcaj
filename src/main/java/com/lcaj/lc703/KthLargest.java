package com.lcaj.lc703;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KthLargest {
    private int[] minHeap;
    private int len;
    private int size = 0;
    private boolean init = false;
    private int tempMin = Integer.MAX_VALUE;

    public static void main(String[] args) throws FileNotFoundException {
        int[] nums = {
        };
        int[] numsF = readArrayFromFile("/Users/mtdp1/Downloads/Lc703_nums");
//        System.out.println(numsF.length);
        KthLargest obj = new KthLargest(9999, numsF);

        int[] next = {};
//        int[] next = {3, 5, 10, 9, 4};
        int[] nextF = readArrayFromFile("/Users/mtdp1/Downloads/Lc703_next");
        for (int i : nextF) {
            int param_1 = obj.add(i);
//            System.out.println(param_1);
        }

        int[] nums1 = {4, 5, 8, 2};
        KthLargest obj1 = new KthLargest(9999, numsF, true);
        for (int i : nextF) {
            int param_1 = obj1.add(i, true);
            System.out.println(param_1);
        }



//        int[] copy = nums.clone();
//        ArrayMethods.heapAdjustMin(copy, copy.length, true);
//        ArrayMethods.printArray(copy);


    }

    private static int[] readArrayFromFile(String s) throws FileNotFoundException {
        FileReader fileReader = new FileReader(s);
        Scanner sc = new Scanner(fileReader);
        String line = sc.nextLine();
        String[] tokens = line.split(",");
        int[] array = new int[tokens.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(tokens[i]);
        }
        return array;
    }

    public KthLargest(int k, int[] nums) {
        if (nums != null) {
            this.len = k;
            this.minHeap = new int[len];
            for (int i = 0; i < len; i++) {
                minHeap[i] = Integer.MIN_VALUE;
            }

            for (int n : nums) {
                add(n);
            }
        }
    }

    public int add(int val) {
        if (size < len) {
            minHeap[size] = val;
            tempMin = val < tempMin ? val : tempMin;
            size++;
            return tempMin;
//            ArrayMethods.heapAdjustMin(minHeap, size, true);
//            heapAdjustMin(minHeap, len, true);
        } else {
            if (!init) {
//                heapAdjustMin(minHeap, len, true);
                buildHeap(minHeap, true);
                init = true;
            }
            if (minHeap[0] >= val) {
                return minHeap[0];
            } else {
                minHeap[0] = val;
//                ArrayMethods.heapAdjustMin(minHeap, size, true);
//                heapAdjustMin(minHeap, len, true);
                conditionalHeapify(minHeap, 0, true);
            }
            return minHeap[0];
        }
    }

    private void conditionalHeapify(int[] heap, int p, boolean isMin) {
        int l = p * 2 + 1;
        int r = p * 2 + 2;
        if (l >= heap.length) {
            return;
        } else if (r >= heap.length) {
            if (heap[l] < heap[p]) {
                swap(heap, l, p);
                return;
            }
        }

        if (isMin) {
            int minIdx = heap[l] > heap[r] ? r : l;
            if (heap[p] > heap[minIdx]) {
                swap(heap, p, minIdx);
                conditionalHeapify(heap, minIdx, isMin);
            }
        } else {
            int maxIdx = heap[l] > heap[r] ? l : r;
            if (heap[p] < heap[maxIdx]) {
                swap(heap, p, maxIdx);
                conditionalHeapify(heap, maxIdx, isMin);
            }
        }
    }

    public void buildHeap(int[] heap, boolean isMin) {
        int i = heap.length / 2 - 1;
        while (i >= 0) {
            conditionalHeapify(heap, i, isMin);
            i--;
        }
    }

    public void heapAdjustMin(int[] heap, int length, boolean isMin) {
        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j > i; j -= 2) {
                int p = (j - 1) / 2;
                int l = p * 2 + 1;
                int r = p * 2 + 2;
                heapShiftMin(heap, p, l, r, isMin);
            }
        }
    }


    private void heapShiftMin(int[] heap, int p, int l, int r, boolean isMin) {
        if (r >= heap.length) {
            if ((isMin && heap[l] < heap[p])
                    || (!isMin && heap[l] > heap[p])) {
                swap(heap, l, p);
            }
            return;
        }

        int maxIdx;
        int minIdx;
        if (heap[l] > heap[r]) {
            maxIdx = heap[l] > heap[p] ? l : p;
            minIdx = heap[r] < heap[p] ? r : p;
        } else {
            maxIdx = heap[r] > heap[p] ? r : p;
            minIdx = heap[l] < heap[p] ? l : p;
        }
        if (isMin && minIdx != p) {
            swap(heap, minIdx, p);
        } else if (!isMin && maxIdx != p) {
            swap(heap, maxIdx, p);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private PriorityQueue priorityQueue;

    public KthLargest(int k, int[] nums, boolean pq) {
        len = k;
        priorityQueue = new PriorityQueue<Integer>();
        for (int n : nums) {
            add(n, true);
        }
    }

    public int add(int val, boolean pq){
        if(priorityQueue.size() < len){
            priorityQueue.offer(val);
//            priorityQueue.add(val);

            return (Integer) priorityQueue.peek();
        }else {
            int kth = (Integer) priorityQueue.peek();
            if(val <= kth){
                return kth;
            }else {
                priorityQueue.add(val);
                return (Integer) priorityQueue.poll();
            }
        }
    }
}
