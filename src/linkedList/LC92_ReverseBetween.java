package linkedList;

import common.ListNode;
/*
    题目：反转链表II
    难度：medium
    给你单链表的头指针 head 和两个整数left 和 right ，其中left <= right
    请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
    输入：head = [1,2,3,4,5], left = 2, right = 4
    输出：[1,4,3,2,5]
    链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 */
/*
    反转链表的升级版。两种方法：迭代法和递归法
 */
public class LC92_ReverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy, q = dummy;
        int index = 0;
        //找到相应的left和right节点的前驱和后置位置
        while(index + 1 < left){
            p = p.next;
            q = q.next;
            index++;
        }
        while(index <= right){
            q = q.next;
            index++;
        }
        //此时p,q为left和right的前驱和后置节点
        //按照反转链表的迭代方法进行反转
        ListNode prev = q;
        ListNode cur = p.next;
        ListNode next = null;
        while(cur != q){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        p.next = prev;
        return dummy.next;
    }
    //反转链表的前N个节点，递归
    ListNode nextNode = null;
    public ListNode reverseN(ListNode head, int n){
        if(n == 1){
            nextNode = head.next;
            return head;
        }
        ListNode revHead = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = nextNode;
        return revHead;
    }

    public ListNode reverseBetween2(ListNode head, int m, int n){
        if(m == 1){
            return reverseN(head, n);
        }
        head.next = reverseBetween2(head.next, m - 1, n - 1);
        return head;
    }

    public ListNode reverseBetween3 (ListNode head, int m, int n) {
        // write code here
        if(head == null)    return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        ListNode h, t;
        int index = 0;
        //找到区间的前驱节点
        for(int i = 1; i < m; i++){
            p = p.next;
        }
        h = p;
        ListNode cur = h.next;
        t = cur;
        //翻转之后的区间
        ListNode prev = null;
        for(int i = 0; i <= n - m; i++){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        h.next = prev;
        t.next = cur;

        return dummy.next;
    }
}
