package com.jiange2.argorithms.leetcode;

import com.jiange2.struct.ListNode;

import java.util.Stack;

public class P25ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || head.next == null || k == 1) return head;

        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        head = preHead;

        ListNode left = head, start = head, end, cur;


        Stack<ListNode> stack = new Stack<>();
        cur = start.next;
        while (cur != null) {
            int count = k;
            while (--count >= 0 && cur != null) {
                stack.push(cur);
                cur = cur.next;
            }

            if (count == -1) {
                end = cur;
                while (!stack.isEmpty()){
                    start.next = stack.pop();
                    start = start.next;
                }
                start.next = end;
            }
        }

        return head.next;
    }


}
