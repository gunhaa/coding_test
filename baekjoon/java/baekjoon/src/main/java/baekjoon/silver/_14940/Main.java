package baekjoon.silver._14940;

import java.io.*;
import java.util.*;

public class Main {
    /* s1
    쉬운 최단거리
    시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
    1 초	128 MB	46296	18684	15038	37.969%
    문제
    지도가 주어지면 모든 지점에 대해서 목표지점까지의 거리를 구하여라.

    문제를 쉽게 만들기 위해 오직 가로와 세로로만 움직일 수 있다고 하자.

    입력
    지도의 크기 n과 m이 주어진다. n은 세로의 크기, m은 가로의 크기다.(2 ≤ n ≤ 1000, 2 ≤ m ≤ 1000)

    다음 n개의 줄에 m개의 숫자가 주어진다. 0은 갈 수 없는 땅이고 1은 갈 수 있는 땅, 2는 목표지점이다. 입력에서 2는 단 한개이다.

    출력
    각 지점에서 목표지점까지의 거리를 출력한다. 원래 갈 수 없는 땅인 위치는 0을 출력하고, 원래 갈 수 있는 땅인 부분 중에서 도달할 수 없는 위치는 -1을 출력한다.
    */

    static int[][] map;
    static int[][] resultMap;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int length;
    static int width;
    static BufferedWriter bw;
    static int startX;
    static int startY;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/silver/_14940/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        length = Integer.parseInt(st1.nextToken());
        width = Integer.parseInt(st1.nextToken());
        startX = -1;
        startY = -1;
        map = new int[length][width];
        resultMap = new int[length][width];
//        for(int i=0; i<resultMap.length; i++) {
//            Arrays.fill(resultMap[i], -1);
//        }
        visited = new boolean[length][width];
        for (int i = 0; i < length; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                int ground = Integer.parseInt(st2.nextToken());
                map[i][j] = ground;
                if (ground == 2) {
                    startX = j;
                    startY = i;
                }
            }
        }

        if (startX == -1 && startY == -1) {
            throw new IllegalStateException();
        }

//        resultMap[startY][startX] = 0;
//        visited[startY][startX] = true;
//        dfsR(startX, startY, 0);
        bfs(startX, startY);

        // 갈 수 없는 곳 -1
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[i].length; j++) {
                if(!visited[i][j] && map[i][j] == 1){
                    resultMap[i][j] = -1;
                }
            }
        }
        printResult();
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        visited[y][x] = true;
        resultMap[y][x] = 0;
        queue.add(new int[]{y, x});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curY = cur[0];
            int curX = cur[1];
            for (int i = 0; i < dx.length; i++) {
                int my = curY + dy[i];
                int mx = curX + dx[i];

                if (mx >= 0 && my >= 0 && length > my && width > mx) {
                    if (!visited[my][mx] && map[my][mx] == 1) {
                        visited[my][mx] = true;
                        resultMap[my][mx] = resultMap[curY][curX] + 1;
                        queue.add(new int[]{my, mx});
                    }
                }
            }
        }
    }

    static void dfsR(int x, int y, int distance) {
        visited[y][x] = true;
        resultMap[y][x] = distance;

        for (int i = 0; i < dx.length; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];

            if (mx >= 0 && my >= 0 && length > my && width > mx) {
                if (!visited[my][mx] && map[my][mx] == 1) {
                    dfsR(mx, my, distance + 1);
                }
            }
        }
    }

    static void printResult() throws IOException {
        for (int i = 0; i < resultMap.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < resultMap[i].length; j++) {
                if (j == resultMap[i].length - 1) {
                    sb.append(String.valueOf(resultMap[i][j]));
                    continue;
                }
                sb.append(String.valueOf(resultMap[i][j]) + " ");
            }
            bw.write(sb.toString() + "\n");
        }
        bw.flush();
        bw.close();
    }
}
