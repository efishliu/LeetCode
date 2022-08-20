package dataStruct;
/*
    题目：LRU缓存
    难度：medium
    请你设计并实现一个满足 LRU (最近最少使用) 缓存 约束的数据结构。
    实现 LRUCache 类：
        LRUCache(int capacity) 以 正整数 作为容量capacity 初始化 LRU 缓存
        int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
        void put(int key, int value)如果关键字key 已经存在，则变更其数据值value ；如果不存在，则向缓存中插入该组key-value 。
        如果插入操作导致关键字数量超过capacity ，则应该 逐出 最久未使用的关键字。
    函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
    链接：https://leetcode-cn.com/problems/lru-cache

 */
import java.util.HashMap;
import java.util.Map;

public class LC146_LRUCache {
    private class ListNode{
        int key;
        int val;
        ListNode prev;
        ListNode next;
        ListNode(){}
        ListNode(int key,int val){
            this.key = key;
            this.val = val;
        }
    }
    private int capacity;
    private int size;
    Map<Integer,ListNode> map = new HashMap<>();
    ListNode head = new ListNode();
    ListNode tail = new ListNode();
    public LC146_LRUCache(int capacity) {
        this.capacity  = capacity;
        size = 0;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        ListNode node = map.get(key);
        if(node == null){
            // not found
            return -1;
        }else{
            removeNode(node);
            addHead(node);
            return node.val;
        }
    }

    public void put(int key, int value) {
        ListNode node = map.get(key);
        if(node == null){
            node = new ListNode(key,value);
            map.put(key,node);
            size++;
            addHead(node);
            if(size > capacity){
                //删除尾节点
                ListNode t = removeTail();
                map.remove(t.key);
                size--;
            }
        }else{
            node.val = value;
            removeNode(node);
            addHead(node);
        }
    }
    private void removeNode(ListNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private void addHead(ListNode node){
        head.next.prev = node;
        node.next = head.next;
        head.next = node;
        node.prev = head;
    }
    private ListNode removeTail(){
        ListNode t = tail.prev;
        removeNode(t);
        return t;
    }
}
