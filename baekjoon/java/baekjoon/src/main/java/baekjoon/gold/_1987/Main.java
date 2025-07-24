package baekjoon.gold._1987;

import java.util.*;
import java.io.*;

public class Main {
    /* g4
    알파벳 다국어
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	256 MB	146780	45785	27677	28.682%
문제
세로 R칸, 가로C 칸으로 된 표 모양의 보드가 있다.
보드의 각 칸에는 대문자 알파벳이 하나씩 적혀 있고, 좌측 상단 칸 (1행 1열) 에는 말이 놓여 있다.

말은 상하좌우로 인접한 네 칸 중의 한 칸으로 이동할 수 있는데,
새로 이동한 칸에 적혀 있는 알파벳은 지금까지 지나온 모든 칸에 적혀 있는 알파벳과는 달라야 한다.
즉, 같은 알파벳이 적힌 칸을 두 번 지날 수 없다.

좌측 상단에서 시작해서, 말이 최대한 몇 칸을 지날 수 있는지를 구하는 프로그램을 작성하시오.
말이 지나는 칸은 좌측 상단의 칸도 포함된다.

입력
첫째 줄에
$R$과
$C$가 빈칸을 사이에 두고 주어진다. (
$1 ≤ R,C ≤ 20$) 둘째 줄부터
$R$개의 줄에 걸쳐서 보드에 적혀 있는
$C$개의 대문자 알파벳들이 빈칸 없이 주어진다.

출력
첫째 줄에 말이 지날 수 있는 최대의 칸 수를 출력한다.
    */
    static char[][] graph;
    static boolean[][] visited;
    static int maxMove;
    static int R;
    static int C;
    static Set<Character> status = new HashSet<>();
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/gold/_1987/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        graph = new char[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                graph[i][j] = chars[j];
            }
        }

        System.out.println(Arrays.deepToString(graph));
        dfs(0,0, 1);

        System.out.println(maxMove);
    }

    static void dfs(int x, int y, int acc) {
//        System.out.println("visited x: " + x + ", y: " + y);
//        System.out.println("graph[x][y]: " + graph[x][y]);
//        System.out.println(status);
        if(x < 0 || x >= R || y < 0 || y >= C || status.contains(graph[x][y])){
//            System.out.println("현재 이곳이 실행되면 안되는데?");
            maxMove = Math.max(acc-1, maxMove);
            return;
        }

        status.add(graph[x][y]);

        dfs(x+1, y, acc+1);
        dfs(x-1, y, acc+1);
        dfs(x, y+1, acc+1);
        dfs(x, y-1, acc+1);

        status.remove(graph[x][y]);

    }
}
