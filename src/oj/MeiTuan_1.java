package oj;

import java.util.*;

public class MeiTuan_1 {
    static class Node{
        int min;
        int minOrder;
        int max;
        int maxOrder;

        Node(int order, int x){
            min = max = x;
            minOrder = maxOrder = order;
        }
    }

    public static void setFlag(int order, int x, Map<Integer, Node> xArray) {

        if (xArray.containsKey(x)) {

            Node t = xArray.get(x);
            if (x < xArray.get(x).min) {
                t.min = x;
                t.minOrder = order;
            }
            if(x > xArray.get(x).max){
                t.max = x;
                t.maxOrder = order;
            }
        }else {
            xArray.put(x, new Node(order,x));
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<Integer, Node> xArray = new HashMap<>();//min[0], max[1]
        Map<Integer, Node> yArray = new HashMap<>();


        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            setFlag(i, x, yArray);
            setFlag(i, y, xArray);

        }

        Set<Integer> set = new HashSet<>();
        for (Node t : xArray.values() ) {
            set.add(t.maxOrder);
            set.add(t.minOrder);
        }
        for (Node t : yArray.values() ) {
            set.add(t.maxOrder);
            set.add(t.minOrder);
        }
        int res=0;
        for (int i = 0; i < n; i++) {
            if (set.contains(i)) {
                res++;
            }
        }
        System.out.println(n-res);
    }
}
