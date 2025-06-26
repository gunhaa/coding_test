package baekjoon.bronze._2675;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    문자열 반복 다국어
    시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
        1 초	128 MB	279373	141028	119096	50.162%
    문제
    문자열 S를 입력받은 후에, 각 문자를 R번 반복해 새 문자열 P를 만든 후 출력하는 프로그램을 작성하시오.
    즉, 첫 번째 문자를 R번 반복하고, 두 번째 문자를 R번 반복하는 식으로 P를 만들면 된다. S에는 QR Code "alphanumeric" 문자만 들어있다.

    QR Code "alphanumeric" 문자는 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ\$%*+-./: 이다.

    입력
    첫째 줄에 테스트 케이스의 개수 T(1 ≤ T ≤ 1,000)가 주어진다. 각 테스트 케이스는 반복 횟수 R(1 ≤ R ≤ 8), 문자열 S가 공백으로 구분되어 주어진다.
    S의 길이는 적어도 1이며, 20글자를 넘지 않는다.

    출력
    각 테스트 케이스에 대해 P를 출력한다.
    */
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("src/main/java/baekjoon/bronze/_2675/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int iter = Integer.parseInt(br.readLine());
        for (int i = 0; i < iter; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int iter2 = Integer.parseInt(st.nextToken());
            StringBuilder sb = new StringBuilder();
            String target = st.nextToken();
            for (char c : target.toCharArray()) {
                for (int j = 0; j < iter2; j++) {
                    sb.append(c);
                }
            }
            System.out.println(sb);
        }

    }
}
