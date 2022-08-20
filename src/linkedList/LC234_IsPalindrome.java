package linkedList;

import common.ListNode;

import java.util.ArrayList;
import java.util.List;

/*
    题目：回文链表
    难度：easy
    给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 */
public class LC234_IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }

        List<Integer> res = new ArrayList<>();
        ListNode p = head;
        while(p != null){
            res.add(p.val);
            p = p.next;
        }

        for(int i = 0, j = res.size() - 1; i < j; i++, j--){
            if(res.get(i) != res.get(j)){
                return false;
            }
        }
        return true;
    }
    //采用快慢指针
    public boolean isPalindrome2(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode fast = head, slow = head;
        ListNode cur = slow, prev = null;

        while(fast != null && fast.next != null){
            cur = slow;

            slow = slow.next;
            fast = fast.next.next;

            //reverse
            cur.next = prev;
            prev = cur;
        }
        //如果是奇数，还需下移
        if(fast != null){
            slow = slow.next;
        }
        //prev为前一段起点，slow为后一段起点
        ListNode p = prev, q = slow;
        while(p != null && q != null){
            if(p.val != q.val){
                return false;
            }
            p = p.next;
            q = q.next;
        }
        return true;
    }
}
