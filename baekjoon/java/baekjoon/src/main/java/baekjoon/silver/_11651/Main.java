package baekjoon.silver._11651;

import java.util.*;
import java.io.*;

public class Main {

    /* s5
    좌표 정렬하기 2
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	256 MB	99147	65323	55775	67.234%
문제
2차원 평면 위의 점 N개가 주어진다. 좌표를 y좌표가 증가하는 순으로,
y좌표가 같으면 x좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다.
둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다.
(-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.

출력
첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.
    */
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/gold/_11651/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Coordinate> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Coordinate c = new Coordinate(x, y);
            list.add(c);
        }
        Collections.sort(list);
        for (Coordinate c : list) {
            System.out.println(c.x + " " + c.y);
        }
    }

    static class Coordinate implements Comparable<Coordinate> {
        int x;
        int y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Coordinate o) {
            if (this.y - o.y > 0) {
                return 1;
            } else if (this.y == o.y) {
                if (this.x - o.x > 0) {
                    return 1;
                } else if (this.x - o.x < 0) {
                    return -1;
                }
                return 0;
            }

            return -1;
        }
    }
}
