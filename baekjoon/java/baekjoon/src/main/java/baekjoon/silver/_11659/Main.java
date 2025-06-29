package baekjoon.silver._11659;

import java.util.*;
import java.io.*;


public class Main {
    /* s3
    구간 합 구하기 4
    시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
    1 초	256 MB	158441	65107	47199	38.430%
    문제
    수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합을 구하는 프로그램을 작성하시오.

    입력
    첫째 줄에 수의 개수 N과 합을 구해야 하는 횟수 M이 주어진다. 둘째 줄에는 N개의 수가 주어진다.
    수는 1,000보다 작거나 같은 자연수이다. 셋째 줄부터 M개의 줄에는 합을 구해야 하는 구간 i와 j가 주어진다.

    출력
    총 M개의 줄에 입력으로 주어진 i번째 수부터 j번째 수까지 합을 출력한다.

    제한
    1 ≤ N ≤ 100,000
    1 ≤ M ≤ 100,000
    1 ≤ i ≤ j ≤ N
    */
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/silver/_11659/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int len = Integer.parseInt(st1.nextToken());
        int iter = Integer.parseInt(st1.nextToken());
        int[] nums = new int[len];
        int[] cache = new int[100001];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < len; i++) {
            nums[i] = Integer.parseInt(st2.nextToken());
        }
//        System.out.println(Arrays.toString(nums));

        int sum = 0;
        for (int i = 1; i < nums.length+1; i++) {
            sum += nums[i-1];
            cache[i] += sum;
        }

//        System.out.println(Arrays.toString(cache));

        for (int i = 0; i < iter; i++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st3.nextToken()) - 1;
            int end = Integer.parseInt(st3.nextToken());
            // cache[end] - cache[start] , 0이라면 갱신
            int result = cache[end] - cache[start];
            bw.write(String.valueOf(result)+"\n");
        }
        bw.flush();
        bw.close();
    }
}