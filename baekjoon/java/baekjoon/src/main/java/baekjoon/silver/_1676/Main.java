package baekjoon.silver._1676;

import java.util.*;
import java.io.*;
import java.math.*;

public class Main {

    /* s5
    팩토리얼 0의 개수
    시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
    2 초	128 MB	103707	48416	40800	46.270%
    문제
    N!에서 뒤에서부터 처음 0이 아닌 숫자가 나올 때까지 0의 개수를 구하는 프로그램을 작성하시오.

    입력
    첫째 줄에 N이 주어진다. (0 ≤ N ≤ 500)

    출력
    첫째 줄에 구한 0의 개수를 출력한다.

    10 9 8 ..
    */

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/silver/_1676/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int factorial = Integer.parseInt(br.readLine());
        BigInteger result = new BigInteger("1");
        for (int i = 1; i <= factorial; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        int count = 0;
        char[] resultChar = result.toString().toCharArray();
        for (int i = resultChar.length - 1; i >= 0; i--) {
            if(resultChar[i] == '0') {
                count++;
            } else {
                break;
            }
        }
        System.out.println(count);
    }
}
