package baekjoon.silver._15663;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /* s2
    N과 M (9)
    시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
    1 초	512 MB	55647	28101	21442	49.478%
    문제
    N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

    N개의 자연수 중에서 M개를 고른 수열
    입력
    첫째 줄에 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)

    둘째 줄에 N개의 수가 주어진다. 입력으로 주어지는 수는 10,000보다 작거나 같은 자연수이다.

    출력
    한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.

    수열은 사전 순으로 증가하는 순서로 출력해야 한다.
    */
    static int len;
    static int listLen;
    static Set<String> duplicatedCheckSet = new HashSet<>();
    static List<Integer> result = new ArrayList<>();
    static List<Integer> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/silver/_15663/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        listLen = Integer.parseInt(st1.nextToken());
        len = Integer.parseInt(st1.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        visited = new boolean[listLen];
        for (int i = 0; i < listLen; i++) {
            list.add(Integer.parseInt(st2.nextToken()));
        }
        Collections.sort(list);
        System.out.println(list);

        back(0);
        System.out.println(sb);
    }


    static void back(int depth) {
        if (depth == len) {
            StringBuilder temp = new StringBuilder();
            for (int i : result) {
                temp.append(i).append(" ");
            }
            temp.append("\n");
            if(duplicatedCheckSet.contains(temp.toString())) {
                return;
            }
            sb.append(temp);
            duplicatedCheckSet.add(temp.toString());
            return;
        }

        for (int i = 0; i < listLen; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            result.add(list.get(i));
            back(depth + 1);
            result.remove(result.size() - 1);
            visited[i] = false;
        }
    }
}
