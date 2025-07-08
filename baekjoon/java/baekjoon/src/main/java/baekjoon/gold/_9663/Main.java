package baekjoon.gold._9663;

import java.util.*;
import java.io.*;

public class Main {

    /* g4
    N-Queen
    시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
    10 초	128 MB	140118	68162	43677	46.964%
    문제
    N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.

    N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.

    입력
    첫째 줄에 N이 주어진다. (1 ≤ N < 15)

    출력
    첫째 줄에 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수를 출력한다.
    */

    static int N;
    static int[] board;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/gold/_9663/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N];
        back(0);

        System.out.println(count);
    }

    static void back(int row) {

        if (row == N) {
//            System.out.println(Arrays.toString(board));
            count++;
            return;
        }

        for (int col = 0; col < N; col++) {
            board[row] = col;
            if (isQueen(row)) {
//                System.out.println("row: " + row + ", col: " + col);
//                System.out.println(Arrays.toString(board));
                back(row + 1);
            }
        }
    }

    static boolean isQueen(int row) {
//        System.out.println(Arrays.toString(board));
        for (int i = 0; i < row; i++) {
            if (board[row] == board[i]) {
                return false;
                // 해당 코드의 원리는 피타고라스 원리의 직각 삼각형을 생각하면 쉬움
                // 대각선에 있는지 x의 좌표, y의 좌표끼리 연산(-)를 통해 구하는 조건문
            } else if (Math.abs(row - i) == Math.abs(board[row] - board[i])) {
                return false;
            }
        }
        return true;
    }
}
