package baekjoon._31403;

import java.io.*;

public class Main {

    /* https://www.acmicpc.net/problem/31403
    시간 제한	메모리 제한
        1 초	1024 MB

    문제
    JavaScript에서
    +, -은 수에 대해서는 일반적인 의미의 덧셈 뺄셈의 의미를 가지고 있습니다. 하지만 문자열에 대해서
    +는 두 문자열을 이어붙이라는 의미이고,
    -는 양쪽 문자열을 수로 해석한 이후에 빼라는 의미입니다.
    A, B, C를 각각 수와 문자열로 생각했을 때
    A+B-C를 출력하세요.

    입력
    첫 줄에는 정수
    A가 주어집니다.
    (1 <= A <=1,000)

    둘째 줄에는 정수
    B가 주어집니다.
    (1 <= B <=1,000)

    셋째 줄에는 정수
    C가 주어집니다.
    (1 <= C <=1,000)

    주어지는 모든 수는 0으로 시작하지 않는 양의 정수입니다.

    출력
    첫 줄에는
    A, B, C를 수로 생각했을 때,
    A+B-C를 출력하세요.

    둘째 줄에는
    A, B, C를 문자열로 생각했을 때,
    A+B-C를 출력하세요.
    */

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/main/java/baekjoon/_31403/input"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = br.readLine();
        String b = br.readLine();
        String c = br.readLine();
        String ab = a+b;

        int numA = Integer.parseInt(a);
        int numB = Integer.parseInt(b);
        int numC = Integer.parseInt(c);
        int numAB = Integer.parseInt(ab);
        bw.write(String.valueOf(numA+numB-numC));
        bw.newLine();
        bw.write(String.valueOf(numAB-numC));
        bw.flush();
    }
}
