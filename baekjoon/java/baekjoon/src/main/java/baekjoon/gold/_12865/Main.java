package baekjoon.gold._12865;

import java.util.*;
import java.io.*;

public class Main {
    /* g5
    평범한 배낭
    시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
    2 초	512 MB	170629	66252	41254	36.743%
    문제
    이 문제는 아주 평범한 배낭에 관한 문제이다.

    한 달 후면 국가의 부름을 받게 되는 준서는 여행을 가려고 한다.
    세상과의 단절을 슬퍼하며 최대한 즐기기 위한 여행이기 때문에, 가지고 다닐 배낭 또한 최대한 가치 있게 싸려고 한다.

    준서가 여행에 필요하다고 생각하는 N개의 물건이 있다.
    각 물건은 무게 W와 가치 V를 가지는데, 해당 물건을 배낭에 넣어서 가면 준서가 V만큼 즐길 수 있다.
    아직 행군을 해본 적이 없는 준서는 최대 K만큼의 무게만을 넣을 수 있는 배낭만 들고 다닐 수 있다. 준서가 최대한 즐거운 여행을 하기 위해 배낭에 넣을 수 있는 물건들의 가치의 최댓값을 알려주자.

    입력
    첫 줄에 물품의 수 N(1 ≤ N ≤ 100)과 준서가 버틸 수 있는 무게 K(1 ≤ K ≤ 100,000)가 주어진다.
    두 번째 줄부터 N개의 줄에 거쳐 각 물건의 무게 W(1 ≤ W ≤ 100,000)와 해당 물건의 가치 V(0 ≤ V ≤ 1,000)가 주어진다.

    입력으로 주어지는 모든 수는 정수이다.

    출력
    한 줄에 배낭에 넣을 수 있는 물건들의 가치합의 최댓값을 출력한다.
    */

//    static int max = 0;
    static int iter;
    static int limit;
    static int[][] knapsack;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/gold/_12865/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        iter = Integer.parseInt(st1.nextToken());
        limit = Integer.parseInt(st1.nextToken());
        //knapsack[물건번호][0= 무게,1= 가치]
        knapsack = new int[iter+1][2];
        for (int i = 1; i <= iter; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            knapsack[i] = new int[]{Integer.parseInt(st2.nextToken()), Integer.parseInt(st2.nextToken())};
        }

        // dp[물건종류][무게제한]
        int[][] dp = new int[iter+1][limit+1];

        // 물건 종류
        for (int i = 1; i <= iter; i++) {
            // 무게별
            for (int j = 1; j <= limit; j++) {
                // 현재 물건의 무게가 배낭의 현재 무게 j보다 크면 넣을 수 없으므로,
                // 이전 물건(i-1)까지 고려했을 때의 결과를 그대로 가져온다.
                if(knapsack[i][0] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    // 현재 물건을 넣을 수 있다면,
                    // 1. 현재 물건을 넣지 않는 경우 (dp[i-1][j])
                    // 2. 현재 물건을 넣는 경우 (dp[i-1][j - knapsack[i][0]] + knapsack[i][1])
                    // 두 경우 중 더 큰 가치를 선택한다.
                                                        // [j - knapsack[i][0]: 현재 물건을 넣고 나면 남는 배낭의 남은 무게
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - knapsack[i][0]] + knapsack[i][1] );
                }
            }
        }
//        System.out.println(Arrays.deepToString(dp));

//        System.out.println(Arrays.deepToString(knapsack));
//        back(0, 0, 0);
        System.out.println(dp[iter][limit]);
    }

//    static void back(int startIdx, int accW, int accV) {
//        if(accW > limit) {
//            int prevAccV = accV - knapsack[startIdx-1][1];
//            max = Math.max(max, prevAccV);
//            return;
//        } else if(startIdx == knapsack.length) {
//            max = Math.max(max, accV);
//            return;
//        }
//
//        for (int i = startIdx; i < knapsack.length; i++) {
//            back(i+1 , accW + knapsack[i][0], accV + knapsack[i][1]);
//        }
//    }
}
