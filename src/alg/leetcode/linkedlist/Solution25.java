package alg.leetcode.linkedlist;

public class Solution25 {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode groupPre = dummy;
        ListNode groupNext = head;

        while (groupNext != null){
            int i = 0;
            for (; i < k-1; i++) {
                groupNext = groupNext.next;
                if(groupNext == null) break;;
            }
            if (i == k-1) {
                ListNode groupLast = groupNext;
                groupNext = groupNext.next;
                ListNode groupFirst = groupPre.next;

                //single list reverse
                ListNode pre = groupFirst;
                ListNode cur = pre.next;
                for (int j = 0; j < k-1; j++) {
                    ListNode t = cur.next;
                    cur.next = pre;
                    pre = cur;
                    cur = t;
                }
                groupPre.next = groupLast;
                groupFirst.next = groupNext;
                groupPre = groupFirst;
            }
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(3);
        ListNode a3 = new ListNode(4);
        ListNode a4 = new ListNode(5);
        a.next = a1;
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;

        reverseKGroup(a,2);
    }
}
