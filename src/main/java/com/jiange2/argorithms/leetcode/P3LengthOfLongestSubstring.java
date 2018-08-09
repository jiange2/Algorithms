package com.jiange2.argorithms.leetcode;


import java.util.HashMap;

public class P3LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        int max = 0;
        int lastIndex = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        Integer t;
        for (int i = 0; i < chars.length; i++) {

            if((t = map.get(chars[i])) != null && t >= lastIndex){
                max = Math.max(max,i - lastIndex);
                lastIndex = t + 1;
            }

            map.put(chars[i],i);
        }

        max = Math.max(max,chars.length  - lastIndex);

        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        int max = 0;
        int lastIndex = 1;
        int[] map = new int[255];
        char[] chars = s.toCharArray();
        int t;
        for (int i = 0; i < chars.length; i++) {
            t = map[chars[i]];
            if(t > 0 && t >= lastIndex){
                max = Math.max(max,i + 1 - lastIndex);
                lastIndex = t + 1;
            }

            map[chars[i]] = i + 1;
        }

        max = Math.max(max,chars.length + 1 - lastIndex);

        return max;
    }
}
