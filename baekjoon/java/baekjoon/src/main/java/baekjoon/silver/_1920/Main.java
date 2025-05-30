package baekjoon.silver._1920;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    /* https://www.acmicpc.net/problem/1920
    수 찾기
    시간 제한	메모리 제한
        1 초	128 MB
    문제
    N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.

    입력
    첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)이 주어진다.
    다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다.
    다음 줄에는 M(1 ≤ M ≤ 100,000)이 주어진다.
    다음 줄에는 M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아내면 된다. 모든 정수의 범위는 -2^31 보다 크거나 같고 2^31보다 작다.

    출력
    M개의 줄에 답을 출력한다. 존재하면 1을, 존재하지 않으면 0을 출력한다.
    */
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/silver/_1920/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < count; i++) {
            hashSet.add(Integer.parseInt(st.nextToken()));
        }

        int count2 = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < count2; i++) {
            if(hashSet.contains(Integer.parseInt(st2.nextToken()))){
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }

    }
}
