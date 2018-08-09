package com.jiange2.argorithms.lintcode;


public class P24LFUCache {

    private Node[] cache;
    private Node[] queue;
    private int capacity;
    private int size;

    /*
     * @param capacity: An integer
     */
    public P24LFUCache(int capacity) {
        this.cache = new Node[capacity];
        this.queue = new Node[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    class Node {
        int key;
        int val;
        int time = 1;
        int index;
        Node next = null;

        Node(int key, int val, int index) {
            this.key = key;
            this.val = val;
            this.index = index;
        }

        @Override
        public String toString() {
            return key+"";
        }
    }



    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        int index = key % capacity;
        Node p, e = null;
        if ((p = cache[index]) == null) {
            ensureCapacity();
            e = new Node(key, value,size);
            cache[index] = e;
        } else {
            while (p.next != null) {
                //判断每一个元素的key是否和当前key值相等
                if (p.key == key) {
                    e = p;
                    break;
                }
                p = p.next;
            }
            //判断最后一个元素的key
            if(p.key == key){
                e = p;
            }
            //缓存中已有key
            if(e != null){
                e.val = value;
                addCountAndSwap(e);
                return;
            }else{ //缓存中不存在key
                ensureCapacity();
                e = new Node(key,value,size);
                e.next = cache[index];
                cache[index] = e;
            }
        }

        queue[size++] = e;
        addCountAndSwap(e);
    }

    //去掉尾部元素
    private void ensureCapacity() {
        if (this.size == this.capacity) {
            removeNode(queue[size-1]);
            queue[--size] = null;
        }
    }

    private void removeNode(Node node) {
        int index = node.key % capacity;
        Node cur = cache[index];
        if (cur == node) {
            cache[index] = node.next;
        }
        while (cur.next != null) {
            if (cur.next == node) {
                cur.next = node.next;
                return;
            }
            cur = cur.next;
        }
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        return getVal(cache[key % capacity], key);
    }

    private int getVal(Node head, int key) {
        while (head != null) {
            if (key == head.key) {
                addCountAndSwap(head);
                return head.val;
            }
            head = head.next;
        }
        return -1;
    }

    private void addCountAndSwap(Node node) {
        ++node.time;
        int index = node.index;
        while (index > 0 && queue[index].time >= queue[index-1].time){
            --queue[index].index;
            queue[index] = queue[index-1];
            ++queue[index-1].index;
            queue[index-1] = node;
            --index;
        }
    }
}
