package baekjoon.bronze._2609;

import java.util.*;
import java.io.*;

public class Main {
    /* b1
최대공약수와 최소공배수
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	128 MB	137819	79808	65073	57.734%
문제
두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에는 두 개의 자연수가 주어진다. 이 둘은 10,000이하의 자연수이며 사이에 한 칸의 공백이 주어진다.

출력
첫째 줄에는 입력으로 주어진 두 수의 최대공약수를, 둘째 줄에는 입력으로 주어진 두 수의 최소 공배수를 출력한다.
    */
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/bronze/_2609/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        if (a < b) {
            // a > b가 아니라면 swap
            int temp = a;
            a = b;
            b = temp;
        }
        int gcdResult = gcdR(a, b);
        System.out.println(gcdResult);
        System.out.println(a*b/gcdResult);
    }

    static int gcdR(int a, int b) {
        int r = a % b;
        if(r == 0) {
            return b;
        }
        return gcdR(b,r);
    }
}
