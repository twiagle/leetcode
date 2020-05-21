package zuochengyun.chap1_stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 停止：再大没有用，再小都符合
 */
public class Solution11 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] t = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int num = t[1];
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(getNum(array, num));
    }

    public static int getNum(int[] array, int num) {
        // 排除三种特例：null 空数组[] num小于0
        if (array == null || array.length < 1 || num < 0) {
            return 0;
        }
        int res=0;
        Deque<Integer> qMax = new ArrayDeque<>();
        Deque<Integer> qMin = new ArrayDeque<>();

        for (int i = 0, j=0; i < array.length; i++) {
            //right hand，再小都符合，所以j不用从0开始
            for (; j < array.length; j++) {//同样的j，i大了1在判断
                while (!qMin.isEmpty() && array[qMin.peekLast()] >= array[j]) {
                    qMin.pollLast();
                }
                qMin.offerLast(j);
                while (!qMax.isEmpty() && array[qMax.peekLast()] <= array[j]) {
                    qMax.pollLast();
                }
                qMax.offerLast(j);
                if (array[qMax.peekFirst()] - array[qMin.peekFirst()] > num) {
                    break;//再大没有用
                }
            }
            res += j-i;//以i开头的子数组个数已经处理完毕，只有i右移才会有新的
            if (i == qMax.peekFirst()) {//i不一定是最大或最小
                qMax.pollFirst();
            }
            if (i == qMin.peekFirst()) {//现在i是第8题类似window的作用
                qMin.pollFirst();
            }
        }
        return res;
    }
}
