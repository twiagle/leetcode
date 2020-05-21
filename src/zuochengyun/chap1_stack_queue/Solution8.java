package zuochengyun.chap1_stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution8 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] t = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int window = t[1];
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Integer> res = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(0);
        //队列元素意义：队中前一个过期后，我就是 队中从前一个位置+1 到结尾（当前扫描位置）这个区间的扛把子  [534]2 -> [54],5过期，4就是[342]扛把子
        for (int i = 0; i < arr.length; i++) {
            //维护单调队
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            //队头出了窗口
            if (i-deque.peekFirst() == window){
                deque.pollFirst();
            }
            //从第一个窗口开始  打印
            if (i >= window - 1) {
                res.add(arr[deque.peekFirst()]);
            }
        }

        res.stream().map(i -> String.valueOf(i) + " ").forEach(System.out::print);
    }
}
