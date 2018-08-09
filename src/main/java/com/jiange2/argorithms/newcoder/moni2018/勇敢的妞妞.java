package com.jiange2.argorithms.newcoder.moni2018;

import java.util.Scanner;

public class 勇敢的妞妞 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[][] ch = new int[n][5];
        int[] r = new int[5];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                ch[i][j] = sc.nextInt();
            }
        }
        int[] dp = new int[n];
        System.out.println(solution(ch,0,s,r));
    }

    public static int solution(int[][] ch,int pos,int s,int[] r){
        if(s == 0){
            return sumOfArray(r);
        }

        if(pos == ch.length - 1){
            int sum = 0;
            for (int i = 0; i < r.length; i++) {
                sum += Math.max(ch[pos][i],r[i]);
            }
            return sum;
        }

        int max = 0;
        for (int i = 0; i < r.length; i++) {
            if(ch[pos][i] > r[i]){
                int[] newR = new int[r.length];
                for (int j = 0; j < r.length; j++) {
                    newR[j] = Math.max(r[j],ch[pos][j]);
                }
                max = solution(ch,pos + 1,s-1,newR);
            }
        }

        max = Math.max(max,solution(ch,pos + 1,s,r));

        return max;
    }

    public static int sumOfArray(int[] arr){
        int sum = 0;
        for (int anArr : arr) {
            sum += anArr;
        }
        return sum;
    }
}
