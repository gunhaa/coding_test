package baekjoon.gold._2573;

import java.util.*;
import java.io.*;

public class Main {

    /* g4
빙산
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	256 MB	96402	28671	19049	27.080%
문제
지구 온난화로 인하여 북극의 빙산이 녹고 있다.
빙산을 그림 1과 같이 2차원 배열에 표시한다고 하자.
빙산의 각 부분별 높이 정보는 배열의 각 칸에 양의 정수로 저장된다.
빙산 이외의 바다에 해당되는 칸에는 0이 저장된다.
그림 1에서 빈칸은 모두 0으로 채워져 있다고 생각한다.


 	2	4	5	3
 	3	 	2	5	2
 	7	6	2	4

그림 1. 행의 개수가 5이고 열의 개수가 7인 2차원 배열에 저장된 빙산의 높이 정보

빙산의 높이는 바닷물에 많이 접해있는 부분에서 더 빨리 줄어들기 때문에,
배열에서 빙산의 각 부분에 해당되는 칸에 있는 높이는 일년마다 그 칸에 동서남북 네 방향으로 붙어있는 0이 저장된 칸의 개수만큼 줄어든다.
단, 각 칸에 저장된 높이는 0보다 더 줄어들지 않는다. 바닷물은 호수처럼 빙산에 둘러싸여 있을 수도 있다.
따라서 그림 1의 빙산은 일년후에 그림 2와 같이 변형된다.

그림 3은 그림 1의 빙산이 2년 후에 변한 모습을 보여준다.
2차원 배열에서 동서남북 방향으로 붙어있는 칸들은 서로 연결되어 있다고 말한다.
따라서 그림 2의 빙산은 한 덩어리이지만, 그림 3의 빙산은 세 덩어리로 분리되어 있다.


 	 	2	4	1
 	1	 	1	5
 	5	4	1	2

그림 2


 	 	 	3
 	 	 	 	4
 	3	2

그림 3

한 덩어리의 빙산이 주어질 때, 이 빙산이 두 덩어리 이상으로 분리되는 최초의 시간(년)을 구하는 프로그램을 작성하시오.
그림 1의 빙산에 대해서는 2가 답이다.
만일 전부 다 녹을 때까지 두 덩어리 이상으로 분리되지 않으면 프로그램은 0을 출력한다.

입력
첫 줄에는 이차원 배열의 행의 개수와 열의 개수를 나타내는 두 정수 N과 M이 한 개의 빈칸을 사이에 두고 주어진다.
N과 M은 3 이상 300 이하이다.
그 다음 N개의 줄에는 각 줄마다 배열의 각 행을 나타내는 M개의 정수가 한 개의 빈 칸을 사이에 두고 주어진다.
각 칸에 들어가는 값은 0 이상 10 이하이다. 배열에서 빙산이 차지하는 칸의 개수, 즉, 1 이상의 정수가 들어가는 칸의 개수는 10,000 개 이하이다. 배열의 첫 번째 행과 열, 마지막 행과 열에는 항상 0으로 채워진다.

출력
첫 줄에 빙산이 분리되는 최초의 시간(년)을 출력한다.
만일 빙산이 다 녹을 때까지 분리되지 않으면 0을 출력한다.
    */

    static int N;
    static int M;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx;
    static int[] dy;
    static int[][] prevGraph;
    static int iceCount = -1;
    static int years = 0;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/gold/_2573/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st1.nextToken());
        M = Integer.parseInt(st1.nextToken());
        graph = new int[N][M];
        dx = new int[]{1, -1, 0, 0};
        dy = new int[]{0, 0, 1, -1};

        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        // 빙산 좌표 리스트 만들고 해당것만 iteration.. 더 효율적이긴 하지만 굳이? 이래도 시간 복잡도 괜찮을거같음
        // 빙산 녹이기

        while(true) {

            visited = new boolean[N][M];
            // graph를 전부 탐색하며 덩어리 판정
            iceCount = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!visited[i][j] && graph[i][j] > 0) {
                        dfsR(j, i);
                        iceCount++;
                    }
                }
            }

            if(iceCount >= 2) {
                System.out.println(years);
                return;
            }

            if(iceCount == 0) {
                System.out.println(iceCount);
                return;
            }

            years++;
            // 이전 그래프 복사
            prevGraph = new int[graph.length][];
            for (int i = 0; i < graph.length; i++) {
                prevGraph[i] = Arrays.copyOf(graph[i], graph[i].length);
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (prevGraph[i][j] > 0) {
                        for (int k = 0; k < dx.length; k++) {
                            int nx = j + dx[k];
                            int ny = i + dy[k];
                            if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                                if (prevGraph[ny][nx] == 0) {
                                    //1. 좌표에 따른 - 값을 모아놓은 후 batch처리
                                    //2. 이전 그래프 복사 한 후 이를 이용해 처리
                                    int melt = graph[i][j] - 1;
                                    graph[i][j] = Math.max(melt, 0);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    static void dfsR(int x, int y) {
        visited[y][x] = true;

        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                if (!visited[ny][nx] && graph[ny][nx] > 0) {
                    dfsR(nx, ny);
                }
            }
        }
    }
}
