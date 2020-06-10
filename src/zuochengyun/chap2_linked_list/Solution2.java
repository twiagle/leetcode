package zuochengyun.chap2_linked_list;

import structures.ListNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] para =Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int target = para[1];

        ListNode list =null, head=null;
        String[] strs = br.readLine().split(" ");
        for (String str : strs) {
            if("".equals(str)) break;
            if(head == null) {
                head = new ListNode(Integer.parseInt(str));
                list = head;
            }
            else {
                list.next = new ListNode(Integer.parseInt(str));
                list = list.next;
            }
        }
        list = head;

        int t = target;
        if(head == null && target<1) return;
        while (list != null) {
            --t;
            list= list.next;
        }
        if(t>0);
        else if(t==0) head = head.next;
        else{
            list = head;
            while (list != null) {
                ++t;
                if(t==0){
                    list.next = list.next.next;
                    break;
                }
                list= list.next;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val).append(" ");
            head= head.next;
        }
        System.out.println(sb.toString());
    }

}
