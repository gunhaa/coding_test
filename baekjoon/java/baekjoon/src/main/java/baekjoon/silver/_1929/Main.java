package baekjoon.silver._1929;

import java.util.*;
import java.io.*;

public class Main {

    /* s3
소수 구하기
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	256 MB	322614	99938	70234	28.825%
문제
M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다.
(1 ≤ M ≤ N ≤ 1,000,000)
M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.

출력
한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.
    */
    static boolean[] isPrime;
    static int start;
    static int end;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/silver/_1929/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        isPrime = new boolean[end + 1];
        for (int i = 2; i <= end; i++) {
            isPrime[i] = true;
        }

        validatePrime();

        StringBuilder result = new StringBuilder();
        for (int i = start; i <= end; i++) {
            if (isPrime[i]) {
                result.append(i).append("\n");
            }
        }

        System.out.println(result);
    }

    static void validatePrime() {
        for (int i = 2; i <= Math.sqrt(end); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= end; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

}
