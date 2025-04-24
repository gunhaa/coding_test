package baekjoon.bronze._11720;

import java.io.*;

public class Main {

    /* https://www.acmicpc.net/problem/11720
    숫자의 합
    시간 제한	메모리 제한
        1 초	256 MB

    문제
    N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.

    입력
    첫째 줄에 숫자의 개수 N (1 ≤ N ≤ 100)이 주어진다. 둘째 줄에 숫자 N개가 공백없이 주어진다.

    출력
    입력으로 주어진 숫자 N개의 합을 출력한다.
    */

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/main/java/baekjoon/bronze/_11720/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sum = 0;
        int count = Integer.parseInt(br.readLine());
        String line = br.readLine();
        String[] numChar = line.split("");

        for(int i=0; i<count; i++){
            sum += Integer.parseInt(numChar[i]);
        }


        bw.write(String.valueOf(sum));
        bw.flush();
    }
}
