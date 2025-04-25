package baekjoon.silver._1181;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    /* https://www.acmicpc.net/problem/1181
    단어 정렬
    시간 제한	메모리 제한
        2 초	256 MB
    문제
    알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.

    길이가 짧은 것부터 길이가 같으면 사전 순으로 단, 중복된 단어는 하나만 남기고 제거해야 한다.

    입력
    첫째 줄에 단어의 개수 N이 주어진다. (1 ≤ N ≤ 20,000) 둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다. 주어지는 문자열의 길이는 50을 넘지 않는다.

    출력
    조건에 따라 정렬하여 단어들을 출력한다.
    */

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/silver/_1181/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<String> set = new HashSet<>();

        int count = Integer.parseInt(br.readLine());
        for(int i=0; i<count; i++){
            set.add(br.readLine());
        }
        List<String> answer = set.stream().sorted(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder())).collect(Collectors.toList());

        for(String s : answer) {
            bw.write(s);
            bw.newLine();
        }
        bw.flush();
    }

}
