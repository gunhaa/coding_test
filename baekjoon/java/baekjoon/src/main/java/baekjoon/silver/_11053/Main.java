package baekjoon.silver._11053;

import java.util.*;
import java.io.*;

public class Main {
    /* s2
    가장 긴 증가하는 부분 수열
    시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
    1 초	256 MB	198093	80817	53589	38.597%
    문제
    수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.

    예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에
     가장 긴 증가하는 부분 수열은 A = {10, 20, 10, 30, 20, 50} 이고, 길이는 4이다.

    입력
    첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000)이 주어진다.

    둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ Ai ≤ 1,000)

    출력
    첫째 줄에 수열 A의 가장 긴 증가하는 부분 수열의 길이를 출력한다.
    */

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/silver/_11053/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int iter = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] seq = new int[iter];
        int[] memo = new int[iter];

        for (int i = 0; i < iter; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < seq.length; i++) {
            memo[i] = 1;
            for (int j = 0; j < i; j++) {
                // j번째 원소가 i번째 원소보다 작다 && i번째 dp가 j번째 dp+1 값보다 작다
                if(seq[j] < seq[i] && memo[j] + 1 > memo[i]) {
                    memo[i] = memo[j] + 1;
                }
            }
        }

//        System.out.println(Arrays.toString(memo));
//        System.out.println(memo[memo.length-1]);
        int max = 0;
        for (int len : memo) {
            max = Math.max(max, len);
        }
        System.out.println(max);
    }
}
