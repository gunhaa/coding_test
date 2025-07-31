package baekjoon.silver._11403;

import java.util.*;
import java.io.*;

public class Main {
    /* s1
경로 찾기
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	256 MB	58680	37306	27794	63.413%
문제
가중치 없는 방향 그래프 G가 주어졌을 때, 모든 정점 (i, j)에 대해서,
i에서 j로 가는 길이가 양수인 경로가 있는지 없는지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 정점의 개수 N (1 ≤ N ≤ 100)이 주어진다.
둘째 줄부터 N개 줄에는 그래프의 인접 행렬이 주어진다.
i번째 줄의 j번째 숫자가 1인 경우에는 i에서 j로 가는 간선이 존재한다는 뜻이고,
0인 경우는 없다는 뜻이다. i번째 줄의 i번째 숫자는 항상 0이다.

출력
총 N개의 줄에 걸쳐서 문제의 정답을 인접행렬 형식으로 출력한다.
정점 i에서 j로 가는 길이가 양수인 경로가 있으면 i번째 줄의 j번째 숫자를 1로, 없으면 0으로 출력해야 한다.
    */
    static int[][] graph;
    static int[][] result;
    static boolean[] visited;
    static int dfsResult = 0;
    static int N;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/silver/_11403/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        result = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 방법1. dfs/bfs
        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            dfsR(i, i);
        }

//        System.out.println(Arrays.deepToString(result));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void dfsR(int start, int cur) {

        for (int next = 0; next < N; next++) {
            if (!visited[next] && graph[cur][next] == 1) {
                visited[next] = true;
                result[start][next] = 1;
                dfsR(start, next);
            }
        }
    }
}
