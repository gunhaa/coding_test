package baekjoon.silver._3085;

import java.util.*;
import java.io.*;

public class Main {
    /* s2
    사탕 게임 다국어
    시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
    1 초	128 MB	56605	20458	14016	34.844%
    문제
    상근이는 어렸을 적에 "봄보니 (Bomboni)" 게임을 즐겨했다.

    가장 처음에 N×N크기에 사탕을 채워 놓는다. 사탕의 색은 모두 같지 않을 수도 있다.
    상근이는 사탕의 색이 다른 인접한 두 칸을 고른다. 그 다음 고른 칸에 들어있는 사탕을 서로 교환한다.
    이제, 모두 같은 색으로 이루어져 있는 가장 긴 연속 부분(행 또는 열)을 고른 다음 그 사탕을 모두 먹는다.
    사탕이 채워진 상태가 주어졌을 때, 상근이가 먹을 수 있는 사탕의 최대 개수를 구하는 프로그램을 작성하시오.

    입력
    첫째 줄에 보드의 크기 N이 주어진다. (3 ≤ N ≤ 50)
    다음 N개 줄에는 보드에 채워져 있는 사탕의 색상이 주어진다. 빨간색은 C, 파란색은 P, 초록색은 Z, 노란색은 Y로 주어진다.
    사탕의 색이 다른 인접한 두 칸이 존재하는 입력만 주어진다.

    출력
    첫째 줄에 상근이가 먹을 수 있는 사탕의 최대 개수를 출력한다.
    */
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/silver/_3085/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] board = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = line.charAt(j);
            }
        }
        System.out.println(Arrays.deepToString(board));

        // 1. 최대 길이를 찾고
        // 1.1 모든걸 다 찾아서 최대 길이가 가능한 것 끼리 리스트 만들고, 그 것들을 +1이 가능한지 탐색한다, 모두 탐색해서 안되면 그대로, 되면 +1
        // 2. +1이 될 가능성이 있는지를 탐색한다
        // 3. 만족하면 종료하고 최대개수를 출력한다

        // 행 탐색
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            char tempChar = '\u0000';
            int tempCount = 0;
            for (int j = 0; j < N; j++) {
                if (tempChar == board[i][j]) {
                    tempCount++;
                } else {
                    max = Math.max(tempCount, max);
                    if (max == tempCount) {

                        // +1이 가능한지 점검
                        // 현재 idx j, 길이 tempCount
                        // 현 idx의 위 아래 바꿔서 tempChar이 가능한지 탐색
                        // 마지막 이라면 무조건 탐색, 바뀌어도 탐색
                        int headIdx = j - tempCount - 1;
                        int tailIdx = j;
                        // 함수로 early return을 통한 최적화 가능
                        if (headIdx >= 0) {
                            if (i - 1 >= 0) {
                                // 위가 존재하며 바꿀시 연속된 수와 같다면
                                if (board[i - 1][j] == tempChar) {
                                    max = Math.max(max, tempCount + 1);
                                }
                            }

                            if (i + 1 < N) {
                                // 아래가 존재하며 바꿀시 연속된 수와 같다면
                                if (board[i + 1][j] == tempChar) {
                                    max = Math.max(max, tempCount + 1);
                                }
                            }
                        }

                        if (i - 1 >= 0) {
                            // 위가 존재하며 바꿀시 연속된 수와 같다면
                            if (board[i - 1][tailIdx] == tempChar) {
                                max = Math.max(max, tempCount + 1);
                            }
                        }

                        if (i + 1 < N) {
                            // 아래가 존재하며 바꿀시 연속된 수와 같다면
                            if (board[i + 1][tailIdx] == tempChar) {
                                max = Math.max(max, tempCount + 1);
                            }
                        }
                    }
                    tempChar = board[i][j];
                    tempCount = 1;
                }

            }
        }

        // 열 탐색
        for (int i = 0; i < N; i++) {
            Map<Character, Integer> countMap = new HashMap<>();
            for (int j = 0; j < N; j++) {
                countMap.put(board[j][i], countMap.getOrDefault(board[i][j], 0) + 1);
            }
            for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
                max = Math.max(max, entry.getValue());
            }
        }
    }
}
