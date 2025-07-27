package baekjoon.silver._16953;

import java.util.*;
import java.io.*;

public class Main {
    /* s2
    A → B
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	512 MB	72610	30304	23842	40.094%
문제
정수 A를 B로 바꾸려고 한다. 가능한 연산은 다음과 같은 두 가지이다.

2를 곱한다.
1을 수의 가장 오른쪽에 추가한다.
A를 B로 바꾸는데 필요한 연산의 최솟값을 구해보자.

입력
첫째 줄에 A, B (1 ≤ A < B ≤ 10^9)가 주어진다.

출력
A를 B로 바꾸는데 필요한 연산의 최솟값에 1을 더한 값을 출력한다. 만들 수 없는 경우에는 -1을 출력한다.
    */

    static Queue<Operand> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/silver/_16953/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int min = bfs(A, B);
        System.out.println(min);
    }

    static int bfs(int start, int target) {
        queue.add(new Operand(start, 1));
        while(!queue.isEmpty()) {
            Operand cur = queue.poll();
            if(cur.value == target) {
                return cur.count;
            }
            if(cur.value > target) {
                continue;
            }
            int count = cur.count+1;
            long planA = cur.value*2;
            long planB = cur.value*10 + 1;

            queue.add(new Operand(planA, count));
            queue.add(new Operand(planB, count));
        }
        return -1;
    }

    static class Operand {
        long value;
        int count;

        public Operand(long value, int count) {
            this.value = value;
            this.count = count;
        }
    }
}
