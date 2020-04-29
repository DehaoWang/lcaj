package algorithms.recursion;

public class KthElement {


    // TODO: 2020-04-29 COMPLETE


//    public int getKth(int[] a, int k){
//        // special case
//        if(a == null || a.length == 0){
//            return -1;
//        }
//        return getKthRecursive(a, k, 0, a.length - 1);
//    }


//    public int getKthRecursive(int[] a, int k, int l, int r){
//        int pivot = a[l];
//        int m = 0;
//        while(l < r){
//            while(l < r && a[l] <= pivot){
//                l++;
//            }
//            while(l < r && a[r] >= pivot){
//                r--;
//            }
//            // swap
//            int temp = a[l];
//            a[l] = a[r];
//            a[r] = temp;
//        }
//        //todo
//
//        if(m == r - l + 1 - k){
//            return pivot;
//        } else if (m < r - l + 1 - k){
//            return getKthRecursive(a, , m, r);
//        } else {
//            return getKthRecursive(a, , l, m);
//        }
//    }
}
