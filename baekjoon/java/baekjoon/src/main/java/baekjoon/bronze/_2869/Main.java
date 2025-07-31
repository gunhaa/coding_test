package baekjoon.bronze._2869;

import java.util.*;
import java.io.*;

public class Main {
    /* b1
달팽이는 올라가고 싶다 다국어
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
0.25 초 (추가 시간 없음)	128 MB	303349	98066	78831	31.795%
문제
땅 위에 달팽이가 있다. 이 달팽이는 높이가 V미터인 나무 막대를 올라갈 것이다.

달팽이는 낮에 A미터 올라갈 수 있다. 하지만, 밤에 잠을 자는 동안 B미터 미끄러진다. 또, 정상에 올라간 후에는 미끄러지지 않는다.

달팽이가 나무 막대를 모두 올라가려면, 며칠이 걸리는지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 세 정수 A, B, V가 공백으로 구분되어서 주어진다. (1 ≤ B < A ≤ V ≤ 1,000,000,000)

출력
첫째 줄에 달팽이가 나무 막대를 모두 올라가는데 며칠이 걸리는지 출력한다.
    */

//    static int curHeight = 0;
//    static int count = 0;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/bronze/_2869/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
//        climbR(A,B,V);

        // 시간 초과
//        for(;;) {
//            curHeight += A;
//            count++;
//            if (V <= curHeight) {
//                break;
//            }
//            curHeight -= B;
//        }

        int realMove = A - B;
        int lastPos = V - A;

        double result = Math.ceil((double) lastPos / realMove);

        int answer = (int) result + 1;

        System.out.println(answer);
    }

    // stack이 너무 깊어져서 recursive 불가
//    static void climbR(int climbDistance, int dropDistance, int height) {
//        curHeight += climbDistance;
//        count++;
//        if(height <= curHeight) {
//            return;
//        }
//        curHeight -= dropDistance;
//        climbR(climbDistance, dropDistance, height);
//    }
}
