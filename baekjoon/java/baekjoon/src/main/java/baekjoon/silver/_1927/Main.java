package baekjoon.silver._1927;

import java.io.*;
import java.util.PriorityQueue;

public class Main {
    /*
    최소 힙
    시간 제한	  메모리 제한	                 제출     정답	맞힌 사람	정답 비율
    1 초 (추가 시간 없음) (하단 참고)	128 MB	107243	51925	41004	49.417%

    문제
    널리 잘 알려진 자료구조 중 최소 힙이 있다. 최소 힙을 이용하여 다음과 같은 연산을 지원하는 프로그램을 작성하시오.

    배열에 자연수 x를 넣는다.
    배열에서 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다.
    프로그램은 처음에 비어있는 배열에서 시작하게 된다.

    입력
    첫째 줄에 연산의 개수 N(1 ≤ N ≤ 100,000)이 주어진다. 다음 N개의 줄에는 연산에 대한 정보를 나타내는 정수 x가 주어진다.
    만약 x가 자연수라면 배열에 x라는 값을 넣는(추가하는) 연산이고, x가 0이라면 배열에서 가장 작은 값을 출력하고 그 값을 배열에서 제거하는 경우이다.
    x는 231보다 작은 자연수 또는 0이고, 음의 정수는 입력으로 주어지지 않는다.

    출력
    입력에서 0이 주어진 횟수만큼 답을 출력한다. 만약 배열이 비어 있는 경우인데 가장 작은 값을 출력하라고 한 경우에는 0을 출력하면 된다.
    */
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/silver/_1927/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<count; i++){
            int line = Integer.parseInt(br.readLine());
            if(line == 0) {
                if(pq.isEmpty()) {
                    System.out.println("0");
                } else {
                    Integer root = pq.poll();
                    System.out.println(root);
                }
            } else {
                pq.add(line);
            }
        }
    }
}
