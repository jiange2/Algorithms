package com.jiange2.leetcode;

import com.jiange2.argorithms.leetcode.P11MostWater;
import org.junit.Test;

public class P11MostWaterTest {

    @Test
    public void maxArea() {
        P11MostWater p = new P11MostWater();
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(p.maxArea(arr));
    }

    @Test
    public void maxArea2(){
        //[2,3,10,5,7,8,9]
        P11MostWater p = new P11MostWater();
        int[] arr = {2,3,10,5,7,8,9};
        System.out.println(p.maxArea(arr));
    }
}