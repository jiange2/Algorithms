package com.jiange2.argorithms.newcoder.moni2018;

import java.util.Arrays;
import java.util.Scanner;

//通过
public class 打车 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = scanner.nextInt();
        }
        Arrays.sort(p);
        System.out.println(getMostCoin(p,s));
    }

    public static int getMostCoin(int[] p, int s){
        int sum = 0;
        int i = 0, j, left;
        while (sum < s){
            sum += p[i++];
        }
        left = sum - s;
        j = i - 1;
        while (left > 0 && j >= 0){
            if(p[j] <= left){
                i -= 1;
                left -= p[j];
            }
            --j;
        }
        return i;
    }
}
