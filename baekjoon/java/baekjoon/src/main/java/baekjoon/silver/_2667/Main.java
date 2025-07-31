package baekjoon.silver._2667;

import java.util.*;
import java.io.*;

public class Main {
    /* s1
단지번호붙이기
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	128 MB	221013	101291	64333	43.700%
문제
<그림 1>과 같이 정사각형 모양의 지도가 있다. 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다.
철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다.
여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다.
대각선상에 집이 있는 경우는 연결된 것이 아니다. <그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다.
지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.

입력
첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고,
그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.

출력
첫 번째 줄에는 총 단지수를 출력하시오. 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.
    */
    static int N;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx;
    static int[] dy;
    static int depth = 1;
    static final int moveWays = 4;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/silver/_2667/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        visited = new boolean[N][N];
        dx = new int[]{1, -1, 0, 0};
        dy = new int[]{0, 0, 1, -1};

        for (int row = 0; row < N; row++) {
            String line = br.readLine();
            for (int col = 0; col < N; col++) {
                graph[row][col] = line.charAt(col) - '0';
            }
        }
//        System.out.println(Arrays.deepToString(graph));

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if (graph[row][col] == 1 && !visited[row][col]) {
                    dfsR(col, row);
                    pq.offer(depth);
                    depth = 1;
                }
//                visited = new boolean[N][N];
            }
        }
        System.out.println(pq.size());
        while(!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }

    static void dfsR(int x, int y) {
        visited[y][x] = true;

        for (int i = 0; i < moveWays; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if(!visited[ny][nx] && graph[ny][nx] == 1) {
                    visited[ny][nx] = true;
                    depth++;
                    dfsR(nx, ny);
                }
            }
        }
    }
}
