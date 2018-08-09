package com.jiange2.argorithms.leetcode;


public class P10RegularExpressionMatching {


    public boolean isMatch(String s, String p) {
        return match(s.toCharArray(),p.toCharArray(),0,0);
    }

    public boolean match(char[] str, char[] pattern,int sPos,int pPos){
        if(pPos > pattern.length-1)
            return sPos > str.length - 1;

        boolean flag = false;
        if(sPos > str.length - 1 ){
            if(pPos + 1 < pattern.length && pattern[pPos+1] == '*'){
                flag =  match(str,pattern,sPos,pPos+2);
            } else{
                return false;
            }
        } else if(pattern[pPos] == '.' || str[sPos] == pattern[pPos]){
            if(pPos + 1 < pattern.length && pattern[pPos+1] == '*'){
                flag = match(str,pattern,sPos+1,pPos+2);
                if(!flag){
                    flag = match(str,pattern,sPos+1,pPos);
                }
                if(!flag){
                    flag = match(str,pattern,sPos,pPos+2);
                }
            }else{
                flag = match(str,pattern,sPos+1,pPos+1);
            }
        }else {
            if(pPos + 1 < pattern.length && pattern[pPos+1] == '*'){
                flag = match(str,pattern,sPos,pPos+2);
            }else{
                return false;
            }
        }

        return flag;
    }
}
