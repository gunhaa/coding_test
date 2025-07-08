package baekjoon.bronze._2292;

import java.util.*;
import java.io.*;

public class Main {
    /* b2
    벌집
    시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
    2 초	128 MB	215340	98461	83711	45.154%
    문제

    위의 그림과 같이 육각형으로 이루어진 벌집이 있다.
    그림에서 보는 바와 같이 중앙의 방 1부터 시작해서 이웃하는 방에 돌아가면서 1씩 증가하는 번호를 주소로 매길 수 있다.
    숫자 N이 주어졌을 때, 벌집의 중앙 1에서 N번 방까지 최소 개수의 방을 지나서 갈 때 몇 개의 방을 지나가는지(시작과 끝을 포함하여)를 계산하는 프로그램을 작성하시오.
    예를 들면, 13까지는 3개, 58까지는 5개를 지난다.

    입력
    첫째 줄에 N(1 ≤ N ≤ 1,000,000,000)이 주어진다.

    출력
    입력으로 주어진 방까지 최소 개수의 방을 지나서 갈 때 몇 개의 방을 지나는지 출력한다.
    depth 1 = 1
    depth 2 = 6
    depth 3 = 12
    depth 4 = 18
    depth 5 = 24
    depth 6 = ..
    어떤 depth에 있는지 구하면 지나는 방을 알 수 있다, depth 는 지나는 방 갯수
    */
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/bronze/_2292/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());

        int depthRoom = 0;
        int acc = 1;
        int depth = 1;
        while(target > acc) {
            depthRoom += 6;
            depth++;
            acc += depthRoom;
        }
        System.out.println(depth);
    }
}
