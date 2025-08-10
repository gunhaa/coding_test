package baekjoon.gold._9205;

import java.util.*;
import java.io.*;

public class Main {
    /* g5
맥주 마시면서 걸어가기 다국어
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	128 MB	40560	17261	12590	40.731%
문제
송도에 사는 상근이와 친구들은 송도에서 열리는 펜타포트 락 페스티벌에 가려고 한다.
올해는 맥주를 마시면서 걸어가기로 했다.
출발은 상근이네 집에서 하고, 맥주 한 박스를 들고 출발한다.
맥주 한 박스에는 맥주가 20개 들어있다.
목이 마르면 안되기 때문에 50미터에 한 병씩 마시려고 한다. 즉, 50미터를 가려면 그 직전에 맥주 한 병을 마셔야 한다.

상근이의 집에서 페스티벌이 열리는 곳은 매우 먼 거리이다.
따라서, 맥주를 더 구매해야 할 수도 있다.
미리 인터넷으로 조사를 해보니 다행히도 맥주를 파는 편의점이 있다.
편의점에 들렸을 때, 빈 병은 버리고 새 맥주 병을 살 수 있다.
하지만, 박스에 들어있는 맥주는 20병을 넘을 수 없다.
편의점을 나선 직후에도 50미터를 가기 전에 맥주 한 병을 마셔야 한다.

편의점, 상근이네 집, 펜타포트 락 페스티벌의 좌표가 주어진다.
상근이와 친구들이 행복하게 페스티벌에 도착할 수 있는지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 테스트 케이스의 개수 t가 주어진다. (t ≤ 50)

각 테스트 케이스의 첫째 줄에는 맥주를 파는 편의점의 개수 n이 주어진다. (0 ≤ n ≤ 100).

다음 n+2개 줄에는 상근이네 집, 편의점, 펜타포트 락 페스티벌 좌표가 주어진다.
각 좌표는 두 정수 x와 y로 이루어져 있다. (두 값 모두 미터, -32768 ≤ x, y ≤ 32767)

송도는 직사각형 모양으로 생긴 도시이다. 두 좌표 사이의 거리는 x 좌표의 차이 + y 좌표의 차이 이다. (맨해튼 거리)

출력
각 테스트 케이스에 대해서 상근이와 친구들이 행복하게 페스티벌에 갈 수 있으면 "happy", 중간에 맥주가 바닥나서 더 이동할 수 없으면 "sad"를 출력한다.
    */
    static final String HAPPY = "happy";
    static final String SAD = "sad";

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/gold/_9205/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            List<List<Integer>> graph = new ArrayList<>();
            List<Coordinate> building = new ArrayList<>();
            int n = Integer.parseInt(br.readLine());
            for (int j = 0; j < n + 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                building.add(new Coordinate(x, y));
            }

            for (int j = 0; j < building.size(); j++) {
                graph.add(new ArrayList<>());
            }

            for (int j = 0; j < building.size(); j++) {
                for (int k = 0; k < building.size(); k++) {
                    if (getManhattanDistance(building.get(j), building.get(k)) <= 1000) {
                        graph.get(j).add(k);
                        graph.get(k).add(j);
                    }
                }
            }

            boolean isHappy = isHappyFestivalBfs(building, graph);
            result.append(isHappy ? HAPPY : SAD).append("\n");
        }
        System.out.println(result);
    }

    static boolean isHappyFestivalBfs(List<Coordinate> building, List<List<Integer>> graph) {
        int start = 0;
        int end = building.size() - 1;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.size()];

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if(cur == end) {
                return true;
            }

            for (int node : graph.get(cur)) {
                if(!visited[node]) {
                    queue.add(node);
                    visited[node] = true;
                }
            }
        }

        return false;
    }

    static int getManhattanDistance(Coordinate a, Coordinate b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

    static class Coordinate {
        int x;
        int y;

        Coordinate(int curX, int curY) {
            this.x = curX;
            this.y = curY;
        }
    }
}
