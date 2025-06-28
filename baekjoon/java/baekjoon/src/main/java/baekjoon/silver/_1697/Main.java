package baekjoon.silver._1697;

import java.io.*;
import java.util.*;

public class Main {
    /* s1
    숨바꼭질 다국어
    시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
    2 초	128 MB	291560	88049	56119	26.624%
    문제
    수빈이는 동생과 숨바꼭질을 하고 있다.
    수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다.
    수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다.
    순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.

    수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.

    입력
    첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.

    출력
    수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.
    */

    static int subin;
    static int brother;
    static int min;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/silver/_1697/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        subin = Integer.parseInt(st.nextToken());
        brother = Integer.parseInt(st.nextToken());
//        dfsR(subin, 0);
        bfs(subin);
        System.out.println(min);

    }

    static void bfs(int location) {
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(location, 0));
        boolean[] visited = new boolean[100001];

        while (!queue.isEmpty()) {
            Node loc = queue.poll();
            if(loc.location == brother) {
                min = loc.depth;
                return;
            }

            visited[loc.location] = true;
            int[] nextLocArr = {loc.location + 1, loc.location - 1, loc.location * 2};
            for(int nextLoc : nextLocArr) {
                if(nextLoc <= 100000 && nextLoc >= 0 && !visited[nextLoc]) {
                    queue.offer(new Node(nextLoc, loc.depth+1));
                }
            }
        }
    }

    static class Node {
        int location;
        int depth;

        public Node(int location, int depth) {
            this.location = location;
            this.depth = depth;
        }
    }

    // overflow
//    static void dfsR(int location, int depth) {
//
//        if(location == brother){
//            min = Math.min(depth, min);
//            return;
//        }
//
//        if(location > brother) {
//            dfsR(location - 1, depth + 1);
//        }
//
//        if(location < brother) {
//            dfsR(location * 2, depth + 1);
//        }

}
