package linkedList;

import common.ListNode;
import java.util.PriorityQueue;

/*
    题目：合并K个升序链表
    难度：hard
    给你一个链表数组，每个链表都已经按升序排列。
    请你将所有链表合并到一个升序链表中，返回合并后的链表。
    链接：https://leetcode-cn.com/problems/merge-k-sorted-lists/
 */
/*
    解题思路：利用一个最小堆维持链表顶点的最小值
 */
public class LC23_MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> (a.val - b.val));
        for(ListNode node : lists){
            if(node != null){
                minHeap.offer(node);
            }
        }
        while(!minHeap.isEmpty()){
            ListNode node = minHeap.poll();
            p.next = node;
            p = p.next;
            if(node.next != null){
                minHeap.offer(node.next);
            }
        }
        return dummy.next;
    }
}
