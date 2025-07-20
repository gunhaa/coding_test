package baekjoon.gold._2096;

import java.util.*;
import java.io.*;

public class Main {
    /* g5
    내려가기
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	4 MB (하단 참고)	56644	21878	17127	36.787%
문제
N줄에 0 이상 9 이하의 숫자가 세 개씩 적혀 있다.
내려가기 게임을 하고 있는데, 이 게임은 첫 줄에서 시작해서 마지막 줄에서 끝나게 되는 놀이이다.

먼저 처음에 적혀 있는 세 개의 숫자 중에서 하나를 골라서 시작하게 된다.
그리고 다음 줄로 내려가는데, 다음 줄로 내려갈 때에는 다음과 같은 제약 조건이 있다.
바로 아래의 수로 넘어가거나, 아니면 바로 아래의 수와 붙어 있는 수로만 이동할 수 있다는 것이다.
이 제약 조건을 그림으로 나타내어 보면 다음과 같다.

별표는 현재 위치이고, 그 아랫 줄의 파란 동그라미는 원룡이가 다음 줄로 내려갈 수 있는 위치이며,
빨간 가위표는 원룡이가 내려갈 수 없는 위치가 된다.
숫자표가 주어져 있을 때, 얻을 수 있는 최대 점수, 최소 점수를 구하는 프로그램을 작성하시오. 점수는 원룡이가 위치한 곳의 수의 합이다.

입력
첫째 줄에 N(1 ≤ N ≤ 100,000)이 주어진다. 다음 N개의 줄에는 숫자가 세 개씩 주어진다. 숫자는 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 중의 하나가 된다.

출력
첫째 줄에 얻을 수 있는 최대 점수와 최소 점수를 띄어서 출력한다.
    */
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/gold/_2096/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] searchMax = new int[3];
        int[] searchMin = new int[3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int cur0 = Integer.parseInt(st.nextToken());
            int cur1 = Integer.parseInt(st.nextToken());
            int cur2 = Integer.parseInt(st.nextToken());

//            System.out.println("cur0 = " + cur0);
//            System.out.println("cur1 = " + cur1);
//            System.out.println("cur2 = " + cur2);
            if (i == 0) {
                searchMax[0] = cur0;
                searchMax[1] = cur1;
                searchMax[2] = cur2;

                searchMin[0] = cur0;
                searchMin[1] = cur1;
                searchMin[2] = cur2;
            } else {
                int prevMax0 = searchMax[0];
                int prevMax1 = searchMax[1];
                int prevMax2 = searchMax[2];

                searchMax[0] = Math.max(prevMax0, prevMax1) + cur0;
                searchMax[1] = Math.max(prevMax0, Math.max(prevMax1, prevMax2)) + cur1;
                searchMax[2] = Math.max(prevMax1, prevMax2) + cur2;

                int prevMin0 = searchMin[0];
                int prevMin1 = searchMin[1];
                int prevMin2 = searchMin[2];

                searchMin[0] = Math.min(prevMin0, prevMin1) + cur0;
                searchMin[1] = Math.min(prevMin0, Math.min(prevMin1, prevMin2)) + cur1;
                searchMin[2] = Math.min(prevMin1, prevMin2) + cur2;
            }
//            System.out.println(Arrays.toString(searchMax));
//            System.out.println(Arrays.toString(searchMin));

        }

        int max = Integer.MIN_VALUE;
        for (int candidate : searchMax) {
            max = Math.max(candidate, max);
        }

        int min = Integer.MAX_VALUE;
        for(int candidate : searchMin) {
            min = Math.min(candidate, min);
        }
        System.out.println(max + " " + min);

//        System.out.println(Arrays.deepToString(grid));

    }
}
