package oj;

import java.util.Scanner;

public class MeiTuan_2 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextLine()) {
            String s = cin.nextLine();
            StringBuilder tail = new StringBuilder();

            String head = s;
            StringBuilder headOut = new StringBuilder();
            boolean minus = false;

            if (s.charAt(0) == '-') {
                minus = true;
                headOut.append("(");
                head = s.substring(1);
            }
            headOut.append("$");

            int dotIndex = -1;
            if ((dotIndex = head.lastIndexOf('.')) > 0) {
                String t = head.substring(dotIndex);
                if (t.length() >= 3) {
                    tail = new StringBuilder(t.substring(0, 3));
                } else {
                    tail = new StringBuilder(t);
                    tail.append("0");
                }
                head = head.substring(0, dotIndex);
            }else {
                tail.append(".00");
            }
            int len = head.length() % 3;
            headOut.append(head.substring(0, len));
            if(len != 0 && head.length() > 3){
                headOut.append(",");
            }
            for (int i = len; i < head.length(); i = i+3) {
                headOut.append(head.substring(i, i + 3));
                if(i+3 < head.length())
                    headOut.append(",");
            }
            headOut.append(tail);
            if (minus) {
                headOut.append(")");
            }
            System.out.println(headOut.toString());

        }
    }
}
