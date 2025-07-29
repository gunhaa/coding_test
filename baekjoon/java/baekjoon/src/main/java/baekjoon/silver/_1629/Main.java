package baekjoon.silver._1629;

import java.util.*;
import java.io.*;

public class Main {
    /* s1
곱셈
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
0.5 초 (추가 시간 없음)	128 MB	159142	46285	33499	28.036%
문제
자연수 A를 B번 곱한 수를 알고 싶다. 단 구하려는 수가 매우 커질 수 있으므로 이를 C로 나눈 나머지를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 A, B, C가 빈 칸을 사이에 두고 순서대로 주어진다. A, B, C는 모두 2,147,483,647 이하의 자연수이다.

출력
첫째 줄에 A를 B번 곱한 수를 C로 나눈 나머지를 출력한다.
    */
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/silver/_1629/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        long result = fastPowR(A, B, C);
        System.out.println(result);
    }

    static long fastPowR(long base, long exponent, long modulus) {

        if (exponent == 1) {
            return base % modulus;
        }

        long tempResult = fastPowR(base, exponent / 2, modulus);

        if (exponent % 2 == 1) {
            return (tempResult * tempResult % modulus) * base % modulus;
        }

        return tempResult * tempResult % modulus;
    }
}
