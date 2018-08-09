package com.jiange2.argorithms.lintcode;

import org.junit.Test;

public class P8RotateString {
    /**
     * @param str: An array of char
     * @param offset: An integer
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {

        if(str == null)
            return;

        int  n = str.length;
        offset %= n;

        if(offset == 0 || offset == n)
            return;

        if(offset <= n/2){
            int index = 0;
            while (index <= n-offset){
                for (int i = n-offset; i < n; ++i) {
                    swap(str,i,index++);
                }
            }
        }else{
            offset = n - offset;
            int index = n-1;
            while (index >= offset){
                for (int i = offset-1; i >= 0; --i) {
                    swap(str,i,index--);
                }
            }
        }
    }

    private void swap(char[] a,int i, int j){
        char t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    @Test
    public void test(){
        String str = "abcdefg";
        char[] chars = str.toCharArray();
        rotateString(chars,3);
        System.out.println(new String(chars));
    }
}
