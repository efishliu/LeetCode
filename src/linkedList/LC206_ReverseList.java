package linkedList;

import common.ListNode;

/*
    题目：反转链表
    难度：easy
    给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
    输入：head = [1,2,3,4,5]
    输出：[5,4,3,2,1]
    链接：https://leetcode-cn.com/problems/reverse-linked-list/
 */
/*
    方法一：迭代法

 */
public class LC206_ReverseList {
    //迭代法，类似于头插法
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        while(cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    //递归法
    public ListNode reverseList2(ListNode head) {
        //head为空直接返回
        if(head == null)    return head;
        //只有一个节点，不反转，直接返回
        if(head.next == null)   return head;
        //反转head后的节点，返回其反转后的首节点
        ListNode revHead = reverseList(head.next);
        //将head进行连接
        head.next.next = head;
        head.next = null;
        return revHead;
    }

    //反转以head和tail区间的链表 递归
    public ListNode reverse(ListNode head, ListNode tail){
        if(head == null || head == tail)    return head;
        ListNode revHead = reverse(head.next, tail);
        head.next.next = head;
        head.next = null;
        return revHead;
    }

}
