package linkedList;

import common.ListNode;

/*
    题目：删除排序链表中的重复元素 II
    难度：medium
    给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，
    只留下不同的数字 。返回 已排序的链表 。
    输入：head = [1,2,3,3,4,4,5]
    输出：[1,2,5]
    链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class LC82_DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head){
        //边界值
        if(head == null || head.next == null)   return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        while(curr.next != null && curr.next.next != null){
            if (curr.next.val == curr.next.next.val){
                int x = curr.next.val;
                while(curr.next != null && curr.next.val == x){
                    curr.next = curr.next.next;
                }
            }else{
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}
