package baekjoon.sort;

import java.util.Arrays;

public class sort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};

        int[] sortedArr = Arrays.stream(arr).boxed()
                .sorted((a, b) -> a-b)
                .mapToInt(Integer::intValue)
                .toArray();
        System.out.println(Arrays.toString(sortedArr));
    }
}
