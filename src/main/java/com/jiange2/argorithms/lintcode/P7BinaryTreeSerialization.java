package com.jiange2.argorithms.lintcode;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class P7BinaryTreeSerialization {

    @Test
    public void testSerialize(){
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        right.left = new TreeNode(3);
        root.right = right;
        System.out.println(serialize(root));
    }
    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    @Test
    public void testDeserialize(){
        String text = "1#0";
        TreeNode node = deserialize(text);
        System.out.println();
    }

    public String serialize(TreeNode root) {
        if (root == null)
            return null;
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int flag = 0;
        sb.append(root.val);
        TreeNode node;
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (node.left != null) {
                while (flag > 0) {
                    sb.append(" #");
                    --flag;
                }
                queue.offer(node.left);
                sb.append(" ").append(node.left.val);
            } else {
                ++flag;
            }
            if (node.right != null) {
                while (flag > 0) {
                    sb.append(" #");
                    --flag;
                }
                queue.offer(node.right);
                sb.append(" ").append(node.right.val);
            } else {
                ++flag;
            }
        }
        return sb.toString();
    }


    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        if(data == null || "".equals(data))
            return null;
        // write your code here
        String[] arr = data.split(" ");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode head = new TreeNode(Integer.parseInt(arr[0]));
        queue.offer(head);
        TreeNode node;
        for (int i = 1; i < arr.length; ) {
            node = queue.poll();
            if(!"#".equals(arr[i])){
                node.left = new TreeNode(Integer.parseInt(arr[i]));
                queue.offer(node.left);
            }
            ++i;
            if(i < arr.length && !"#".equals(arr[i])){
                node.right = new TreeNode(Integer.parseInt(arr[i]));
                queue.offer(node.right);
            }
            ++i;
        }
        return head;
    }

    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
}
