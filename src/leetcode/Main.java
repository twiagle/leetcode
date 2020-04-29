package leetcode;

import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Integer[][] intArray = {{1, 2, 3, 4, 5},{1,2,3,4,5}};

        // 1. Arrays.stream -> IntStream
        Stream<Integer[]> intStream1 = Arrays.stream(intArray);
        intStream1.flatMap(Stream::of).forEach(System.out::println);
        // 2. Stream.of -> Stream<int[]>
        Stream<Integer[]> temp = Stream.of(intArray);

        // Cant print Stream<int[]> directly, convert / flat it to IntStream
        temp.forEach(x -> System.out.println(x));
    }
}
