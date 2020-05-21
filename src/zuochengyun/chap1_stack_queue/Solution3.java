package zuochengyun.chap1_stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;

/**
 * 只能使用一个栈，所以单个递归搞不定，
 * 单个递归：由于最深的要放到最浅的，递归最深是只能把自己放入栈，此时只能放到栈最深处，所以无力
 * 再来一个递归，把之前取到的最深放入栈最浅.第一个递归还得放回去剩下的
 */
public class Solution3 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        ArrayDeque<Integer> stack =
        Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .boxed().collect(Collectors.toCollection(ArrayDeque::new));
        secondRecur(stack);
        stack.stream().map((i)->{
            String t = String.valueOf(i);
            return t + " ";
        }).forEach(System.out::print);
    }


    static int getAndRemoveFirst(Deque<Integer> stack){
        int cur = stack.pollLast();
        if(stack.isEmpty()) return cur;

        int son = getAndRemoveFirst(stack);
        stack.offerLast(cur);//注意push接口ArrayDeque实现的是改变头，我这里改变尾，要注意呀
        return son;
    }

    static void secondRecur(Deque<Integer> stack) {

        if(!stack.isEmpty()){
            int cur = getAndRemoveFirst(stack);
            secondRecur(stack);
            stack.offerLast(cur);
        }
    }
}
