package baekjoon.bronze._10989;

import java.util.*;
import java.io.*;

public class Main {
    /* b1
수 정렬하기 3 언어 제한
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
5 초 (하단 참고)	8 MB (하단 참고)	359769	86756	66410	23.998%
문제
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

입력
첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 10,000보다 작거나 같은 자연수이다.

출력
첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
    */
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/bronze/_10989/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        for (int i = 0; i < N; i++) {
//            pq.add(Integer.parseInt(br.readLine()));
//        }
//
//        for (int i = 0; i < N; i++) {
//            bw.write(pq.poll()+"\n");
//        }

//        Map<Integer, Integer> countMap = new TreeMap<>();
//        for (int i = 0; i < N; i++) {
//            int cur = Integer.parseInt(br.readLine());
//            countMap.put(cur, countMap.getOrDefault(cur, 0) + 1);
//        }
//
//        for(Map.Entry<Integer, Integer> entry: countMap.entrySet()) {
//            Integer key = entry.getKey();
//            Integer value = entry.getValue();
//            for (int i = 0; i < value; i++) {
//                bw.write(key+"\n");
//            }
//        }

        int[] countArr = new int[10001];
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(br.readLine());
            countArr[cur] += 1;
        }

        for (int i = 1; i < countArr.length; i++) {
            if(countArr[i] != 0) {
                for (int j = 0; j < countArr[i]; j++) {
                    bw.write(i+"\n");
                }
            }
        }
        bw.flush();
    }
}
