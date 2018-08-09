package com.jiange2.argorithms.lintcode;

import org.junit.Test;

public class P28SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int row = findRow(matrix, target);

        if (row < matrix.length && matrix[row][0] == target) {
            return true;
        }

        if (--row < 0) return false;
        int col = findCol(matrix[row], target);

        //--row大于0，且能在改行找到这个数
        return col < matrix[row].length && matrix[row][col] == target;
    }

    private int findRow(int[][] matrix, int target) {
        int low = 0, high = matrix.length, mid, midVal;
        while (low < high) {
            mid = (low + high) >> 1;
            midVal = matrix[mid][0];
            if (target > midVal) {
                low = mid + 1;
            } else if (target < midVal) {
                high = mid;
            } else {
                return mid;
            }
        }
        return high;
    }

    private int findCol(int[] arr, int target) {
        int low = 0, high = arr.length, mid, midVal;
        while (low < high) {
            mid = (low + high) >> 1;
            midVal = arr[mid];
            if (target > midVal) {
                low = mid + 1;
            } else if (target < midVal) {
                high = mid;
            } else {
                return mid;
            }
        }
        return high;
    }

    @Test
    public void test() {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        System.out.println(searchMatrix(matrix, 7));
    }
}
