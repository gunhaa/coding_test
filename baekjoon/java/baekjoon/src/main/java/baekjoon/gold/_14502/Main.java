package baekjoon.gold._14502;

import java.util.*;
import java.io.*;

public class Main {
    /* g4
연구소
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	512 MB	118894	69519	38975	55.819%
문제
인체에 치명적인 바이러스를 연구하던 연구소에서 바이러스가 유출되었다. 다행히 바이러스는 아직 퍼지지 않았고, 바이러스의 확산을 막기 위해서 연구소에 벽을 세우려고 한다.
연구소는 크기가 N×M인 직사각형으로 나타낼 수 있으며, 직사각형은 1×1 크기의 정사각형으로 나누어져 있다. 연구소는 빈 칸, 벽으로 이루어져 있으며, 벽은 칸 하나를 가득 차지한다.
일부 칸은 바이러스가 존재하며, 이 바이러스는 상하좌우로 인접한 빈 칸으로 모두 퍼져나갈 수 있다. 새로 세울 수 있는 벽의 개수는 3개이며, 꼭 3개를 세워야 한다.
예를 들어, 아래와 같이 연구소가 생긴 경우를 살펴보자.

2 0 0 0 1 1 0
0 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 0 0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0
이때, 0은 빈 칸, 1은 벽, 2는 바이러스가 있는 곳이다. 아무런 벽을 세우지 않는다면, 바이러스는 모든 빈 칸으로 퍼져나갈 수 있다.

2행 1열, 1행 2열, 4행 6열에 벽을 세운다면 지도의 모양은 아래와 같아지게 된다.

2 1 0 0 1 1 0
1 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 1 0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0
바이러스가 퍼진 뒤의 모습은 아래와 같아진다.

2 1 0 0 1 1 2
1 0 1 0 1 2 2
0 1 1 0 1 2 2
0 1 0 0 0 1 2
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0
벽을 3개 세운 뒤, 바이러스가 퍼질 수 없는 곳을 안전 영역이라고 한다. 위의 지도에서 안전 영역의 크기는 27이다.

연구소의 지도가 주어졌을 때 얻을 수 있는 안전 영역 크기의 최댓값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 지도의 세로 크기 N과 가로 크기 M이 주어진다. (3 ≤ N, M ≤ 8)

둘째 줄부터 N개의 줄에 지도의 모양이 주어진다. 0은 빈 칸, 1은 벽, 2는 바이러스가 있는 위치이다. 2의 개수는 2보다 크거나 같고, 10보다 작거나 같은 자연수이다.

빈 칸의 개수는 3개 이상이다.

출력
첫째 줄에 얻을 수 있는 안전 영역의 최대 크기를 출력한다.
    */
    static int[][] graph;
    static List<int[][]> candidatesList;
    static List<int[]> safeList;
    static List<int[]> virusList;
    static List<int[][]> createWallList;
    static int N;
    static int M;
    static int[] dx;
    static int[] dy;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/gold/_14502/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st1.nextToken());
        M = Integer.parseInt(st1.nextToken());
        graph = new int[N][M];
        candidatesList = new ArrayList<>();
        safeList = new ArrayList<>();
        virusList = new ArrayList<>();
        createWallList = new ArrayList<>();

        dx = new int[]{1, -1, 0, 0};
        dy = new int[]{0, 0, 1, -1};

        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        search();

        makeCombinationR(0, 0, new int[3][1]);

        System.out.println(max);
    }

    static void search() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 0) {
                    safeList.add(new int[]{i, j});
                } else if (graph[i][j] == 2) {
                    virusList.add(new int[]{i, j});
                }
            }
        }
    }

    static void simulateVirus(int[][] tempResult) {
        int[][] copyGraph = new int[N][M];
        for (int i = 0; i < N; i++) {
            copyGraph[i] = Arrays.copyOf(graph[i], graph[i].length);
        }

        for (int[] wall : tempResult) {
            copyGraph[wall[0]][wall[1]] = 1;
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int[] virus : virusList) {
            queue.offer(virus);
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if(copyGraph[nx][ny] == 0) {
                        copyGraph[nx][ny] = 2;
                        queue.offer(new int[]{nx,ny});
                    }
                }
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(copyGraph[i][j] == 0) {
                    count++;
                }
            }
        }


        max = Math.max(count, max);
//        if(max == 32 && !flag) {
//            System.out.println(Arrays.deepToString(tempResult));
//            System.out.println(Arrays.deepToString(copyGraph));
//            flag = true;
//        }
    }
//    static boolean flag = false;

    static void makeCombinationR(int start, int depth, int[][] tempResult) {
        if (depth == 3) {
            // 좌표를 이용한 bfs
            simulateVirus(tempResult);
            return;
        }

        for (int i = start; i < safeList.size(); i++) {
            tempResult[depth] = safeList.get(i);
            makeCombinationR(i + 1, depth + 1, tempResult);
        }
    }

//    static void searchCoordinateR(int x, int y) {
//        visited[x][y] = true;
//
//        for (int i = 0; i < 4; i++) {
//            int nx = x + dx[i];
//            int ny = y + dy[i];
//
//            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
//                if (!visited[nx][ny]) {
//                    if (graph[nx][ny] == 0) {
//                        safeList.add(new int[]{nx, ny});
//                    } else if (graph[nx][ny] == 2) {
//                        virusList.add(new int[]{nx, ny});
//                    }
//                    searchCoordinateR(nx, ny);
//                }
//            }
//        }
//    }
}
