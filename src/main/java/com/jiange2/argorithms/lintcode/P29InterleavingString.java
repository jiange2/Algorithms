package com.jiange2.argorithms.lintcode;

import org.junit.Test;

public class P29InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {

        if(s1 == null || s2 == null || s3 == null || (s1.length() + s2.length() != s3.length())){
            return false;
        }

        int len1 = s1.length(),len2 = s2.length(),len3 = s3.length(),index1=0,index2=0,index3=0;
        boolean flag1,flag2;
        char t,comLen = 0;

        while (index3 < len3){
            t = s3.charAt(index3++);
            flag1 = index1 < len1 && s1.charAt(index1) == t;
            flag2 = index2 < len2 && s2.charAt(index2) == t;

            if(flag1 && flag2){
                ++index1;
                ++index2;
                ++comLen;
            }else if(flag1){
                index2 -= comLen;
                comLen = 0;
                ++index1;
            }else if(flag2){
                index1 -= comLen;
                comLen = 0;
                ++index2;
            }else{
                if(index1 == len1 && index2 == len2){
                    return true;
                }
                if(comLen > 0){
                    --index3;
                    while(comLen > 0 && s3.charAt(index3++) == s2.charAt(index2 - comLen)){
                        comLen--;
                    }
                    index2 -= comLen;
                }else{
                    return false;
                }
            }
        }

        return true;
    }


    @Test
    public void test(){
        String s1 = "aabc";
        String s2 = "aab";
        String s3 = "aabaacb";
        System.out.println(isInterleave(s1,s2,s3));
    }
}
