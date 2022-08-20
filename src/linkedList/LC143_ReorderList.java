package linkedList;

import common.ListNode;
/*
    题目：重排链表
    难度：medium
    给定一个单链表 L 的头节点 head ，单链表 L 表示为：
    L0 → L1 → … → Ln - 1 → Ln
    请将其重新排列后变为：
    L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
    不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
    链接：https://leetcode.cn/problems/reorder-list
 */
public class LC143_ReorderList {
    public void reorderList(ListNode head) {
        if(head == null)    return;
        //找到链表中点
        ListNode midNode = find(head);
        ListNode head1 = head;
        ListNode head2 = midNode.next;
        midNode.next = null;
        //反转后半段
        head2 = reverse(head2);
        //合并两段
        merge(head1, head2);
    }

    public ListNode find(ListNode head){
        ListNode p = head;
        ListNode q = head;
        while(q != null && q.next != null){
            p = p.next;
            q = q.next.next;
        }
        return p;
    }

    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        ListNode next;
        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public void merge(ListNode head1, ListNode head2){
        while(head1 != null && head2 != null){
            ListNode next1 = head1.next;
            ListNode next2 = head2.next;

            head1.next = head2;
            head1 = next1;
            head2.next = head1;
            head2 = next2;

        }
    }
}
