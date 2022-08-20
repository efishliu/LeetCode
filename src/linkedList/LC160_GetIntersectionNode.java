package linkedList;

import common.ListNode;

/*
    题目：相交链表
    难度：easy
    给你两个单链表的头节点 headA 和 headB ，
    请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
    链接：https://leetcode.cn/problems/intersection-of-two-linked-lists/
 */
public class LC160_GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)    return null;

        ListNode p1 = headA;
        ListNode p2 = headB;
        while(p1 != null || p2 != null){
            if(p1 == p2)    return p1;
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return null;
    }
}
