package linkedList;

import common.ListNode;

/*
    ⭐⭐⭐
    题目：排序链表
    难度：medium
    给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
    时间复杂度O(logN)
    链接：https://leetcode-cn.com/problems/sort-list/
 */
/*
    解题的关键有两个部分：
    1、如何找到链表的中间节点
    2、如何将链表断开
 */
public class LC148_SortList {
    public ListNode sortList(ListNode head) {
        return mergeSort(head,null);

    }
    public ListNode mergeSort(ListNode head,ListNode tail){
        if(head == null){
            return head;
        }
        //-------关键点2---------
        //当节点元素个数为1个时，与其后继节点断开
        if(head.next == tail){
            head.next = null;
            return head;
        }
        //-------关键点1----------
        //寻找链表的中点
        ListNode slow = head, fast = head;
        while(fast != tail && fast.next != tail){
            slow = slow.next;
            fast = fast.next.next;
        }
        //slow此时为中点
        ListNode mid = slow;
        ListNode head1 = mergeSort(head,mid); // [head,mid)
        ListNode head2 = mergeSort(mid,tail);//[mid,tail)
        ListNode sortedHead = merge(head1,head2);
        return sortedHead;
    }
    public ListNode merge(ListNode head1,ListNode head2){
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        ListNode p = head1, q = head2;
        while(p != null && q != null){
            if(p.val < q.val){
                temp.next = p;
                p = p.next;
            }else{
                temp.next = q;
                q = q.next;
            }
            temp = temp.next;
        }
        if(p != null){
            temp.next = p;
        }else if(q != null){
            temp.next = q;
        }
        return dummy.next;
    }

}
