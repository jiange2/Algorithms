package com.jiange2.argorithms.newcoder.wangyi2018;

import java.util.Scanner;

public class 相反数 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = 0;
        int t = n;
        while (t > 0){
            r += t % 10;
            r *= 10;
            t /= 10;
        }
        r /= 10;
        r += n;
        System.out.println(r);
    }
}
