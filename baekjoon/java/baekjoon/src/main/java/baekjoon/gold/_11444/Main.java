package baekjoon.gold._11444;

import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
    /* g2
    피보나치 수 6
    시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
    1 초	256 MB	29611	13315	11022	47.591%
    문제
    피보나치 수는 0과 1로 시작한다. 0번째 피보나치 수는 0이고, 1번째 피보나치 수는 1이다.
    그 다음 2번째 부터는 바로 앞 두 피보나치 수의 합이 된다.

    이를 식으로 써보면 Fn = Fn-1 + Fn-2 (n ≥ 2)가 된다.

    n=17일때 까지 피보나치 수를 써보면 다음과 같다.

    0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597

    n이 주어졌을 때, n번째 피보나치 수를 구하는 프로그램을 작성하시오.

    입력
    첫째 줄에 n이 주어진다. n은 1,000,000,000,000,000,000보다 작거나 같은 자연수이다.

    출력
    첫째 줄에 n번째 피보나치 수를 1,000,000,007으로 나눈 나머지를 출력한다.
    */


    static final BigInteger cont = new BigInteger("1000000007");
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/gold/_11444/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        BigInteger bn = new BigInteger(line);
        int n = bn.mod(cont).intValue();
        int[] memo = new int[n+1];
        memo[0] = 0;
        memo[1] = 1;
        for(int i=2; i < memo.length; i++) {
            memo[i] = (memo[i-1] + memo[i-2]) % 1000000007;
        }
        System.out.println(Arrays.toString(memo));
        System.out.println(memo[n]);
    }
}
