package baekjoon._2439;

import java.io.*;

public class Main {

    /* https://www.acmicpc.net/problem/2439
        시간 제한	메모리 제한
            1 초	128 MB

        문제
        첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제

        하지만, 오른쪽을 기준으로 정렬한 별(예제 참고)을 출력하시오.

        입력
        첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.

        출력
        첫째 줄부터 N번째 줄까지 차례대로 별을 출력한다.
    */

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/_2439/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        for(int i=1; i <= count; i++){
            appendStar(i, count);
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static StringBuilder sb = new StringBuilder();

    private static void appendStar(int starCount, int lineCount){
        for(int i=0; i<lineCount-starCount; i++){
            sb.append(" ");
        }

        for(int i=0; i<starCount; i++){
            sb.append("*");
        }

        sb.append("\n");
    }
}
