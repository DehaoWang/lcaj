package com.lcaj.lc74;


/**
 * Created by wangdehao on 18/11/14.
 */
public class Search2DMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        System.out.println(searchMatrix(matrix, 3));
        System.out.println(searchMatrix(matrix, 13));
        int[][] matrix2 = {};
        System.out.println(searchMatrix(matrix2, 0));

        int[][] matrix3 = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        System.out.println(searchMatrix(matrix3, 11));

        int[][] matrix4 = {
                {1}
        };
        System.out.println(searchMatrix(matrix4, 0));

        int[][] matrix5 = {
                {1},
                {3}
        };
        System.out.println(searchMatrix(matrix5, 3));


        int[][] matrix6 = {
                {1}
        };
        System.out.println(searchMatrix(matrix6, 1));


        int[] test = {1, 10, 23};
//        System.out.println(searchInsertIndexBinary(test, 11));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
//        return searchMatrixOnFirstCol(matrix, target);
        // very good solution:
        return searchMatrixSingleList(matrix, target);
    }

    private static boolean searchMatrixSingleList(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0, r = m * n - 1;
        if(r == 0){
            return matrix[0][0] == target;
        }
        while (l < r) {
            int p = (l + r) / 2;
            if (l == r - 1) {
                if (target == matrix[l / n][l % n] || target == matrix[r / n][r % n]) {
                    return true;
                } else {
                    return false;
                }
            }
            int pivot = matrix[p / n][p % n];
            if (target == pivot) {
                return true;
            }
            if (target > matrix[p / n][p % n]) {
                l = p;
            } else {
                r = p;
            }
        }
        return false;
    }

    public static boolean searchMatrixOnFirstCol(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

//        int tarRow = searchMatrixForTarRow(matrix, target);
        int tarRow = searchMatrixForTarRowBinary(matrix, target);
        if (tarRow >= matrix.length) {
            return false;
        }
        int res = binarySearch(matrix[tarRow], target);
        return res != -1;
    }

    public static int binarySearch(int[] nums, int target) {
        return binarySearchRecursive(nums, 0, nums.length - 1, target);
    }

    public static int binarySearchRecursive(int[] nums, int l, int r, int target) {
        if (l > r) {
            return -1;
        }
        int p = (l + r) / 2;
        int pivot = nums[p];
        if (target == pivot) {
            return p;
        } else if (target < pivot) {
            return binarySearchRecursive(nums, l, p - 1, target);
        } else if (target > pivot) {
            return binarySearchRecursive(nums, p + 1, r, target);
        }
        return -1;
    }


    public static int searchMatrixForTarRowBinary(int[][] matrix, int target) {
        return searchTarRowRecursive(matrix, target, 0, matrix.length - 1);
    }

    private static int searchTarRowRecursive(int[][] matrix, int target, int l, int r) {
        if (l == r) {
            if (matrix[l][0] <= target) {
                return l;
            } else {
                return l + 1;
            }
        }
        if (l > r) {
            return 0;
        }
        if (l == r - 1) {
            if (matrix[l][0] <= target && matrix[r][0] > target) {
                return l;
            } else {
                return r;
            }
        }
        int p = (l + r) / 2;
        int pivot = matrix[p][0];
        if (target == pivot) {
            return p;
        } else if (target < pivot) {
            // use p instead of p+1, differ from binary search
            return searchTarRowRecursive(matrix, target, l, p);
        } else if (target > pivot) {
            System.out.println("p=" + p + ",r=" + r);
            return searchTarRowRecursive(matrix, target, p, r);
        }

        return 0;
    }

    public static int searchInsertIndexBinary(int[] matrix, int target) {
        return searchInsertIndexRecursive(matrix, target, 0, matrix.length - 1);
    }

    private static int searchInsertIndexRecursive(int[] matrix, int target, int l, int r) {
        if (l > r) {
            return 0;
        }
        if (l == r - 1) {
            if (matrix[l] <= target && matrix[r] > target) {
                return l;
            }
        }
        int p = (l + r) / 2;
        int pivot = matrix[p];
        if (target == pivot) {
            return p;
        } else if (target < pivot) {
            return searchInsertIndexRecursive(matrix, target, l, p);
        } else if (target > pivot) {
            return searchInsertIndexRecursive(matrix, target, p, r);
        }

        return 0;
    }

    public static int searchMatrixForTarRow(int[][] matrix, int target) {
        int m = matrix.length;
        int tarRow = 0;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] > target) {
                break;
            } else {
                tarRow = i;
            }
        }
        return tarRow;
    }

}
