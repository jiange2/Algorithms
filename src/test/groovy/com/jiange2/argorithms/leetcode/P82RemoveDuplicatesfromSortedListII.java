package com.jiange2.argorithms.leetcode;

import com.jiange2.struct.ListNode;

public class P82RemoveDuplicatesfromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        if (isNullOrSingleNode(head)) {
            return head;
        }

        ListNode cur = new ListNode(-1);
        cur.next = head;
        head = cur;

        ListNode p1 = head, p2 = head.next;



        return head;
    }

    private boolean isNullOrSingleNode(ListNode node){
        return node == null || node.next == null;
    }
}
