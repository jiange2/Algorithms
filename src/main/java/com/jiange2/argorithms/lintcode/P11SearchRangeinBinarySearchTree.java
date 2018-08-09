package com.jiange2.argorithms.lintcode;

import java.util.ArrayList;
import java.util.List;

public class P11SearchRangeinBinarySearchTree {

    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        List<Integer> list = new ArrayList<>();
        search(root,k1,k2,list);
        return list;
    }

    private void search(TreeNode root, int k1, int k2,List<Integer> list){
        if(root == null)
            return;

        if(k1 < root.val)
            search(root.left,k1,k2,list);

        if(root.val >= k1 && root.val <= k2)
            list.add(root.val);

        if(k2 > root.val)
            search(root.right,k1,k2,list);
    }

    public class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
}
