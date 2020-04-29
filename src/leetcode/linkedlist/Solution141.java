package leetcode.linkedlist;

import leetcode.ListNode;

/**
 * 141. linked list cycle
 */
public class Solution141 {
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode fast = head, slow = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }
        return false;
    }

}
