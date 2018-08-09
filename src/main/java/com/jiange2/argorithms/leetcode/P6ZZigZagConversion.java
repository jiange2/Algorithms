package com.jiange2.argorithms.leetcode;

public class P6ZZigZagConversion {

    public String convert(String s, int numRows) {

        if(s.length() <= numRows || numRows <= 1){
            return s;
        }

        char[] chars = new char[s.length()];

        //
        int first = (numRows - 1)*2,second;
        int row = 0;
        int index = 0;
        while (row < s.length()){
            chars[index++] = s.charAt(row);
            row += first;
        }

        for (int i = 1; i < numRows/2; i++) {
            row = i;
            first = (numRows - 1 - i)*2;
            second = i*2;
            while (row < s.length()){
                chars[index++] = s.charAt(row);
                row += first;
                if(row >= s.length()) break;
                chars[index++] = s.charAt(row);
                row += second;
            }
        }

        int start = numRows/2;
        //中间一行
        if((numRows & 1) == 1){
            ++start;
            row = numRows/2;
            first = numRows - 1;
            while (row < s.length()){
                chars[index++] = s.charAt(row);
                row += first;
            }
        }

        //
        for (int i = start; i < numRows-1 ; ++i) {
            row = i;
            first = (numRows - 1 - i)*2;
            second = i*2;
            while (row < s.length()){
                chars[index++] = s.charAt(row);
                row += first;
                if(row >= s.length()) break;
                chars[index++] = s.charAt(row);
                row += second;
            }
        }

        //最后一行
        first = (numRows - 1)*2;
        row = numRows - 1;
        while (row < s.length()){
            chars[index++] = s.charAt(row);
            row += first;
        }

        return new String(chars);
    }
}
