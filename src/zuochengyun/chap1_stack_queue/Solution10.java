package zuochengyun.chap1_stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] t = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int row = t[0], col = t[1];
        int [][] matrix = new  int[row][col];
        for (int i = 0; i < row; i++) {
            matrix[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[] histogram = new int[col];
        int maxArea=0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    histogram[j] = 0;
                }else{
                    histogram[j] += 1;
                }
            }
            int curMax = calculate(histogram);
            maxArea = Math.max(curMax, maxArea);
        }
        System.out.println(maxArea);


    }
    public static int calculate(int[] histogram) {
        int[][] res = new int[histogram.length][2];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        stack.push(0);
        int maxArea = 0;
        //把大于等于的都拿出去，
        for (int i = 1; i < histogram.length; i++) {
            while (stack.size()>1 && histogram[i] <= histogram[stack.peek()]) {
                int pos = stack.pop();
            res[pos][1] = i;
            res[pos][0] = stack.peek();
        }
            stack.push(i);
        }
        while (stack.size()>1) {
            int pos = stack.pop();
            res[pos][1] = histogram.length;
            res[pos][0] = stack.peek();
        }
        for (int i = 0; i < res.length; i++) {
            int curArea = histogram[i] * (res[i][1] - res[i][0] - 1);
            maxArea = Math.max(maxArea, curArea);
        }
        return (maxArea);
    }
}
