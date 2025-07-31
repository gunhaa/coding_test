package baekjoon.silver._2178;

import java.util.*;
import java.io.*;

public class Main {
    /* s1
미로 탐색
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	192 MB	244427	115515	72200	45.561%
문제
N×M크기의 배열로 표현되는 미로가 있다.

1	0	1	1	1	1
1	0	1	0	1	0
1	0	1	0	1	1
1	1	1	0	1	1
미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다.
이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오.
한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.

위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다.
칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.

입력
첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다.
다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.

출력
첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.
    */
    static int[][] graph;
    static boolean[][] visited;
    static int N;
    static int M;
    static final int searchWays = 4;
    static final int startX = 0;
    static final int startY = 0;
    static int[] dx;
    static int[] dy;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/silver/_2178/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        visited = new boolean[N][M];
        dx = new int[]{1, -1, 0, 0};
        dy = new int[]{0, 0, 1, -1};

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                graph[i][j] = line.charAt(j) - '0';
            }
        }

//        System.out.println(Arrays.deepToString(graph));
        int result = bfs();
        System.out.println(result);
    }

    static int bfs() {

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(startX, startY, 1));
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            for (int i = 0; i < searchWays; i++) {
                int nx = curNode.x + dx[i];
                int ny = curNode.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
                    if(!visited[ny][nx] && nx == M-1 && ny == N-1 ) {
                        return curNode.depth+1;
                    }

                    if(!visited[ny][nx] && graph[ny][nx] == 1) {
                        visited[ny][nx] = true;
                        queue.add(new Node(nx, ny, curNode.depth+1));
                    }
                }
            }
        }
        return -1;
    }

    static class Node {
        int x;
        int y;
        int depth;

        public Node(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
}
