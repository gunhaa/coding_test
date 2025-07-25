package baekjoon.bronze._30802;

import java.util.*;
import java.io.*;

public class Main {
    /* b3
    웰컴 키트 다국어
    시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
    0.1 초	1024 MB	29757	15732	14586	52.882%
    문제
    2024년 2월 3일 개최 예정인 온사이트 그랜드 아레나에서는 참가자들에게 티셔츠 한 장과 펜 한 자루가 포함된 웰컴 키트를 나눠줄 예정입니다.
    키트를 제작하는 업체는 다음과 같은 조건으로만 주문이 가능합니다.

    티셔츠는 S, M, L, XL, XXL, 그리고 XXXL의 6가지 사이즈가 있습니다.
    티셔츠는 같은 사이즈의
    $T$장 묶음으로만 주문할 수 있습니다.
    펜은 한 종류로,
    $P$자루씩 묶음으로 주문하거나 한 자루씩 주문할 수 있습니다.
    총
    $N$명의 참가자 중 S, M, L, XL, XXL, XXXL 사이즈의 티셔츠를 신청한 사람은 각각
    $S, M, L, XL, XXL, XXXL$명입니다.
    티셔츠는 남아도 되지만 부족해서는 안 되고 신청한 사이즈대로 나눠주어야 합니다.
    펜은 남거나 부족해서는 안 되고 정확히 참가자 수만큼 준비되어야 합니다.

    티셔츠를
    $T$장씩 최소 몇 묶음 주문해야 하는지, 그리고 펜을
    $P$자루씩 최대 몇 묶음 주문할 수 있고, 그 때 펜을 한 자루씩 몇 개 주문하는지 구하세요.

    입력
    첫 줄에 참가자의 수
    $N$이 주어집니다.
    $(1 \le N \le 10^9)$ 

    둘째 줄에 티셔츠 사이즈별 신청자의 수
    $S, M, L, XL, XXL, XXXL$이 공백으로 구분되어 주어집니다.
    $(0 \le S, M, L, XL, XXL, XXXL \le N;$
    $S + M + L + XL + XXL + XXXL = N)$ 

    셋째 줄에 정수 티셔츠와 펜의 묶음 수를 의미하는 정수
    $T$와
    $P$가 공백으로 구분되어 주어집니다.
    $(2 \le T, P \le 10^9)$ 

    출력
    첫 줄에 티셔츠를
    $T$장씩 최소 몇 묶음 주문해야 하는지 출력하세요.

    다음 줄에 펜을
    $P$자루씩 최대 몇 묶음 주문할 수 있는지와, 그 때 펜을 한 자루씩 몇 개 주문하는지 구하세요.
    */
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/bronze/_30802/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st2.nextToken());
        int P = Integer.parseInt(st2.nextToken());

        int shirtMaxOrder = 0;
        int penMaxOrderBundle = N/P;
        int penMaxOrderSingle = N%P;
        for (int i = 0; i < 6; i++) {
            int needShirts = Integer.parseInt(st1.nextToken());
            shirtMaxOrder += (int) Math.ceil((double) needShirts / T);
        }

        System.out.println(shirtMaxOrder);
        System.out.println(penMaxOrderBundle+ " " + penMaxOrderSingle);
    }
}
