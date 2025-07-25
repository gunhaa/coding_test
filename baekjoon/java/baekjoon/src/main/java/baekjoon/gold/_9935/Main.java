package baekjoon.gold._9935;

import java.util.*;
import java.io.*;

public class Main {

    /* g4
    문자열 폭발 다국어
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초 (추가 시간 없음)	128 MB	104084	29608	20892	27.442%
문제
상근이는 문자열에 폭발 문자열을 심어 놓았다. 폭발 문자열이 폭발하면 그 문자는 문자열에서 사라지며, 남은 문자열은 합쳐지게 된다.

폭발은 다음과 같은 과정으로 진행된다.

문자열이 폭발 문자열을 포함하고 있는 경우에, 모든 폭발 문자열이 폭발하게 된다.
남은 문자열을 순서대로 이어 붙여 새로운 문자열을 만든다.
새로 생긴 문자열에 폭발 문자열이 포함되어 있을 수도 있다.
폭발은 폭발 문자열이 문자열에 없을 때까지 계속된다.
상근이는 모든 폭발이 끝난 후에 어떤 문자열이 남는지 구해보려고 한다.
남아있는 문자가 없는 경우가 있다. 이때는 "FRULA"를 출력한다.

폭발 문자열은 같은 문자를 두 개 이상 포함하지 않는다.

입력
첫째 줄에 문자열이 주어진다. 문자열의 길이는 1보다 크거나 같고, 1,000,000보다 작거나 같다.

둘째 줄에 폭발 문자열이 주어진다. 길이는 1보다 크거나 같고, 36보다 작거나 같다.

두 문자열은 모두 알파벳 소문자와 대문자, 숫자 0, 1, ..., 9로만 이루어져 있다.

출력
첫째 줄에 모든 폭발이 끝난 후 남은 문자열을 출력한다.
    */
    static final String NULL = "FRULA";

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/gold/_9935/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        char[] bomb = br.readLine().toCharArray();
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < chars.length; i++) {
            stack.push(chars[i]);
            if(stack.size() >= bomb.length) {
                boolean isSerial = true;
                for (int j = 0; j < bomb.length; j++) {
//                    System.out.println("stack.size() = " + stack.size());
//                    System.out.println("j = " + j);
//                    System.out.println("get: " + stack.get(stack.size()-j-1));
                    if(bomb[bomb.length-j-1] != stack.get(stack.size()-j-1)) {
                        isSerial = false;
                        break;
                    }
                }
                
                if(isSerial) {
                    for(int j = 0; j< bomb.length; j++) {
                        stack.pop();
                    }
                }
            }
        }

        if(stack.isEmpty()) {
            System.out.println(NULL);
            return;
        }

        for (int i = 0; i < stack.size(); i++) {
            result.append(stack.get(i));
        }
        System.out.println(result);
    }
}
