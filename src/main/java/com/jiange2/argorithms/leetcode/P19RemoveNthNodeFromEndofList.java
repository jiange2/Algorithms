package com.jiange2.argorithms.leetcode;

import com.jiange2.struct.ListNode;

public class P19RemoveNthNodeFromEndofList {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head == null){
            return null;
        }

        ListNode p1,p2;
        p1 = p2 = head;


        for (int i = 1; i < n; i++) {
            p1 = p1.next;
            if(p1 == null) return null;
        }

        //结果是首节点
        if(p1.next == null){
            head = head.next;
            p2.next = null;
            return head;
        }

        //另p1 和 p2 相差 n+1
        p1 = p1.next;
        while (p1.next != null){
            p2 = p2.next;
            p1 = p1.next;
        }

        ListNode cur = p2.next;
        p2.next = p2.next.next;
        cur.next = null;

        return head;
    }


}
