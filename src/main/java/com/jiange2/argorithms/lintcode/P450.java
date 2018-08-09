package com.jiange2.argorithms.lintcode;

import org.junit.Test;

public class P450 {

    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }


    public ListNode reverseKGroup(ListNode head, int k) {
        // write your code here
        ListNode[] nodes = new ListNode[k];
        ListNode preTail = head,cur = head;
        boolean isFirst = true,over = false;

        while (cur != null){
            for (int i = 0; i < k; i++) {
                if(cur != null){
                    nodes[i] = cur;
                    cur = cur.next;
                }else{
                    if(!isFirst){
                        preTail.next = nodes[0];
                    }
                    over = true;
                    break;
                }
            }

            if(over) break;

            for (int i = k-1; i > 0; i--) {
                nodes[i].next = nodes[i-1];
            }

            nodes[0].next = null;

            if(isFirst){
              head = nodes[k-1];
              isFirst = false;
            }else{
                preTail.next = nodes[k-1];
                preTail = nodes[0];
            }
        }

        return head;
    }

    @Test
    public void test(){
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = buildLink(arr);
        printLink(head);
        head = reverseKGroup(head,6);
        printLink(head);
    }

    private ListNode buildLink(int[] arr){
        ListNode head = new ListNode(arr[0]),cur = head;

        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }

        return head;
    }

    private void printLink(ListNode head){
        while (head != null){
            System.out.print(head.val + ", ");
            head = head.next;
        }

        System.out.println();
    }
}
