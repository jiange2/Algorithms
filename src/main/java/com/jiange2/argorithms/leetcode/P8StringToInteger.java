package com.jiange2.argorithms.leetcode;


public class P8StringToInteger{

    public int myAtoi(String str) {
        if(str == null || "".equals(str))
            return 0;

        long r = 0;
        long time = 1;
        char t;
        boolean flag = false;
        int end = 0;
        int count = 0;
        while (str.charAt(end) == ' '){
            ++end;
        }
        for (int i = str.length() - 1; i >= end; --i) {
            t = str.charAt(i);
            if(t >= '0' && t <= '9'){
                if(count < 12){
                    r += (t - '0') * time;
                    time *= 10;
                    ++count;
                }
            }else if(t == '-'){
                if(flag){
                    return 0;
                }
                r = -r;
                flag = true;
            }else if(t == '+'){
                if(flag){
                    return 0;
                }
                flag = true;
            }else{
                r = 0;
            }
        }

        if(r > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if(r < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }

        return (int) r;
    }
}
