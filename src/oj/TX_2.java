package oj;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class TX_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Deque<Integer> first = new ArrayDeque<>();
        Deque<Integer> second = new ArrayDeque<>();

        for(int i = 0; i < n; i++){
            String s;
            s = sc.nextLine();
            if (s.startsWith("add")) {
                int num = Integer.parseInt(s.split(" ")[1]);
                first.push(num);
            } else if (s.startsWith("poll")) {
                if (!second.isEmpty()) {
                    second.poll();
                }
                while (!first.isEmpty()) {
                    second.push(first.pop());
                }
                second.poll();
                while (!second.isEmpty()) {
                    first.push(second.pop());
                }

            } else if (s.startsWith("peek")) {

                if (!second.isEmpty()) {
                    System.out.println(second.peek());
                }
                while (!first.isEmpty()) {
                    second.push(first.pop());
                }
                System.out.println(second.peek());
                while (!second.isEmpty()) {
                    first.push(second.pop());
                }
            }
        }
    }

}
