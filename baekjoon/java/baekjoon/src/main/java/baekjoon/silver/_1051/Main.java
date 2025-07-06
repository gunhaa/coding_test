package baekjoon.silver._1051;

import java.util.*;
import java.io.*;

public class Main {

    /* s3
   숫자 정사각형
    시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
    2 초	128 MB	27876	13100	11111	47.564%
    문제
    N×M크기의 직사각형이 있다. 각 칸에는 한 자리 숫자가 적혀 있다.
    이 직사각형에서 꼭짓점에 쓰여 있는 수가 모두 같은 가장 큰 정사각형을 찾는 프로그램을 작성하시오.
    이때, 정사각형은 행 또는 열에 평행해야 한다.

    입력
    첫째 줄에 N과 M이 주어진다. N과 M은 50보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에 수가 주어진다.

    출력
    첫째 줄에 정답 정사각형의 크기를 출력한다.
   */

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/silver/_1051/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int rows = Integer.parseInt(st.nextToken());
        int cols = Integer.parseInt(st.nextToken());

        int[][] rect = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            String line = br.readLine();
            for (int j = 0; j < cols; j++) {
                rect[i][j] = line.charAt(j) - '0';
            }
        }
        System.out.println(Arrays.deepToString(rect));

        int maxLen = 0;
        // 1. 가장 쉬운 방법 = 3중 루프
        // 2. 어려울거 같은데 될거같은 방법 = HashMap을 이용한 보충수로 탐색
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int searchNum = rect[i][j];
                for (int k = j+1; k < cols; k++) {
                    if(searchNum == rect[i][k]) {
                        int len = k-j;
                        if( i+len < rows && searchNum == rect[i+len][j] && searchNum == rect[i+len][k]) {
                            maxLen = Math.max(maxLen, len);
                        }
                    }
                }
            }
        }

        if(maxLen == 0) {
            System.out.println(1);
        } else {
            int len = maxLen + 1;
            System.out.println(len*len);
        }
    }

}
