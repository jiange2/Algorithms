package com.jiange2.argorithms.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */
public class P17LetterCombinationsofaPhoneNumber {

    private static final char[][] NUMS = {{'a','b','c'},{'d','e','f'},{'g','h','i'},
            {'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};

    public List<String> letterCombinations(String digits) {
        if(digits == null || "".equals(digits)){
            return new ArrayList<>();
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer("");
        for (int i = 0; i < digits.length(); i++) {
            int index = digits.charAt(i) - '0' - 2;
            char[] chars = NUMS[index];
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String str = queue.poll();
                for(char c : chars){
                    queue.offer(str + c);
                }
            }
        }
        return new ArrayList<>(queue);
    }
}
