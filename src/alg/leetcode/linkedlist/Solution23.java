package alg.leetcode.linkedlist;

import java.util.Objects;
import java.util.PriorityQueue;
import java.util.stream.Stream;
/**
 * 23.merge K sorted list
 * skill:	priority_queue
 * 优先队列（通常用堆实现）需要 O(k) 的空间
 * 每次插入O(logk),总共时间O(Nlogk),k 是链表的数目
 * 生成最大堆使用o2-o1,生成最小堆使用o1-o2,PriorityQueue支持将Collection类型直接转成 PriorityQueue,PriorityQueue(Collection<? extends E> c)
 * 方法iterator()中提供的迭代器并不保证以有序的方式遍历优先级队列中的元素。
 * */
public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
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

}
