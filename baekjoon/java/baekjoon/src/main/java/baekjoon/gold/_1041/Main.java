package baekjoon.gold._1041;

import java.io.*;
import java.util.*;

public class Main {
    /* g5
    주사위
    시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
    2 초	128 MB	25191	7274	6175	29.000%
    문제
        +---+
        | D |
    +---+---+---+---+
    | E | A | B | F |
    +---+---+---+---+
        | C |
        +---+
    주사위는 위와 같이 생겼다. 주사위의 여섯 면에는 수가 쓰여 있다. 위의 전개도를 수가 밖으로 나오게 접는다.

    A, B, C, D, E, F에 쓰여 있는 수가 주어진다.

    지민이는 현재 동일한 주사위를 N3개 가지고 있다. 이 주사위를 적절히 회전시키고 쌓아서, N×N×N크기의 정육면체를 만들려고 한다.
    이 정육면체는 탁자위에 있으므로, 5개의 면만 보인다.

    N과 주사위에 쓰여 있는 수가 주어질 때, 보이는 5개의 면에 쓰여 있는 수의 합의 최솟값을 출력하는 프로그램을 작성하시오.

    입력
    첫째 줄에 N이 주어진다. 둘째 줄에 주사위에 쓰여 있는 수가 주어진다. 위의 그림에서 A, B, C, D, E, F에 쓰여 있는 수가 차례대로 주어진다.
    N은 1,000,000보다 작거나 같은 자연수이고, 쓰여 있는 수는 50보다 작거나 같은 자연수이다.

    출력
    첫째 줄에 문제의 정답을 출력한다.
    */

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/gold/_1041/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int diceN = Integer.parseInt(br.readLine());
        int[] dice = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < dice.length; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        // NxNxN 에서 밑면 제외시키면
        // 3면 개방 위쪽 구석블록
        // 2면 개방 사이블록
        // 1면 개방 가운데블록 전부

        Arrays.sort(dice);
        // 최소값 idx - 0 , 1 , 2 순
        // 노출되는 면은 n^2 x 5임
        // 맨위 한개의 면은 특수하며, 4개의 면은 동일해서 x4하면됨

        // 블록단위의 loop를 도는게 가장 명확할듯
        // 3면 노출 갯수x 최소~3 - NxN의 위쪽 모서리 4개
        final int threeSidesBlock = 4;
        // 2면이 노출된 블록(N의 개수에 따른 동적 개수/ 갯수x최소~2 / 갯수 (N-2)*4 + (N-1)*4 )
        final int twoSidesBlock = (diceN-2)*4 + (diceN-1)*4;
        // 1면 노출된 블록(N의 갯수에 따른 동적 개수/ 갯수x최소값/ 갯수 (N-2)^2 + (N-2)(N-1)*4
        final int oneSidesBlock = (diceN-2)*(diceN-2) + (diceN-2)*(diceN-1)*4;

        int threeSidesMin = 0;
        for (int i = 0; i < 3; i++) {
            threeSidesMin += dice[i];
        }
        answer += threeSidesMin * threeSidesBlock;

        int twoSidesMin = 0;
        for (int i=0; i < 2; i++) {
            twoSidesMin += dice[i];
        }
        answer += twoSidesMin * twoSidesBlock;

        int oneSidesMin = 0;
        for (int i=0; i < 2; i++) {
            oneSidesMin += dice[i];
        }
        answer += oneSidesMin * oneSidesBlock;


        System.out.println(answer);
    }
}
