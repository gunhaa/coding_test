package baekjoon.silver._1316;

import java.util.*;
import java.io.*;

public class Main {
    /* s5
    그룹 단어 체커
    시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
    2 초	128 MB	192305	103800	84922	54.197%
    문제
    그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다.
    예를 들면, ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고,
    kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만,
    aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.

    단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.

    입력
    첫째 줄에 단어의 개수 N이 들어온다. N은 100보다 작거나 같은 자연수이다.
    둘째 줄부터 N개의 줄에 단어가 들어온다. 단어는 알파벳 소문자로만 되어있고 중복되지 않으며, 길이는 최대 100이다.

    출력
    첫째 줄에 그룹 단어의 개수를 출력한다.
    */
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/silver/_1316/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        final int iter = Integer.parseInt(br.readLine());
        for (int i = 0; i < iter; i++) {
            String line = br.readLine();
            HashSet<Character> set = new HashSet<>();
            for (int j = 0; j < line.length(); j++) {
                char c = line.charAt(j);
                if(j == 0) {
                    if(line.length() == 1) {
                        result++;
                        break;
                    }
                    set.add(c);
                    continue;
                }

                if(line.charAt(j-1) == c) {
                    if(j == line.length()-1) {
                         result++;
                    }
                    continue;
                }else {
                    if(set.contains(c)) {
                        break;
                    }

                    if(j == line.length()-1) {
                        result++;
                    }
                    set.add(c);
                }
            }
        }

        System.out.println(result);
    }
}
