package oj;
/**
 * 文字版队列
 * 笔试时可能犯了多个队列，共用同一个队列了，应该在内部for里new
 * 看了网上AC的代码，可以用ArrayDeque，也就是说不会限制jdk原生工具
 * 最后，nextLine然后自己处理，不要用用nextInt，不读回车。
 * 单次就hasNextLine，多次就计数
 */

import java.util.*;


public class TX_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = Integer.parseInt(scanner.nextLine());

        for(int i = 0; i < r; i++){
            Deque<Integer> queue = new ArrayDeque<>();// new for each time
            int rr = Integer.parseInt(scanner.nextLine());
            for(int j = 0; j <rr; j++){
                String s = scanner.nextLine();
                if(s.startsWith("POP")){
                    if(queue.isEmpty()) {
                        System.out.println(-1);
                    }else{
                        queue.pollFirst();
                    }
                } else if (s.startsWith("TOP")) {
                    if(queue.isEmpty()) {
                        System.out.println(-1);
                    }else{
                        int t = queue.peekFirst();
                        System.out.println(t);
                    }
                } else if (s.startsWith("SIZE")) {
                    System.out.println(queue.size());
                }else if(s.startsWith("CLEAR")){
                    queue.clear();
                }else if (s.startsWith("PUSH")) {
                    int num = Integer.parseInt(s.split(" ")[1]);
                    queue.offerLast(num);
                }
            }
        }
    }
}
//
//import java.util.ArrayDeque;
//import java.util.Queue;
//import java.util.Scanner;
//// t1
//public class TX_1 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int T = Integer.parseInt(in.nextLine());
//        int Q, len, x;
//        String str;
//        String[] arr;
//        Queue<Integer> queue;
//        while (T-- > 0) {
//            Q = Integer.parseInt(in.nextLine());
//            queue = new ArrayDeque<Integer>();
//            while (Q-- > 0) {
//                str = in.nextLine();
//                arr = str.split(" ");
//                len = arr.length;
//                if (len == 1) {
//                    if (arr[0].equals("TOP"))
//                        System.out.println(queue.isEmpty() ? -1 : queue.peek());
//                    else if (arr[0].equals("POP")) {
//                        if (queue.isEmpty())
//                            System.out.println(-1);
//                        else
//                            queue.remove();
//                    } else if (arr[0].equals("SIZE"))
//                        System.out.println(queue.size());
//                    else
//                        queue.clear();
//                } else {
//                    queue.add(Integer.parseInt(arr[1]));
//                }
//            }
//        }
//    }
//}
