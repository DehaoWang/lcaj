package leetcode.lc4;

/**
 * Created by wangdehao on 18/4/11.
 */
public class MedianOfTwoSortedArrays {

    /**
     * test cases
     */

    public static void main(String[] args){
        int[] nums1 = {1, 2};
        int[] nums2 = {1, 2};
        int[] m = mergeSortedArrays(nums1, nums2);
        printArray(nums1);
        printArray(nums2);
        printArray(m);
        System.out.println("median="+findMedianSortedArrays(nums1, nums2));


        int[] testMed = {1,1,2,2};
        System.out.println("median="+getMedian(testMed));

    }

    /**
     * algorithm
     */

    // submitted
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = mergeSortedArrays(nums1, nums2);
        return getMedian(merged);
    }

    public static double getMedian(int[] a){
        int len = a.length;
        if(len % 2 != 0){
            return a[(len-1)/2];
        }
        else {
            return (double) (a[len/2-1] + a[len/2])/2;
        }
    }

    public static int[] mergeSortedArrays(int[] nums1, int[] nums2){
        int l1 = nums1.length;
        int l2 = nums2.length;
        int[] mergedArray = new int[l1+l2];
        int i1 = 0, i2 = 0, k = 0;
        while(k < l1+l2){
            System.out.println(String.format("before: i1=%d,i2=%d", i1, i2));
            if(i1 >= l1 && i2 < l2){
                mergedArray[k] = nums2[i2];
                i2++;
                k++;
            }
            else if(i2 >= l2 && i1 < l1){
                mergedArray[k] = nums1[i1];
                i1++;
            }
            else if(i1 < l1 && i2 < l2 && nums1[i1] > nums2[i2]){
                mergedArray[k] = nums2[i2];
                i2++;
            }
            else if(i1 < l1 && i2 < l2 && nums1[i1] <= nums2[i2]){
                mergedArray[k] = nums1[i1];
                i1++;
            }
            System.out.println(String.format("after : i1=%d,i2=%d", i1, i2));
            k++;
        }
        return mergedArray;
    }

    public static void printArray(int[] a){
        System.out.println("printing array:");
        for(int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
    }

}
