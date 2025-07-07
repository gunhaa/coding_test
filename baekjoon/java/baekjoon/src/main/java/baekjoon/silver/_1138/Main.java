package baekjoon.silver._1138;

import java.util.*;
import java.io.*;

public class Main {

    /* s2
    한 줄로 서기
    시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
    2 초	128 MB	19889	12441	10401	63.036%
    문제
    N명의 사람들은 매일 아침 한 줄로 선다. 이 사람들은 자리를 마음대로 서지 못하고 오민식의 지시대로 선다.

    어느 날 사람들은 오민식이 사람들이 줄 서는 위치를 기록해 놓는다는 것을 알았다.
    그리고 아침에 자기가 기록해 놓은 것과 사람들이 줄을 선 위치가 맞는지 확인한다.

    사람들은 자기보다 큰 사람이 왼쪽에 몇 명 있었는지만을 기억한다.
    N명의 사람이 있고, 사람들의 키는 1부터 N까지 모두 다르다.

    각 사람들이 기억하는 정보가 주어질 때, 줄을 어떻게 서야 하는지 출력하는 프로그램을 작성하시오.

    입력
    첫째 줄에 사람의 수 N이 주어진다. N은 10보다 작거나 같은 자연수이다.
    둘째 줄에는 키가 1인 사람부터 차례대로 자기보다 키가 큰 사람이 왼쪽에 몇 명이 있었는지 주어진다.
    i번째 수는 0보다 크거나 같고, N-i보다 작거나 같다. i는 0부터 시작한다.

    출력
    첫째 줄에 줄을 선 순서대로 키를 출력한다.
    */
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/silver/_1138/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int iter = Integer.parseInt(br.readLine());
        int[] people = new int[iter];
        int[] answer = new int[iter];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < iter; i++) {
            int left = Integer.parseInt(st.nextToken());
            people[i] = left;
        }
//        System.out.println(Arrays.toString(people));
        // people[idx] idx가 키 순서
        // 내 키번호(idx)를 이용함
        for (int i = 0; i < iter; i++) {
            // 나보다 큰 사람 수
            int count = 0;
            // 현재 idx
            int cnt = 0;
            int left = people[i];
            while(count < left || answer[cnt] != 0) {
                if(answer[cnt] == 0 ) {
                    count++;
                }
                cnt++;
            }

            while(answer[cnt] != 0) {
                cnt++;
            }
            answer[cnt] = i+1;
        }

        for (int x : answer) {
            System.out.print(x + " ");
        }
    }
}
