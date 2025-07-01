package baekjoon.silver._21736;

import java.util.*;
import java.io.*;

public class Main {
    /* s2
    헌내기는 친구가 필요해
    시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
    1 초 (하단 참고)	1024 MB	19008	11462	9534	60.091%
    문제
    2020년에 입학한 헌내기 도연이가 있다.
    도연이는 비대면 수업 때문에 학교에 가지 못해 학교에 아는 친구가 없었다.
    드디어 대면 수업을 하게 된 도연이는 어서 캠퍼스 내의 사람들과 친해지고 싶다.

    도연이가 다니는 대학의 캠퍼스는
    $N \times M$ 크기이며 캠퍼스에서 이동하는 방법은 벽이 아닌 상하좌우로 이동하는 것이다. 단, 캠퍼스의 밖으로 이동할 수는 없다.

    불쌍한 도연이를 위하여 캠퍼스에서 도연이가 만날 수 있는 사람의 수를 출력하는 프로그램을 작성해보자.

    입력
    첫째 줄에는 캠퍼스의 크기를 나타내는 두 정수
    1이상 600이하의 N, M 이 주어진다.

    둘째 줄부터
    $N$개의 줄에는 캠퍼스의 정보들이 주어진다. O는 빈 공간, X는 벽, I는 도연이, P는 사람이다. I가 한 번만 주어짐이 보장된다.

    출력
    첫째 줄에 도연이가 만날 수 있는 사람의 수를 출력한다. 단, 아무도 만나지 못한 경우 TT를 출력한다.
    */


    static int x;
    static int y;
    static int[][] map;
    static boolean[][] visited;
    static int count = 0;
    static int startX;
    static int startY;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("src/main/java/baekjoon/silver/_21736/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st1.nextToken());
        x = Integer.parseInt(st1.nextToken());
        System.out.println("y = " + y);
        System.out.println("x = " + x);
        map = new int[y][x];
        visited = new boolean[y][x];
//        System.out.println(Arrays.deepToString(map));
        for (int i = 0; i < y; i++) {
            String[] lines = br.readLine().split("");
            for (int j = 0; j < x; j++) {
                switch(lines[j]) {
                    case "O": {
                        // not necessary
                        map[i][j] = 0;
                        break;
                    }
                    case "P": {
                        map[i][j] = 2;
                        break;
                    }
                    case "X": {
                        map[i][j] = 1;
                        break;
                    }
                    case "I": {
                        map[i][j] = 0;
                        startX = j;
                        startY = i;
                        break;
                    }
                }
            }
        }
        bfs(startX, startY);
//        System.out.println("startX = " + startX);
//        System.out.println("startY = " + startY);
//        System.out.println(Arrays.deepToString(map));
//        System.out.println(Arrays.deepToString(visited));

        System.out.println(count != 0 ? count : "TT");
    }

    static void bfs(int sx, int sy) {
        visited[sy][sx] = true;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{sy, sx});
        while(!queue.isEmpty()) {

            int[] cur = queue.poll();
            int curY = cur[0];
            int curX = cur[1];

            for(int i=0; i<dx.length; i++) {
                int mx = curX + dx[i];
                int my = curY + dy[i];

                if(mx >= 0 && my >= 0 && my < y && mx < x) {
                    if(!visited[my][mx] && (map[my][mx] == 0 || map[my][mx] == 2)) {
                        visited[my][mx] = true;
                        if(map[my][mx] == 2) {
                            count++;
                        }
                        queue.add(new int[]{my, mx});
                    }
                }
            }
        }

    }
}
