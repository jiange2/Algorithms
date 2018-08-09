package com.jiange2.argorithms.newcoder.moni2018;

import java.util.Scanner;

public class 美丽的项链 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int[][] range = new int[n][2];
        for (int i = 0; i < n; i++) {
            range[i][0] = scanner.nextInt();
            range[i][1] = scanner.nextInt();
        }

        System.out.println(solution(range,0,s));
    }

    public static int solution(int[][] range,int pos,int s){

        int count = 0, n = range.length;
        int[][] dp = new int[n][s + 1];

        for (int i = 0; i < s + 1; i++) {
            if(i >= range[n - 1][0] && i <= range[n - 1][1]){
                dp[n - 1][i] = 1;
            }
        }

        for (int i = range.length - 2; i >= 0; --i) {
            for (int j = 0; j < s + 1; j++) {
                //求出范围
                int end = j - range[i][0];
                int start = j - range[i][1];
                start = start > 0 ? start : 0;
                for (int k = start; k <= end; k++) {
                    dp[i][j] += dp[i+1][k];
                }
            }
        }

        return dp[0][s];
    }


}
