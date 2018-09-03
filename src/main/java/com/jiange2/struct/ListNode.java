package com.jiange2.struct;

import java.util.List;
import java.util.Objects;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int[] vals){
        val = vals[0];
        ListNode cur = this;
        for (int i = 1; i < vals.length; i++) {
            cur.next = new ListNode(vals[i]);
            cur = cur.next;
        }
    }

    public ListNode(List<Integer> vals){
        if(vals == null || vals.size() == 0){
            return;
        }
        val = vals.get(0);
        ListNode cur = this;
        for (int i = 1; i < vals.size(); i++) {
            cur.next = new ListNode(vals.get(i));
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode cur = this;
        while (cur != null){
            sb.append(cur.val).append("->");
            cur = cur.next;
        }
        sb.append("null");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode node = (ListNode) o;
        ListNode self = this;
        while (node != null && self != null){
            if(node.val != self.val) return false;
            node = node.next;
            self = self.next;
        }
        return node == null && self == null;
    }

    @Override
    public int hashCode() {

        return Objects.hash(val, next);
    }
}
