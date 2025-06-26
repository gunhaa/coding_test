package baekjoon.silver._1764;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
    듣보잡
    시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
        2 초	256 MB	140660	61641	48366	42.119%
    문제
    김진영이 듣도 못한 사람의 명단과, 보도 못한 사람의 명단이 주어질 때, 듣도 보도 못한 사람의 명단을 구하는 프로그램을 작성하시오.

    입력
    첫째 줄에 듣도 못한 사람의 수 N, 보도 못한 사람의 수 M이 주어진다.
    이어서 둘째 줄부터 N개의 줄에 걸쳐 듣도 못한 사람의 이름과, N+2째 줄부터 보도 못한 사람의 이름이 순서대로 주어진다.
    이름은 띄어쓰기 없이 알파벳 소문자로만 이루어지며, 그 길이는 20 이하이다. N, M은 500,000 이하의 자연수이다.

    듣도 못한 사람의 명단에는 중복되는 이름이 없으며, 보도 못한 사람의 명단도 마찬가지이다.

    출력
    듣보잡의 수와 그 명단을 사전순으로 출력한다.
    */
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/silver/_1764/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> duplicatedCheckMap = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int iter1 = Integer.parseInt(st.nextToken());
        int iter2 = Integer.parseInt(st.nextToken());
        List<String> result = new ArrayList<>();
        for (int i = 0; i < (iter1+iter2); i++) {
            String line = br.readLine();
            duplicatedCheckMap.put(line, duplicatedCheckMap.getOrDefault(line, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : duplicatedCheckMap.entrySet()) {
            if(entry.getValue() > 1) {
                result.add(entry.getKey());
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        for (String s : result) {
            System.out.println(s);
        }
    }
}
