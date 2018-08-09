package com.jiange2.argorithms.lintcode;

import org.junit.Test;

import java.util.Arrays;

public class P793 {


    public int intersectionOfArrays(int[][] arrs) {
        if (arrs == null || arrs.length == 0) {
            return 0;
        }

        if (arrs.length == 1) {
            return arrs[0].length;
        }


        for (int i = 0; i < arrs.length; i++) {
            Arrays.sort(arrs[i]);
        }

        int count = 0,t2 = 0;
        boolean isAllEqual, isEnd = false;
        int[] y = new int[arrs.length];

        while (y[0] < arrs[0].length){

            int t = arrs[0][y[0]++];
            isAllEqual = true;
            for (int i = 1; i < arrs.length; i++) {
                while (y[i] < arrs[i].length && (t2 = arrs[i][y[i]]) < t ){
                    ++y[i];
                }
                if(t2 < t){
                    isEnd = true;
                }
                if(t2 > t){
                    isAllEqual = false;
                    break;
                }
            }

            if(isEnd){
                break;
            }
            if(isAllEqual){
                ++count;
            }
        }


        return count;
    }

    @Test
    public void test(){
        int[][] arrs = {{1,2,3,4},{1,2,5,6,7},{9,10,1,5,2,3}};
        System.out.println(intersectionOfArrays(arrs));
    }
}
