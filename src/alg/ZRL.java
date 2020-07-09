package alg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ZRL {
    public static void main(String[] args) throws IOException {
        CycQueue cycQueue = new CycQueue(3);
        long found = 0;
        boolean flag = true;


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (flag) {
            String line = reader.readLine();
            String second;
            switch (line) {
                case "A" :
                    second = reader.readLine();
                    found += Long.parseLong(second);
                    cycQueue.enQueue("deposit "+ second);
                    break;
                case "B" :
                    second = reader.readLine();
                    if (Long.parseLong(second) > found) {
                        System.out.println("balance is not sufficient");
                        break;
                    }
                    found -= Long.parseLong(second);
                    cycQueue.enQueue("with draw "+ second);
                    break;
                case "C":
                    for (int i = 1; i <= cycQueue.queueLength(); i++) {
                        System.out.println(cycQueue.getLastElement(i));
                    }
                    break;
                case "D":
                    flag = false;
                    break;
            }
        }
    }
}
