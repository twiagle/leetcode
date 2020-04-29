package leetcode.linkedlist;

import leetcode.ListNode;

public class Solution24 {

        public ListNode swapPairs(ListNode head) {
            if(head == null) return null;
            ListNode dummy = new ListNode(-1);
            dummy.next = head;//in case of only one element
            ListNode pre = dummy;
            ListNode l = head, r = head.next;

            while (l != null && l.next !=null) {
                r = l.next;
                ListNode next = r.next;

                l.next = next;
                r.next = l;

                pre.next = r;//before exchange r now is at left
                pre = l;//before exchange l now is at right
                l = next;
            }
            return dummy.next;
        }


}
