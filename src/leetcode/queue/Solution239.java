package leetcode.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 双端队列最常用的地方就是实现一个长度动态变化的窗口或者连续区间
 * 单调队列 每个新值，如果小于已有则插入，如果大于已有则剔除已有，如此保证队首是最大，
 * 由于实时进出队列，所以不要设置临时变量了，修改的太多，队列一变就要改，所以要记清楚队列存放的是index啊
 */
public class Solution239 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k +1];
        List<Integer> resList = new LinkedList<>();
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if((i-deque.peekFirst()) == k){
                deque.pollFirst();
            }
            if (i >= k - 1) {
                resList.add(nums[deque.peekFirst()]);
            }
        }
        int[] ee =  resList.stream().mapToInt(Integer::intValue).toArray();
        return ee;
    }

    public static void main(String[] args) {
        maxSlidingWindow(new int[]{1,-1} , 1);
    }
}