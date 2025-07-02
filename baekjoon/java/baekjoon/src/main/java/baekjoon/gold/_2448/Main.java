package baekjoon.gold._2448;
import java.util.*;
import java.io.*;

public class Main {
    /*
    별 찍기 - 11
    시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
    1 초	256 MB	44027	20147	14634	43.804%
    문제
    예제를 보고 규칙을 유추한 뒤에 별을 찍어 보세요.

    입력
    첫째 줄에 N이 주어진다. N은 항상 3×2k 수이다. (3, 6, 12, 24, 48, ...) (0 ≤ k ≤ 10, k는 정수)

    출력
    첫째 줄부터 N번째 줄까지 별을 출력한다.
    */
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/gold/_2448"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int iter = Integer.parseInt(br.readLine());
        for (int i = 0; i < iter; i++) {
        }
    }
}
