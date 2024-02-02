package task02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class HomeWorkFromGB {

    private static final Random random = new Random();
    private static final int SIZE = 5;

    public static void main(String[] args) {

        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            integers.add(random.nextInt(10));
        }
        System.out.print(integers);
        System.out.println();

        double result = integers
                .stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(number -> number)
                .average()
                .orElse(0);
        System.out.println(result);

    }


}
