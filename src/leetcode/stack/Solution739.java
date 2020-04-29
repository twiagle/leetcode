package leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * monotonous stack
 */
public class Solution739 {
    public static int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i=0;i<T.length;i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peekFirst()]) {
                int t =  stack.peekFirst();
                result[stack.pop()] = i-t;
            }
            stack.push(i);
        }


        return result;
    }

    public static void main(String[] args) {
        dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});


    }
}
