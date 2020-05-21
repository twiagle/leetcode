package zuochengyun.chap1_stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 自顶向下由大到小单调栈
 * 维持
 * 栈中元素左手是第一次小于，右手是第一次大于
 * 需要
 * 新扫描到的元素安排合适位置：单调栈
 */
public class Solution9 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int times = Integer.parseInt(br.readLine());
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] res = new int[array.length][2];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        stack.push(0);
        for (int i = 1; i < array.length; i++) {
            while (stack.size()>1 && array[i] < array[stack.peek()]) {
                int pos = stack.pop();
                res[pos][1] = i;
                res[pos][0] = stack.peek();
            }
            stack.push(i);
        }
        while (stack.size()>1) {
            int pos = stack.pop();
            res[pos][1] = -1;
            res[pos][0] = stack.peek();
        }

        Arrays.stream(res).forEach((a)->{
            System.out.println(a[0] + " " + a[1]);
        });
    }
}
