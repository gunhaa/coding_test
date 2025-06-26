package baekjoon.silver._9095;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    /* s3
    1, 2, 3 더하기
    시간 제한	        메모리 제한	제출	정답	맞힌 사람	정답 비율
    1 초 (추가 시간 없음)	512 MB	    144460	95863	66871	64.968%
    문제
    정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 7가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다.

    1+1+1+1
    1+1+2
    1+2+1
    2+1+1
    2+2
    1+3
    3+1
    정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.

    입력
    첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 n이 주어진다. n은 양수이며 11보다 작다.

    출력
    각 테스트 케이스마다, n을 1, 2, 3의 합으로 나타내는 방법의 수를 출력한다.
    */
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/silver/_9095/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int iter = Integer.parseInt(br.readLine());

        int[] memory = new int[12];

        memory[1] = 1;
        memory[2] = 2;
        memory[3] = 4;

        for (int i = 4; i < memory.length; i++) {
            memory[i] = memory[i-3] + memory[i-2] + memory[i-1];
        }

        for (int i = 0; i < iter; i++) {
            int line = Integer.parseInt(br.readLine());
            System.out.println(memory[line]);
        }
    }
}
