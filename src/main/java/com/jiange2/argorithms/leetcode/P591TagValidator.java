package com.jiange2.argorithms.leetcode;

import java.util.*;

public class P591TagValidator {

    private static final char TAG_START = '<';
    private static final char TAG_END = '>';
    private static final char END_TAG = '/';
    private static final char CDATE_START = '!';

    public boolean isValid(String code) {
        HashMap<String, Integer> map = new HashMap<>();
        char[] codeChars = code.toCharArray();
        Stack<String> stack = new Stack<>();
        char c;

        if (codeChars[0] != TAG_START) {
            return false;
        }

        for (int i = 0; i < codeChars.length; i++) {
            c = codeChars[i];
            if (c == TAG_START) {

                if (i + 1 >= codeChars.length) {
                    return false;
                }

                c = codeChars[i + 1];
                if (c == END_TAG) {
                    String endTag = getTagName(codeChars, i + 2);
                    if (endTag == null) {
                        return false;
                    }
                    if (stack.isEmpty() || !Objects.equals(stack.pop(), endTag)) {
                        return false;
                    }
                    i = i + endTag.length() + 2;
                    if (stack.isEmpty() && i != codeChars.length - 1) {
                        return false;
                    }
                } else if (c == CDATE_START) {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    int index = getCDateEnd(codeChars, i + 2);
                    if (index == -1) {
                        return false;
                    } else {
                        i = index - 1;
                    }
                } else {
                    String tagName = getTagName(codeChars, i + 1);
                    if (tagName == null || "".equals(tagName)) {
                        return false;
                    }
                    map.merge(tagName, 1, (a, b) -> a + b);
                    stack.push(tagName);
                    i = i + tagName.length() + 1;
                }
            }
        }

        return stack.isEmpty();
    }


    private static int getCDateEnd(char[] chars, int pos) {
        if (chars.length - pos < 7|| !"[CDATA[".equals(new String(chars, pos , 7))) {
            return -1;
        }
        char c;
        for (int i = pos + 7; i < chars.length; i++) {
            c = chars[i];
            if (']' == c) {
                if (chars.length - i >= 3 && "]]>".equals(new String(chars, i, 3))) {
                    return i + 2;
                }
            }
        }
        return -1;
    }

    private static String getTagName(char[] chars, int pos) {
        char c;
        for (int i = pos; i < pos + 10 && i < chars.length; i++) {
            c = chars[i];

            if (c == TAG_END) {
                return new String(chars, pos, i - pos);
            } else if (c > 'Z' || c < 'A') {
                return null;
            }
        }


        return null;
    }
}
