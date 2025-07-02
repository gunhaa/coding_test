package baekjoon.silver._15666;

import java.util.*;
import java.io.*;

public class Main {
    /* s2
    N과 M (12)
    시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
    2 초	512 MB	26580	20947	18064	79.413%
    문제
    N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

    N개의 자연수 중에서 M개를 고른 수열
    같은 수를 여러 번 골라도 된다.
    고른 수열은 비내림차순이어야 한다.
    길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.
    입력
    첫째 줄에 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)

    둘째 줄에 N개의 수가 주어진다. 입력으로 주어지는 수는 10,000보다 작거나 같은 자연수이다.

    출력
    한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다.
    중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.

    수열은 사전 순으로 증가하는 순서로 출력해야 한다.
    */

    static int len;
    static int[] list;
    static List<Integer> result = new ArrayList<>();
    static Set<String> duplicatedCheckSet = new HashSet<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/silver/_15666/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int listLen = Integer.parseInt(st1.nextToken());
        len = Integer.parseInt(st1.nextToken());
        list = new int[listLen];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < listLen; i++) {
            list[i] = Integer.parseInt(st2.nextToken());
        }
        Arrays.sort(list);
        System.out.println(Arrays.toString(list));
        back(0);
        System.out.println(sb);
    }

    static void back(int depth) {
        if(depth == len) {
            int[] temp = new int[len];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = result.get(i);
            }
            Arrays.sort(temp);
            if(duplicatedCheckSet.contains(Arrays.toString(temp))) {
                return;
            }
            duplicatedCheckSet.add(Arrays.toString(temp));
            for (int i = 0; i < temp.length; i++) {
                sb.append(Integer.valueOf(temp[i])).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < list.length; i++) {
            result.add(list[i]);
            back(depth + 1);
            result.remove(result.size()-1);
        }
    }
}
