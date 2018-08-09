package com.jiange2.argorithms.newcoder.wangyi2018;

import java.util.Scanner;

public class 魔法币 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        StringBuilder sb = new StringBuilder();
        while (n > 0){
            if((n & 1) == 0){
                sb.append(2);
                n = (n - 2) / 2;
            }else{
                sb.append(1);
                n = (n - 1) / 2;
            }
        }

        char[] arr = sb.toString().toCharArray();
        char t;
        for (int i = 0; i < arr.length/2; i++) {
            t = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = t;
        }

        System.out.println(new String(arr));
    }
}
