package com.jiange2.argorithms.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P22GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        generateParenthesis(n, 0, 0, new char[n * 2], res);
        return res;
    }

    private void generateParenthesis(int n, int left, int right, char[] chars, List<String> res) {

        if (left == n && left == right) {
            res.add(String.copyValueOf(chars));
        }

        if (n - left > 0) {
            chars[left + right] = '(';
            generateParenthesis(n, left + 1, right, chars, res);
        }

        if (right < left) {
            chars[left + right] = ')';
            generateParenthesis(n, left, right + 1, chars, res);
        }

    }
}
