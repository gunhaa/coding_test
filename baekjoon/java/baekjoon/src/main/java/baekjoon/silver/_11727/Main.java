package baekjoon.silver._11727;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    /* s3
    2×n 타일링 2
    시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
    1 초	256 MB	91474	53917	43699	58.344%
    문제
    2×n 직사각형을 1×2, 2×1과 2×2 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.

    아래 그림은 2×17 직사각형을 채운 한가지 예이다.

    입력
    첫째 줄에 n이 주어진다. (1 ≤ n ≤ 1,000)

    출력
    첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.
    */

    static final int cont = 10007;
    static int[] memo;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/silver/_11727/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int width = Integer.parseInt(br.readLine());
        // 2xn = f(n)의 총 방법수는
        // f(n) = f(n-2)*2 + f(n-1)
        memo = new int[width+1];
        memo[0] = 1;
        memo[1] = 1;

        for (int i = 2; i <= width; i++) {
            memo[i] = (memo[i-1] + memo[i-2]*2) % cont;
        }

        System.out.println(Arrays.toString(memo));
        System.out.println(memo[width]);
    }
}
