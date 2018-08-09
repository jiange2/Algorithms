package com.jiange2.argorithms.lintcode;

import org.junit.Test;

import java.util.Arrays;

public class P792 {

    public int kthPrime(int n) {
        boolean[] isNotPrime = new boolean[n+1];
        isNotPrime[0] = true;
        isNotPrime[1] = true;
        int count = 0;
        for (int i = 2; i < n+1; i++) {
            if(!isNotPrime[i]){
                System.out.println(i+","+count);
                ++count;
                for (int j = i * 2; j < n+1; j+=i) {
                    if(j > 0){
                        isNotPrime[j] = true;
                    }
                }
            }
        }
        System.out.println();

        System.out.println(Arrays.toString(isNotPrime));

        return count;
    }

    @Test
    public void test(){
        System.out.println(kthPrime(63527));
    }
}
