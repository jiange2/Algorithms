package com.jiange2.argorithms.leetcode;

import com.jiange2.struct.ListNode;

public class P21MergeTwoSortedLists {
    //73.03
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode head;
        ListNode cur1 = l1, cur2 = l2;

        if (cur1.val < cur2.val) {
            head = cur1;
            cur1 = cur1.next;
        } else {
            head = cur2;
            cur2 = cur2.next;
        }

        ListNode cur = head;

        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                cur.next = cur1;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }

        if (cur1 != null) {
            cur.next = cur1;
        }
        if (cur2 != null) {
            cur.next = cur2;
        }

        return head;
    }
}
