package baekjoon.gold._9251;

import java.io.*;
import java.util.*;

public class Main {
    /* g5
    LCS
    시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
    0.1 초 (하단 참고)	256 MB	106546	45532	33328	41.980%
    문제
    LCS(Longest Common Subsequence, 최장 공통 부분 수열)문제는 두 수열이 주어졌을 때,
    모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제이다.

    예를 들어, ACAYKP와 CAPCAK의 LCS는 ACAK가 된다.

    입력
    첫째 줄과 둘째 줄에 두 문자열이 주어진다.
    문자열은 알파벳 대문자로만 이루어져 있으며, 최대 1000글자로 이루어져 있다.

    출력
    첫째 줄에 입력으로 주어진 두 문자열의 LCS의 길이를 출력한다.
    */

    static int[][] dp;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/gold/_9251/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] strSeq1 = br.readLine().toCharArray();
        char[] strSeq2 = br.readLine().toCharArray();
        dp = new int[strSeq1.length+1][strSeq2.length+1];

        for (int i = 1; i <= strSeq1.length; i++) {
            for (int j = 1; j <= strSeq2.length; j++) {
                if(strSeq1[i-1] == strSeq2[j-1]) {
                    dp[i][j] = dp[i-1][j-1]+1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[strSeq1.length][strSeq2.length]);
    }
}
