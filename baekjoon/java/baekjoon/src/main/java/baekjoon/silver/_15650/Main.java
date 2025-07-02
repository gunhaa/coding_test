package baekjoon.silver._15650;

import java.util.*;
import java.io.*;

public class Main {

    /* s3
    N과 M (2)
    시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
    1 초	512 MB	99706	74490	52150	73.920%
    문제
    자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

    1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
    고른 수열은 오름차순이어야 한다.
    입력
    첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)

    출력
    한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.

    수열은 사전 순으로 증가하는 순서로 출력해야 한다.
    */

    static int len;
    static StringBuilder sb = new StringBuilder();
    static int[] list;
    static List<Integer> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/silver/_15650/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int iter = Integer.parseInt(st.nextToken());
        len = Integer.parseInt(st.nextToken());

        list = new int[iter+1];
        for (int i = 1; i <= iter; i++) {
            list[i] = i;
        }
//        System.out.println(Arrays.toString(list));

        back(1, 0);
        System.out.println(sb);
    }

    static void back(int start, int depth) {
        if(depth == len) {
            for (int item : result) {
                sb.append(item).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < list.length; i++) {
            result.add(list[i]);
            back(i+1, depth+1);
            result.remove(result.size()-1);
        }
    }
}
