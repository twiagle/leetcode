package zuochengyun.chap1_stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;

public class Solution5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        Deque<Integer> stack =
            Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .boxed().collect(Collectors.toCollection(ArrayDeque::new));
        Deque<Integer> help = new ArrayDeque<>();

        while (!stack.isEmpty()) {
            int t = stack.pollFirst();
            while (!help.isEmpty() && help.peekFirst() < t) {
                stack.offerFirst(help.pollFirst());
            }
            help.offerFirst(t);
        }
        while (!help.isEmpty()) {
            stack.offerFirst(help.pollFirst());
        }
        stack.stream().map(i -> String.valueOf(i) + " ").forEach(System.out::print);
    }
}
