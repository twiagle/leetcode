package alg.leetcode.linkedlist;

import java.util.Objects;
import java.util.PriorityQueue;
import java.util.stream.Stream;
/**
 * 23.merge K sorted list
 * 优先队列（通常用堆实现）需要 O(k) 的空间
 * 每次插入O(logk),总共时间O(Nlogk),k 是链表的数目
 * */
public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0) {
            return null;
        }
        ListNode dummy = new ListNode(-1, null);
        ListNode end = dummy;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);
        Stream.of(lists).filter(Objects::nonNull).forEach(minHeap::offer);

        while (!minHeap.isEmpty()) {
            ListNode t = minHeap.poll();
            end.next = t;
            if (t.next != null) {
                minHeap.offer(t.next);
            }
            end = t;
        }
        return dummy.next;
    }

    static class ListNode{
        int val;
        ListNode next;

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
