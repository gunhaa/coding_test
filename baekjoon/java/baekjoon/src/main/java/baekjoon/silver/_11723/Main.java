package baekjoon.silver._11723;

import java.util.*;
import java.io.*;

public class Main {
    /* s5
    집합 언어 제한
    시간 제한	    메모리 제한	제출	정답	맞힌 사람	정답 비율
         1.5 초	4 MB (하단 참고)	144362	44758	33058	29.726%
    문제
    비어있는 공집합 S가 주어졌을 때, 아래 연산을 수행하는 프로그램을 작성하시오.

    add x: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
    remove x: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
    check x: S에 x가 있으면 1을, 없으면 0을 출력한다. (1 ≤ x ≤ 20)
    toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
    all: S를 {1, 2, ..., 20} 으로 바꾼다.
    empty: S를 공집합으로 바꾼다.
    입력
    첫째 줄에 수행해야 하는 연산의 수 M (1 ≤ M ≤ 3,000,000)이 주어진다.

    둘째 줄부터 M개의 줄에 수행해야 하는 연산이 한 줄에 하나씩 주어진다.

    출력
    check 연산이 주어질때마다, 결과를 출력한다.
    */
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("src/main/java/baekjoon/silver/_11723/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int iter = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iter; i++) {
            String[] line = br.readLine().split(" ");
            String operation = line[0];
            int argument = 0;

            if(!operation.equals("all") && !operation.equals("empty")) {
                argument = Integer.parseInt(line[1]);
            }

            switch(operation) {
                case "add": {
                    set.add(argument);
                    break;
                }
                case "remove": {
                    set.remove(argument);
                    break;
                }
                case "check": {
                    if(set.contains(argument)) {
//                        System.out.println(1);
                        sb.append(1+"\n");
                        break;
                    }
//                    System.out.println(0);
                    sb.append(0+"\n");
                    break;
                }
                case "toggle": {
                    if(set.contains(argument)) {
                        set.remove(argument);
                        break;
                    }
                    set.add(argument);
                    break;
                }
                case "all": {
                    set.clear();
                    for (int j = 1; j <= 20; j++) {
                        set.add(j);
                    }
                    break;
                }
                case "empty": {
                    set.clear();
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}