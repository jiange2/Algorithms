package com.jiange2.argorithms.other;

import org.junit.Test;

public class Pow {

    @Test
    public void test(){
        for (int i = 0; i < 32; i++) {
            System.out.println(pow(2,i));
        }
    }


    public long pow(int x, int n){

        int count = 1;
        int r = 1;
        int t;
        while (n > 1){
            t = x;
            while(count * 2 <= n){
                t *= t;
                count *= 2;
            }
            r *= t;
            n -= count;
            count = 1;
        }

        if(n == 1){
            r *= x;
        }

        return r;
    }


}
