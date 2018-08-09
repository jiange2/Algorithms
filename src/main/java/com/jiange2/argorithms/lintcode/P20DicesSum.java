package com.jiange2.argorithms.lintcode;

import org.junit.Test;

import java.util.*;

public class P20DicesSum {
    /**
     * @param n an integer
     * @return a list of Map.Entry<sum, probability>
     */
    public List<Map.Entry<Integer, Double>> dicesSum(int n) {

        int len = 6 * n - n +1;
        long[] dp1 = new long[len];
        long[] dp2 = new long[len];

        for (int i = 0; i < 6; i++) {
            dp1[i] = 1;
        }

        System.out.println(Arrays.toString(dp1));
        for (int i = 1; i < n; i++) {
            len = 6 * (i+1) - i;
            for (int j = 0; j < len; j++) {
                int start = j-5 > 0 ? j-5 : 0;
                int end = Math.min(j,len-6);
                dp2[j] = 0;
                for (int k = start; k <= end; k++) {
                    dp2[j] += dp1[k];
                }
            }
            long[] t = dp1;
            dp1 = dp2;
            dp2 = t;
            System.out.println(Arrays.toString(dp1));
        }
        Map<Integer,Double> map = new HashMap<>();
        double total = Math.pow(6,n);
        int start = n;
        for (long count : dp1) {
            map.put(start++, count / total);
        }
        return new ArrayList<>(map.entrySet());
    }

    @Test
    public void test(){
        int n =3;
        List<Map.Entry<Integer, Double>> list = dicesSum(n);
        System.out.println(list);
    }

    private void printArray(long[][] array){
        for (long[] anArray : array) {
            System.out.println(Arrays.toString(anArray));
        }
    }
}
