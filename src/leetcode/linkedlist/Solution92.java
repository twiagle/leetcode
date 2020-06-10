package leetcode.linkedlist;

import structures.ListNode;

public class Solution92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode save1=null, save2=null, save3=null, save4=null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy, pre=null, next=null;
        int t=0;

        while(t<=n){
            if(t<=m-1){
                if(t==m-1){
                    save1 = cur;
                    save2 = cur.next;
                }
                cur = cur.next;
            }else if(t >= m){
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            if(t==n){
                save3 = pre;
                save4 = cur;
            }
            t++;
        }
        save1.next = save3;
        save2.next = save4;
        return dummy.next;
    }
}
