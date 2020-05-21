package oj;

import java.util.ArrayDeque;
import java.util.Deque;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;

/**
 * 无语了，80%是因为没有用BufferedReader
 */
public class TX_2{
    public static void pushToPoll(Deque<Integer> push,Deque<Integer> pop){
        if (pop.isEmpty()) {
            while (!push.isEmpty()) {
                pop.offerLast(push.pollLast());
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        Deque<Integer> first = new ArrayDeque<>();
        Deque<Integer> second = new ArrayDeque<>();

        for(int i = 0; i < n; i++){
            String s;
            s = sc.readLine();
            if (s.startsWith("add")) {
                int num = Integer.parseInt(s.split(" ")[1]);
                first.offerLast(num);
            } else if (s.startsWith("poll")) {
                pushToPoll(first,second);
                second.pollLast();
            } else if (s.startsWith("peek")) {
                pushToPoll(first,second);
                System.out.println(second.peekLast());
            }
        }
    }
}