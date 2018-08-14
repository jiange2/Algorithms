package com.jiange2.argorithms.leetcode;

import java.util.*;

public class P20ValidParentheses {

    private static Set<Character> START_CHAR_SET;
    private static Map<Character,Character> END_CHAR_MAP;

    static {
        START_CHAR_SET = new HashSet<>(3);
        END_CHAR_MAP = new HashMap<>(3);
        START_CHAR_SET.add('(');
        START_CHAR_SET.add('[');
        START_CHAR_SET.add('{');
        END_CHAR_MAP.put(')','(');
        END_CHAR_MAP.put(']','[');
        END_CHAR_MAP.put('}','{');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(START_CHAR_SET.contains(c)){
                stack.push(c);
            }else if(END_CHAR_MAP.containsKey(c)){
                if(stack.empty()){
                    return false;
                }else{
                    Character startChar = stack.pop();
                    Character endChar = END_CHAR_MAP.get(c);
                    if(!startChar.equals(endChar)){
                        return false;
                    }
                }
            }
        }

        return stack.empty();
    }
}
