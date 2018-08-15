package com.jiange2.argorithms.leetcode;

import java.util.*;

public class P30SubstringwithConcatenationofAllWords {


    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> res = new ArrayList<>();

        if (words.length == 0) {
            return res;
        }

        Map<String, Integer> countMap = new HashMap<>();
        Map<String, Integer> curMap = new HashMap<>();
        int sumLen = 0;
        int len = words[0].length();

        for (String word : words) {
            sumLen += word.length();
            Integer val = countMap.get(word);
            countMap.put(word, val == null ? 1 : val + 1);
        }

        Queue<String> queue = new LinkedList<>();

        for (int i = 0; i < len; i++) {
            int count = 0;
            queue.clear();
            curMap.clear();
            for (int j = i; j <= s.length() - len; j += len) {
                String cur = s.substring(j, j + len);
                if(countMap.containsKey(cur)){
                    queue.offer(cur);
                    ++count;
                    Integer val = curMap.merge(cur, 1, (a, b) -> a + b);
                    while (val > countMap.get(cur)){
                        String t = queue.poll();
                        Integer num = curMap.get(t);
                        curMap.put(t, num - 1);
                        count--;
                        if(cur.equals(t)){
                            break;
                        }
                    }

                    if(count == words.length){
                        res.add(j - sumLen + len);
                        String t = queue.poll();
                        Integer num = curMap.get(t);
                        curMap.put(t, num - 1);
                        count--;
                    }
                }else{
                    count = 0;
                    queue.clear();
                    curMap.clear();
                }
            }
        }

        return res;
    }



}
