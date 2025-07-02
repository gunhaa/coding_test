package baekjoon.silver._15652;

import java.util.*;
import java.io.*;

public class Main {

    /* s3
    N과 M (4)
    시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
    1 초	512 MB	70517	55513	43905	78.628%
    문제
    자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

    1부터 N까지 자연수 중에서 M개를 고른 수열
    같은 수를 여러 번 골라도 된다.
    고른 수열은 비내림차순이어야 한다.
    길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.
    입력
    첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)

    출력
    한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.

    수열은 사전 순으로 증가하는 순서로 출력해야 한다.
    */

    static int iter;
    static int select;
    static StringBuilder sb = new StringBuilder();
    static int[] sequence;
    static List<Integer> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/silver/_15652/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        iter = Integer.parseInt(st.nextToken());
        select = Integer.parseInt(st.nextToken());
        sequence = new int[iter+1];
        for (int i = 1; i < sequence.length; i++) {
            sequence[i] = i;
        }

        back(1, 0);
//        System.out.println(Arrays.toString(sequence));
        System.out.println(sb);
    }

    static void back(int start, int depth) {
        if(depth == select) {
            for (int i : result) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < sequence.length; i++) {
            result.add(sequence[i]);
            back(i, depth+1);
            result.remove(result.size()-1);
        }
    }

}
