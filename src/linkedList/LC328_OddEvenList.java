package linkedList;

import common.ListNode;

/*
    题目：奇偶链表
    难度：medium
    给定单链表的头节点head，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
    第一个节点的索引被认为是 奇数 ， 第二个节点的索引为偶数 ，以此类推。
    请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
    你必须在O(1)的额外空间复杂度和O(n)的时间复杂度下解决这个问题。
    输入: head = [2,1,3,5,6,4,7]
    输出: [2,3,6,7,1,5,4]
    链接：https://leetcode.cn/problems/odd-even-linked-list
 */
public class LC328_OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null)    return head;
        ListNode ji = new ListNode(0);
        ListNode ou = new ListNode(0);
        ListNode p = ji;
        ListNode q = ou;
        ListNode jiPoint = head;
        ListNode ouPoint = head.next;
        while(jiPoint != null && ouPoint != null){
            p.next = jiPoint;
            q.next = ouPoint;
            p = p.next;
            q = q.next;
            if(ouPoint.next == null || ouPoint.next.next == null){
                break;
            }
            jiPoint = jiPoint.next.next;
            ouPoint = ouPoint.next.next;
        }
        //还剩一个奇数
        if(ouPoint.next != null){
            p.next = ouPoint.next;
            p = p.next;
        }
        q.next = null;
        p.next = ou.next;
        return ji.next;
    }
}
