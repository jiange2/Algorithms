package com.jiange2.argorithms.leetcode;

import com.jiange2.struct.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class P23MergekSortedLists {

    public ListNode mergeKLists(ListNode[] lists){
        if(lists.length == 0){
            return null;
        }
        ListNode head = new ListNode(0);
        Heap heap = new Heap(lists.length);
        for(ListNode node : lists){
            if(node != null){
                heap.push(node);
            }
        }
        ListNode cur = head;
        while (!heap.empty()){
            cur.next = heap.pop();
            cur = cur.next;
            if(cur != null && cur.next != null){
                heap.push(cur.next);
                cur.next = null;
            }
        }

        return head.next;
    }

    static class Heap {

        private ListNode[] elements;
        private int size = 0;

        public Heap(int maxSize) {
            elements = new ListNode[maxSize];
        }

        public void push(ListNode node) {
            elements[size] = node;
            ++size;
            fixUp();
        }

        public ListNode pop() {
            ListNode res = elements[0];
            elements[0] = elements[size - 1];
            elements[size - 1] = null;
            --size;
            fixDown();
            return res;
        }

        private void fixUp() {
            int cur = size - 1;
            int up = (cur + 1) / 2 - 1;
            while (cur > 0 && elements[cur].val < elements[up].val) {
                swap(cur, up);
                cur = up;
                up = (cur + 1) / 2 - 1;
            }
        }

        private void fixDown() {
            int cur = 0;
            while (cur * 2 + 1 < size) {
                int left = cur * 2 + 1;
                int right = cur * 2 + 2;
                if(right < size && elements[right].val < elements[left].val){
                    left = right;
                }
                if(elements[left].val < elements[cur].val){
                    swap(cur,left);
                }else{
                    return;
                }
                cur = left;
            }
        }

        public boolean empty(){
            return size == 0;
        }

        private void swap(int i, int j) {
            ListNode t = elements[i];
            elements[i] = elements[j];
            elements[j] = t;
        }
    }


    @Test
    public void testHeap() throws Exception{
        Heap h = new Heap(10);
        for (int i = 0; i < 10; i++) {
            ListNode node = new ListNode((int) (Math.random() * 10));
            h.push(node);
        }
        System.out.println(Arrays.toString(h.elements));
        while (!h.empty()){
            System.out.print(h.pop() + ", ");
        }
    }
}
