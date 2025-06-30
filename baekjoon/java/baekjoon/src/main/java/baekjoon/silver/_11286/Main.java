package baekjoon.silver._11286;

import java.io.*;
import java.util.*;

public class Main {
    /* s1
    절댓값 힙
    시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
    1 초 (추가 시간 없음) (하단 참고)	256 MB	72798	41696	32733	57.247%
    문제
    절댓값 힙은 다음과 같은 연산을 지원하는 자료구조이다.

    배열에 정수 x (x ≠ 0)를 넣는다.
    배열에서 절댓값이 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다.
    절댓값이 가장 작은 값이 여러개일 때는, 가장 작은 수를 출력하고, 그 값을 배열에서 제거한다.
    프로그램은 처음에 비어있는 배열에서 시작하게 된다.

    입력
    첫째 줄에 연산의 개수 N(1≤N≤100,000)이 주어진다.
    다음 N개의 줄에는 연산에 대한 정보를 나타내는 정수 x가 주어진다.
    만약 x가 0이 아니라면 배열에 x라는 값을 넣는(추가하는) 연산이고, x가 0이라면 배열에서 절댓값이 가장 작은 값을 출력하고 그 값을 배열에서 제거하는 경우이다.
    입력되는 정수는 -231보다 크고, 231보다 작다.

    출력
    입력에서 0이 주어진 회수만큼 답을 출력한다. 만약 배열이 비어 있는 경우인데 절댓값이 가장 작은 값을 출력하라고 한 경우에는 0을 출력하면 된다.
    */

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/silver/_11286/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int iter = Integer.parseInt(br.readLine());
        Queue<AbsHeap> pq = new PriorityQueue<>();
        for (int i = 0; i < iter; i++) {
            String line = br.readLine();
            if (line.equals("0")) {
                AbsHeap first = pq.poll();
                if (first == null) {
                    bw.write("0\n");
                } else {
                    bw.write(String.valueOf(first.element) + "\n");
                }
                continue;
            }
            pq.add(new AbsHeap(Integer.parseInt(line)));
        }
        bw.flush();
        bw.close();
    }

    static class AbsHeap implements Comparable<AbsHeap> {
        int element;

        public AbsHeap(int element) {
            this.element = element;
        }

        
        // this - o 가 오름차순으로 설계되어있다, this가 더 클 시 1, 같으면 0, this가 더 작다면 -1을 반환으로 기본 설계되어있음
        @Override
        public int compareTo(AbsHeap o) {
            int t1 = Math.abs(this.element);
            int t2 = Math.abs(o.element);

            if (t1 > t2) {
                return 1;
            }

            if (t1 == t2) {
                if (this.element > o.element) {
                    return 1;
                } else if (this.element == o.element) {
                    return 0;
                } else {
                    return -1;
                }
            }
            return -1;
        }
    }
}
