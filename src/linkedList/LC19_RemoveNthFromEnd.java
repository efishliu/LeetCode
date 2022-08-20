package linkedList;

import common.ListNode;

/*
    题目：删除链表的倒数第 N 个结点
    难度：medium
    给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
    链接：https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 */
public class LC19_RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = head;
        ListNode q = dummy;
        for(int i = 0; i < n; i++){
            p = p.next;
        }
        while(p != null){
            p = p.next;
            q = q.next;
        }
        q.next = q.next.next;
        return dummy.next;
    }
}
