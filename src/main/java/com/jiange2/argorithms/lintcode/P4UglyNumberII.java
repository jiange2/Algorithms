package com.jiange2.argorithms.lintcode;

import org.junit.Test;

public class P4UglyNumberII {


    @Test
    public void test(){
        int n = (int) (Math.random()*100+50);
        for(int i = 1; i<n; ++i)
            System.out.println(i + ":" + nthUglyNumber(i));
    }

    public int nthUglyNumber(int n) {
        int[] r = new int[n];
        r[0] = 1;
        int t2 = 0,t3 = 0,t5 = 0;
        int i = 1;
        while (i < n){
            r[i] = Math.min(2*r[t2],Math.min(3*r[t3],5*r[t5]));
            if(2*r[t2] == r[i]) ++t2;
            if(3*r[t3] == r[i]) ++t3;
            if(5*r[t5] == r[i]) ++t5;
            ++i;
        }
        return r[n-1];
    }


}
