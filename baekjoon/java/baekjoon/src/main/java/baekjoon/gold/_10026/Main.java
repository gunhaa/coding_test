package baekjoon.gold._10026;

import java.util.*;
import java.io.*;

public class Main {
    /* g5
    적록색약 다국어
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	128 MB	84250	49228	36929	57.213%
문제
적록색약은 빨간색과 초록색의 차이를 거의 느끼지 못한다. 따라서, 적록색약인 사람이 보는 그림은 아닌 사람이 보는 그림과는 좀 다를 수 있다.

크기가 N×N인 그리드의 각 칸에 R(빨강), G(초록), B(파랑) 중 하나를 색칠한 그림이 있다.
그림은 몇 개의 구역으로 나뉘어져 있는데, 구역은 같은 색으로 이루어져 있다.
또, 같은 색상이 상하좌우로 인접해 있는 경우에 두 글자는 같은 구역에 속한다.
(색상의 차이를 거의 느끼지 못하는 경우도 같은 색상이라 한다)

예를 들어, 그림이 아래와 같은 경우에

RRRBB
GGBBB
BBBRR
BBRRR
RRRRR
적록색약이 아닌 사람이 봤을 때 구역의 수는 총 4개이다. (빨강 2, 파랑 1, 초록 1)
하지만, 적록색약인 사람은 구역을 3개 볼 수 있다. (빨강-초록 2, 파랑 1)

그림이 입력으로 주어졌을 때, 적록색약인 사람이 봤을 때와 아닌 사람이 봤을 때 구역의 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N이 주어진다. (1 ≤ N ≤ 100)
둘째 줄부터 N개 줄에는 그림이 주어진다.

출력
적록색약이 아닌 사람이 봤을 때의 구역의 개수와 적록색약인 사람이 봤을 때의 구역의 수를 공백으로 구분해 출력한다.
    */

    static int N;
    static char[][] grid;
    static boolean[][] visited;
    static int normalResult = 0;
    static int colorResult = 0;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/gold/_10026/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new char[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                grid[i][j] = line[j];
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    normalResult++;
                    dfs(i, j, grid[i][j]);
                }
            }
        }

        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(grid[i][j] == 'G') {
                    grid[i][j] = 'R';
                }
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    colorResult++;
                    dfs(i, j, grid[i][j]);
                }
            }
        }

        System.out.println(normalResult + " " + colorResult);
    }

    static void dfs(int x, int y, char cur) {

        if(x < 0 || x >= N || y < 0 || y >= N || visited[x][y] || cur != grid[x][y]) {
            return;
        }

        visited[x][y] = true;

        dfs(x + 1, y, cur);
        dfs(x - 1, y, cur);
        dfs(x, y + 1, cur);
        dfs(x, y - 1, cur);
    }


}
