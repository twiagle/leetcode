package oj;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TX_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> queue =new LinkedList<>();
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            int m = sc.nextInt();
            sc.nextLine();// /n
            String s;
            for(int j = 0; j < m; j++){
                s = sc.nextLine();
                if (s.equalsIgnoreCase().startsWith("POP")) {
                    if(queue.isEmpty()) {
                        System.out.println(-1);
                    }else{
                        int t = queue.remove(0);
                    }
                } else if (s.startsWith("TOP")) {
                    if(queue.isEmpty()) {
                        System.out.println(-1);
                    }else{
                        int t = queue.get(0);
                        System.out.println(t);
                    }
                } else if (s.startsWith("SIZE")) {
                    System.out.println(queue.size());
                }else{
                    queue.clear();
                }if (s.startsWith("PUSH")) {
                    int num = Integer.parseInt(s.split(" ")[0]);
                    queue.add(num);

                } else
            }
        }
    }
}
