package linkedList;

import common.ListNode;

/*
    题目：合并两个有序链表
    难度：easy
    将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

 */
public class LC21_MergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null)    return list2;
        if(list2 == null)    return list1;

        ListNode dummy = new ListNode(0);
        ListNode p = list1;
        ListNode q = list2;
        ListNode t = dummy;
        while(p != null && q != null){
            if(p.val < q.val){
                t.next = p;
                p = p.next;
            }else{
                t.next = q;
                q = q.next;
            }
            t = t.next;
        }
        if(p != null){
            t.next = p;
        }
        if(q != null){
            t.next = q;
        }
        return dummy.next;
    }
}
