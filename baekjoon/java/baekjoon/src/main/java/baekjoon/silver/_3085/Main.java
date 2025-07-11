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

        int max = Integer.MIN_VALUE;
        // 행을 탐색하며, 위 아래 swap을 모두 실행해 가능 값을 찾는다
        for (int i = 0; i < N; i++) {
            int tempCount = 0;
            int tempChar = '\u0000';
            for (int j = 0; j < N; j++) {
                if (board[i][j] == tempChar) {
                    tempCount++;
                } else {
                    tempChar = board[i][j];
                    tempCount = 1;
                }
                max = Math.max(max, tempCount);
            }
            // 위로 변경
            if (i > 0) {
                for (int k = 0; k < N; k++) {
                    // swap
                    tempCount = 0;
                    tempChar = '\u0000';
                    char memory = board[i][k];
                    board[i][k] = board[i - 1][k];
                    for (int j = 0; j < N; j++) {
                        if (board[i][j] == tempChar) {
                            tempCount++;
                        } else {
                            tempChar = board[i][j];
                            tempCount = 1;
                        }
                        max = Math.max(max, tempCount);
                    }
                    board[i][k] = memory;
                }
            }

            // 아래로 변경
            if (i + 1 < N) {
                for (int k = 0; k < N; k++) {
                    tempCount = 0;
                    tempChar = '\u0000';
                    char memory = board[i][k];
                    board[i][k] = board[i + 1][k];
                    for (int j = 0; j < N; j++) {
                        if (board[i][j] == tempChar) {
                            tempCount++;
                        } else {
                            tempChar = board[i][j];
                            tempCount = 1;
                        }
                        max = Math.max(max, tempCount);
                    }
                    board[i][k] = memory;
                }
            }
            // 좌
            for (int k = 0; k < N; k++) {
                tempCount = 0;
                tempChar = '\u0000';
                if (k > 0) {
                    char memory = board[i][k];
                    board[i][k] = board[i][k - 1];
                    board[i][k - 1] = memory;
                    for (int j = 0; j < N; j++) {
                        if (board[i][j] == tempChar) {
                            tempCount++;
                        } else {
                            tempChar = board[i][j];
                            tempCount = 1;
                        }
                        max = Math.max(max, tempCount);
                    }
                    board[i][k - 1] = board[i][k];
                    board[i][k] = memory;
                }
            }

            // 우
            for (int k = 0; k < N; k++) {
                tempCount = 0;
                tempChar = '\u0000';
                if (k + 1 < N) {
                    char memory = board[i][k];
                    board[i][k] = board[i][k + 1];
                    board[i][k+1] = memory;
                    for (int j = 0; j < N; j++) {
                        if (board[i][j] == tempChar) {
                            tempCount++;
                        } else {
                            tempChar = board[i][j];
                            tempCount = 1;
                        }
                        max = Math.max(max, tempCount);
                    }
                    board[i][k+1] = board[i][k];
                    board[i][k] = memory;
                }
            }
        }

        // 열탐색
        for (int i = 0; i < N; i++) {
            int tempCount = 0;
            int tempChar = '\u0000';
            for (int j = 0; j < N; j++) {
                if (board[j][i] == tempChar) {
                    tempCount++;
                } else {
                    tempChar = board[j][i];
                    tempCount = 1;
                }
                max = Math.max(max, tempCount);
            }
            // 위로 변경
            if (i > 0) {
                for (int k = 0; k < N; k++) {
                    // swap
                    tempCount = 0;
                    tempChar = '\u0000';
                    char memory = board[k][i];
                    board[k][i] = board[k][i - 1];
                    for (int j = 0; j < N; j++) {
                        if (board[j][i] == tempChar) {
                            tempCount++;
                        } else {
                            tempChar = board[j][i];
                            tempCount = 1;
                        }
                        max = Math.max(max, tempCount);
                    }
                    board[k][i] = memory;
                }
            }

            // 아래로 변경
            if (i + 1 < N) {
                for (int k = 0; k < N; k++) {
                    tempCount = 0;
                    tempChar = '\u0000';
                    char memory = board[k][i];
                    board[k][i] = board[k][i + 1];
                    for (int j = 0; j < N; j++) {
                        if (board[j][i] == tempChar) {
                            tempCount++;
                        } else {
                            tempChar = board[j][i];
                            tempCount = 1;
                        }
                        max = Math.max(max, tempCount);
                    }
                    board[k][i] = memory;
                }
            }

            // 상 변경
            for (int k = 0; k < N; k++) {
                tempCount = 0;
                tempChar = '\u0000';
                if (k > 0) {
                    char memory = board[k][i];
                    board[k][i] = board[k - 1][i];
                    board[k - 1][i] = memory;
                    for (int j = 0; j < N; j++) {
                        if (board[j][i] == tempChar) {
                            tempCount++;
                        } else {
                            tempChar = board[j][i];
                            tempCount = 1;
                        }
                        max = Math.max(max, tempCount);
                    }
                    board[k-1][i] = board[k][i];
                    board[k][i] = memory;
                }
            }

            // 하 변경
            for (int k = 0; k < N; k++) {
                tempCount = 0;
                tempChar = '\u0000';
                if (k + 1 < N) {
                    char memory = board[k][i];
                    board[k][i] = board[k + 1][i];
                    board[k+1][i] = memory;
                    for (int j = 0; j < N; j++) {
                        if (board[j][i] == tempChar) {
                            tempCount++;
                        } else {
                            tempChar = board[j][i];
                            tempCount = 1;
                        }
                        max = Math.max(max, tempCount);
                    }
                    board[k+1][i] = board[k][i];
                    board[k][i] = memory;
                }
            }
        }

        System.out.println(max);
    }
}
