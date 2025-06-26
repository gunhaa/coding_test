package baekjoon.silver._10845;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    /* s4
    큐
    시간 제한	            메모리 제한	제출	정답	맞힌 사람	정답 비율
    0.5 초 (추가 시간 없음)	    256 MB	155543	74496	58564	49.521%
    문제
    정수를 저장하는 큐를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

    명령은 총 여섯 가지이다.

    push X: 정수 X를 큐에 넣는 연산이다.
    pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    size: 큐에 들어있는 정수의 개수를 출력한다.
    empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
    front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    입력
    첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다. 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다.
     주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다. 문제에 나와있지 않은 명령이 주어지는 경우는 없다.

    출력
    출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.

    */

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/silver/_10845/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int iter = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < iter; i++) {
            String line = br.readLine();

            if (line.startsWith("push")) {
                String arg = line.split(" ")[1];
                queue.offer(Integer.parseInt(arg));
//                System.out.println(arg);
                continue;
            }

            if (line.startsWith("pop")) {
                if (queue.isEmpty()) {
                    System.out.println(-1);
                    continue;
                }
                Integer first = queue.pollFirst();
                System.out.println(first);
                continue;
            }

            switch (line) {
                case "front": {
                    if (queue.isEmpty()) {
                        System.out.println(-1);
                        break;
                    }
                    Integer old = queue.peekFirst();
                    System.out.println(old);
                    break;
                }
                case "back": {
                    if (queue.isEmpty()) {
                        System.out.println(-1);
                        break;
                    }
                    Integer recent = queue.peekLast();
                    System.out.println(recent);
                    break;
                }
                case "size": {
                    System.out.println(queue.size());
                    break;
                }
                case "empty": {
                    if (queue.isEmpty()) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;
                }
            }
        }
    }
}
