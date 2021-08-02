package leetcode;


public class Main {
    public static void main(String[] args) {

        System.out.println(hello());



    }

    static int hello(){

        int i=0;
        try{
            i++;
            return i;
        }finally {
            i++;
        }
    }
}
