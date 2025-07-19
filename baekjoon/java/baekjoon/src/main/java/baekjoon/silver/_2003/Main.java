package baekjoon.silver._2003;

import java.util.*;
import java.io.*;

public class Main {
    /* s4
    수들의 합 2
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
0.5 초	128 MB	69198	33631	23206	48.450%
문제
N개의 수로 된 수열 A[1], A[2], …, A[N] 이 있다. 이 수열의 i번째 수부터 j번째 수까지의 합 A[i] + A[i+1] + … + A[j-1] + A[j]가 M이 되는 경우의 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N(1 ≤ N ≤ 10,000), M(1 ≤ M ≤ 300,000,000)이 주어진다. 다음 줄에는 A[1], A[2], …, A[N]이 공백으로 분리되어 주어진다. 각각의 A[x]는 30,000을 넘지 않는 자연수이다.

출력
첫째 줄에 경우의 수를 출력한다.
    */
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/silver/_2003/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());
        int[] arr = new int[N];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        int sum = 0;
        int pointerL = 0;
        int pointerR = 0;
        int answer = 0;

//        System.out.println(Arrays.toString(arr));
        // N개의 수열
        // 연속된 수열의 합 M
        while(pointerR <= arr.length) {
            if(sum == M) {
                answer++;
                sum -= arr[pointerL];
                pointerL++;
            } else if(sum > M) {
                sum -= arr[pointerL];
                pointerL++;
            } else if(sum < M) {
                if(pointerR == arr.length) {
                    while(pointerL < arr.length) {
                        if(sum == M) {
                            answer++;
                        }
                        sum -= arr[pointerL];
                        pointerL++;
                    }
                    break;
                }
                sum += arr[pointerR];
                pointerR++;
            }
        }

        System.out.println(answer);
    }

}
