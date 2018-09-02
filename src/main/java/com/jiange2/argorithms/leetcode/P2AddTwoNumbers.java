package com.jiange2.argorithms.leetcode;


import com.jiange2.struct.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class P2AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode r = new ListNode((l1.val + l2.val) % 10);
        int next = (l1.val + l2.val) / 10;
        ListNode cur = r;
        l1 = l1.next;
        l2 = l2.next;

        while (l1 != null && l2 != null) {
            cur.next = new ListNode((l1.val + l2.val + next) % 10);
            next = (l1.val + l2.val + next) / 10;
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            cur.next = new ListNode((next + l1.val) % 10);
            next = (next + l1.val) / 10;
            l1 = l1.next;
            cur = cur.next;
        }

        while (l2 != null) {
            cur.next = new ListNode((next + l2.val) % 10);
            next = (next + l2.val) / 10;
            l2 = l2.next;
            cur = cur.next;
        }

        if (next > 0) {
            cur.next = new ListNode(next);
        }

        return r;
    }



}