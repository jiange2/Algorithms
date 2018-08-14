package com.jiange2.argorithms.leetcode;

import com.jiange2.struct.Node;

public class P558QuadTreeIntersection {

    public Node intersect(Node quadTree1, Node quadTree2) {
        if (quadTree1.isLeaf) {
            if (quadTree2.isLeaf) {
                return new Node(or(quadTree1, quadTree2), true, null, null, null, null);
            } else if (quadTree1.val) {
                return quadTree1;
            } else {
                return quadTree2;
            }
        } else if (quadTree2.isLeaf) {
            if (quadTree2.val) {
                return quadTree2;
            } else {
                return quadTree1;
            }
        } else {
            Node res = new Node();
            res.isLeaf = false;
            res.topLeft = intersect(quadTree1.topLeft,quadTree2.topLeft);
            res.topRight = intersect(quadTree1.topRight,quadTree2.topRight);
            res.bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
            res.bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);
            if(val(res.topLeft) && val(res.topRight) && val(res.bottomLeft) && val(res.bottomRight)){
                res.topLeft = res.topRight = res.bottomLeft = res.bottomRight = null;
                res.isLeaf = true;
                res.val = true;
            }
            return res;
        }
    }

    private boolean or(Node node1, Node node2) {
        return node1.val || node2.val;
    }

    private boolean val(Node node){
        return node != null && node.isLeaf && node.val;
    }
}
