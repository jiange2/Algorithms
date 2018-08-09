package com.jiange2.argorithms.newcoder.moni2018;

import java.util.Scanner;

public class 排列 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(solution(arr));
    }

    public static int solution(int[] arr){

        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == i + 1){
                swap(arr,i);
                ++count;
            }
        }

        return count;
    }

    public static void swap(int[] arr, int i){
        int t,des = i + 1;
        if(des >= arr.length){
            des = i - 1;
        }

        t = arr[i];
        arr[i] = arr[des];
        arr[des] = t;
    }
}
