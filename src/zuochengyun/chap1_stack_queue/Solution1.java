package zuochengyun.chap1_stack_queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * 实现一个特殊功能的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。
 */
public class Solution1 {

    static Deque<Integer> stackData = new ArrayDeque<>();
    static Deque<Integer> stackMin = new ArrayDeque<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = Integer.parseInt(scanner.nextLine());
        for(int i=0;i<r;i++) {
            String in = scanner.nextLine();
            if ("getMin".equals(in)) {
                System.out.println(stackMin.peekLast());
            } else if ("pop".equals(in)){
                int t = stackData.pollLast();
                if(t == stackMin.peekLast()){
                    stackMin.pollLast();
                }
            }else{
                int t = Integer.parseInt(in.split(" ")[1]);
                stackData.offerLast(t);
                if (!stackMin.isEmpty()) {
                    if (t <= stackMin.peekLast()) {
                        stackMin.offerLast(t);
                    }
                }else {
                    stackMin.offerLast(t);
                }
            }
        }
    }
}
