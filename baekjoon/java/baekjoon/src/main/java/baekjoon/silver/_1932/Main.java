package baekjoon.silver._1932;

import java.util.*;
import java.io.*;

public class Main {
    /* s1
정수 삼각형 다국어
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	128 MB	110995	66045	50071	60.194%
문제
        7
      3   8
    8   1   0
  2   7   4   4
4   5   2   6   5
위 그림은 크기가 5인 정수 삼각형의 한 모습이다.

맨 위층 7부터 시작해서 아래에 있는 수 중 하나를 선택하여 아래층으로 내려올 때,
이제까지 선택된 수의 합이 최대가 되는 경로를 구하는 프로그램을 작성하라.
아래층에 있는 수는 현재 층에서 선택된 수의 대각선 왼쪽 또는 대각선 오른쪽에 있는 것 중에서만 선택할 수 있다.

삼각형의 크기는 1 이상 500 이하이다. 삼각형을 이루고 있는 각 수는 모두 정수이며, 범위는 0 이상 9999 이하이다.

입력
첫째 줄에 삼각형의 크기 n(1 ≤ n ≤ 500)이 주어지고, 둘째 줄부터 n+1번째 줄까지 정수 삼각형이 주어진다.

출력
첫째 줄에 합이 최대가 되는 경로에 있는 수의 합을 출력한다.
    */
    static int[][] dp;
    static int[][] triangle;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/silver/_1932/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        triangle = new int[N][N];
        dp = new int[N][N];

        int count = 1;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < count; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
            count++;
        }

//        System.out.println(Arrays.deepToString(triangle));

        for (int i = 0; i < N; i++) {
            dp[N-1][i] = triangle[N-1][i];
        }

        int count2 = 1;
        for (int i = N - 2; i >= 0; i--) {
            for (int j = 0; j < N-count2; j++) {
                dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j + 1]) + triangle[i][j];
            }
            count2++;
        }
//        System.out.println(Arrays.deepToString(dp));
        System.out.println(dp[0][0]);
    }
}
