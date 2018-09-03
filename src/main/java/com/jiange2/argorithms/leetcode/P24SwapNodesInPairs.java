package com.jiange2.argorithms.leetcode;

import com.jiange2.struct.ListNode;

public class P24SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode t = new ListNode(-1);
        t.next = head;
        head = t;

        ListNode cur = head, p1 = head.next, p2 = head.next.next, next = p2.next;

        while (true){
            cur.next = p2;
            p2.next = p1;
            p1.next = next;

            if(next == null || next.next == null) break;

            cur = p1;
            p1 = next;
            p2 = next.next;
            next = p2.next;
        }

        return head.next;
    }
}
