package linkedList;

import common.ListNode;

/*
    题目：K个一组翻转链表
    难度：hard
    给你一个链表，每k个节点一组进行翻转，请你返回翻转后的链表。
    k是一个正整数，它的值小于或等于链表的长度。
    如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
    进阶：
        你可以设计一个只使用常数额外空间的算法来解决此问题吗？
        你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
    链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
    输入：head = [1,2,3,4,5], k = 2
    输出：[2,1,4,3,5]
 */
/*
    解题思路：模拟（自己做出）
    1.以head为头节点，寻找长度为k的尾节点，若存在返回tail，否则返回null
    2.反转以head和tail区间内的链表
    3.连接反转后的链表
 */
public class LC25_ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevTail = dummy;
        ListNode p = head;
        while(p != null){
            ListNode curHead = prevTail.next;
            ListNode curTail = findTail(curHead, k);
            if(curTail == null) break;
            ListNode nextHead = curTail.next;
            reverse(curHead, curTail);
            prevTail.next = curTail;
            curHead.next = nextHead;
            prevTail = curHead;
        }
        return dummy.next;

    }
    //以head为起始点，寻找k个节点的尾节点，若小于k，则返回null
    public ListNode findTail(ListNode head, int k){
        if(head == null)    return head;
        for(int i = 0; i < k - 1; i++){
            if(head.next != null)
                head = head.next;
            else
                return null;
        }
        return head;
    }

    //反转以head和tail区间的链表
    public void reverse(ListNode head, ListNode tail){
        ListNode prev = null;
        ListNode cur = head;
        ListNode next;
        while(prev != tail){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
    }
}
