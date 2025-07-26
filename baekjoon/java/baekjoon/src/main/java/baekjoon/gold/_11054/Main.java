package baekjoon.gold._11054;

import java.util.*;
import java.io.*;

public class Main {
    /* g4
가장 긴 바이토닉 부분 수열
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	256 MB	64685	33621	26282	51.489%
문제
수열 S가 어떤 수 Sk를 기준으로 S1 < S2 < ... Sk-1 < Sk > Sk+1 > ... SN-1 > SN을 만족한다면, 그 수열을 바이토닉 수열이라고 한다.

예를 들어, {10, 20, 30, 25, 20}과 {10, 20, 30, 40}, {50, 40, 25, 10} 은 바이토닉 수열이지만, {1, 2, 3, 2, 1, 2, 3, 2, 1}과 {10, 20, 30, 40, 20, 30} 은 바이토닉 수열이 아니다.

수열 A가 주어졌을 때, 그 수열의 부분 수열 중 바이토닉 수열이면서 가장 긴 수열의 길이를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 수열 A의 크기 N이 주어지고, 둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ N ≤ 1,000, 1 ≤ Ai ≤ 1,000)

출력
첫째 줄에 수열 A의 부분 수열 중에서 가장 긴 바이토닉 수열의 길이를 출력한다.
    */
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/gold/_11054/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] seq = new int[N];
        int[] dpL = new int[N];
        int[] dpR = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < seq.length; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }


        // 해당 idx까지 증가하는 경우 dpL
        for (int i = 0; i < seq.length; i++) {
            dpL[i] = 1;
            for (int j = 0; j < i; j++) {
                if (seq[j] < seq[i]) {
                    dpL[i] = Math.max(dpL[i], dpL[j] + 1);
                }
            }
        }

        // 해당 idx이후 내려가는 경우 dpR
        for (int i = seq.length - 1; i >= 0; i--) {
            dpR[i] = 1;
            for (int j = seq.length - 1; j > i; j--) {
                if(seq[j] < seq[i]) {
                    dpR[i] = Math.max(dpR[i], dpR[j] +1);
                }
            }
        }


        int result = Integer.MIN_VALUE;
        for (int i = 0; i < dpR.length; i++) {
            result = Math.max(result, dpR[i] + dpL[i] - 1);
        }
        System.out.println(result);

    }
}
