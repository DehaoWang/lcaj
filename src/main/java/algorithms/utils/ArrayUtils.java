package algorithms.utils;

/**
 * Created by wangdehao on 18/11/15.
 */
public class ArrayUtils {
    public static void printArray(int[] nums) {
        for (int i : nums) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void printArray(char[] str) {
        for (char i : str) {
            System.out.print(i);
        }
        System.out.println();
    }

    public static void reverseByIndices(char[] str, int l, int r) {
        while (l < r) {
            char temp = str[l];
            str[l] = str[r];
            str[r] = temp;
            l++;
            r--;
        }
    }

    public static void reverseByIndices(int[] nums, int l, int r) {
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }

    public static void printArray(double[] nums) {
        System.out.println();
        for (double i : nums) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }

    public static void printArray(String[] string) {
        for (String s : string) {
            System.out.print(s + ", ");
        }
        System.out.println();
    }

    public static void printArray(boolean[] bools) {
        for (Boolean b : bools) {
            System.out.print(b + ", ");
        }
        System.out.println();
    }

    // search methods:
    public static int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int m;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (target > nums[m]) {
                l = m + 1;
            } else if (target < nums[m]) {
                r = m - 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    public static int binarySearchRotated(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (target == nums[m]) {
                return m;
            } else if (nums[l] <= nums[m]) {
                if (target >= nums[l] && target < nums[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if (target > nums[m] && target <= nums[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return -1;
    }

    // heap methods:
    public static void heapSort(int[] nums, boolean asc) {
        int size = nums.length;
        buildHeap(nums, size, !asc);
        while (size > 0) {
            swap(nums, 0, size - 1);
            size--;
            conditionalHeapify(nums, 0, size, !asc);
//            size--;
        }
    }

    public static void buildHeap(int[] nums, int size, boolean isMin) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int i = size / 2 - 1;
        while (i >= 0) {
            conditionalHeapify(nums, i, size, isMin);
            i--;
        }
    }

    public static void conditionalHeapify(int[] heap, int p, int limit, boolean isMin) {
        int l = p * 2 + 1, r = p * 2 + 2;
        int maxIdx = -1, minIdx = -1;
        if (l >= limit) {
            return;
        } else {
            if (r >= limit) {
                maxIdx = l;
                minIdx = l;
            } else {
                maxIdx = heap[l] > heap[r] ? l : r;
                minIdx = heap[l] > heap[r] ? r : l;
            }
            if (isMin) {
                if (heap[minIdx] < heap[p]) {
                    swap(heap, minIdx, p);
                    conditionalHeapify(heap, minIdx, limit, isMin);
                }
            } else {
                if (heap[maxIdx] > heap[p]) {
                    swap(heap, maxIdx, p);
                    conditionalHeapify(heap, maxIdx, limit, isMin);
                }
            }
        }
    }

    public static int partitionL(int[] nums, int left, int right) {
//        System.out.println("left=" + left + ", right=" + right);
//        printArray(nums);
        int l = left;
        int r = right;
        int pivot = nums[left];
        while (l < r) {
            // important: if using L as pivot, justify R first, vise versa
            while (l < r && nums[r] > pivot) {
                r--;
            }
            while (l < r && nums[l] <= pivot) {
                l++;
            }
//            System.out.println("l=" + l + ", r=" + r);
            if (l < r) {
                swap(nums, l, r);
            }
//            printArray(nums);
        }
        // important: use swap instead of assignment
        swap(nums, left, l);
        return l;
    }


    public static int partitionR(int[] nums, int left, int right) {
//        System.out.println("left=" + left + ", right=" + right);
        ArrayUtils.printArray(nums);
        int l = left;
        int r = right;
        int pivot = nums[right];
        while (l < r) {
            // important: if using L as pivot, justify R first, vise versa
            while (l < r && nums[l] < pivot) {
                l++;
            }
            while (l < r && nums[r] >= pivot) {
                r--;
            }
//            System.out.println("l=" + l + ", r=" + r);
            if (l < r) {
                swap(nums, l, r);
            }
        }
        // important: use swap instead of assignment
        swap(nums, right, r);
        return l;
    }

    public static int[] copy(int[] curr) {
        int[] copy = new int[curr.length];
        System.arraycopy(curr, 0, copy, 0, curr.length);
        return copy;
    }
}
