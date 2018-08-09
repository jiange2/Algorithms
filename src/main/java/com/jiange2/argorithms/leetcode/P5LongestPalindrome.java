package com.jiange2.argorithms.leetcode;


public class P5LongestPalindrome {

    public String longestPalindrome(String s) {
        XY[][] dp = new XY[s.length()][s.length()];

        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = new XY(i,i);
        }

        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < s.length() - i; j++) {
                int y = j + i;
                if(s.charAt(j) == s.charAt(y)){
                    if(y - j == 1 || dp[j+1][y-1].length() == (y - j - 1)){
                        dp[j][y] = new XY(j,y);
                    }else{
                        dp[j][y] = dp[j+1][y].length() > dp[j][y-1].length() ?
                                dp[j+1][y] : dp[j][y-1];
                    }
                }else{
                    if(y - j == 1){
                        dp[j][y] = dp[j][y-1];
                    }else{
                        dp[j][y] = dp[j+1][y].length() >  dp[j][y-1].length()?
                                dp[j+1][y] : dp[j][y-1];
                        dp[j][y] = dp[j+1][y-1].length() > dp[j][y].length() ? dp[j+1][y-1] : dp[j][y];
                    }
                }
            }
        }

        /*for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }*/
        XY xy = dp[0][dp[0].length - 1];
        return s.substring(xy.x,xy.y+1);
    }

    class XY{
        int x;
        int y;
        int length;
        public XY(int x, int y){
            this.x = x;
            this.y = y;
            length = y - x + 1;
        }
        public int length(){
            return length;
        }

        @Override
        public String toString() {
            return "XY{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
