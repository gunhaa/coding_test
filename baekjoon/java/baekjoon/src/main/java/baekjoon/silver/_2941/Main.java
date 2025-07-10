package baekjoon.silver._2941;

import java.io.*;
import java.util.*;

public class Main {
    /* s5
    크로아티아 알파벳 다국어
    시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
    1 초	128 MB	214704	96623	81022	44.811%
    문제
    예전에는 운영체제에서 크로아티아 알파벳을 입력할 수가 없었다. 따라서, 다음과 같이 크로아티아 알파벳을 변경해서 입력했다.

    크로아티아 알파벳	변경
    č	c=
    ć	c-
    dž	dz=
    đ	d-
    lj	lj
    nj	nj
    š	s=
    ž	z=
    예를 들어, ljes=njak은 크로아티아 알파벳 6개(lj, e, š, nj, a, k)로 이루어져 있다. 단어가 주어졌을 때, 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.

    dž는 무조건 하나의 알파벳으로 쓰이고, d와 ž가 분리된 것으로 보지 않는다. lj와 nj도 마찬가지이다. 위 목록에 없는 알파벳은 한 글자씩 센다.

    입력
    첫째 줄에 최대 100글자의 단어가 주어진다. 알파벳 소문자와 '-', '='로만 이루어져 있다.

    단어는 크로아티아 알파벳으로 이루어져 있다. 문제 설명의 표에 나와있는 알파벳은 변경된 형태로 입력된다.

    출력
    입력으로 주어진 단어가 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.
    */
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/silver/_2941/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int result = 0;
        int i;
        for (i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            switch (c) {
                case 'c': {
                    if (i + 1 < input.length()) {
                        char nextC = input.charAt(i + 1);
                        if (nextC == '=' || nextC == '-') {
                            i++;
                        }
                    }
                    result++;
                }
                break;
                case 'd': {
                    if (i + 1 < input.length()) {
                        char nextC1 = input.charAt(i + 1);
                        if (nextC1 == '-') {
                            i++;
                        } else if (nextC1 == 'z') {
                            if (i + 2 < input.length()) {
                                char nextC2 = input.charAt(i + 2);
                                if (nextC2 == '=') {
                                    i += 2;
                                }
                            }
                        }
                    }
                    result++;
                }
                break;
                case 'l': {
                    if (i + 1 < input.length()) {
                        char nextC1 = input.charAt(i + 1);
                        if (nextC1 == 'j') {
                            i++;
                        }
                    }
                    result++;
                }
                break;
                case 'n': {
                    if (i + 1 < input.length()) {
                        char nextC1 = input.charAt(i + 1);
                        if (nextC1 == 'j') {
                            i++;
                        }
                    }
                    result++;
                }
                break;
                case 's': {
                    if (i + 1 < input.length()) {
                        char nextC1 = input.charAt(i + 1);
                        if (nextC1 == '=') {
                            i++;
                        }
                    }
                    result++;
                }
                break;
                case 'z': {
                    if (i + 1 < input.length()) {
                        char nextC1 = input.charAt(i + 1);
                        if (nextC1 == '=') {
                            i++;
                        }
                    }
                    result++;
                }
                break;
                default: {
                    result++;
                }
            }
        }
        System.out.println(result);
    }

}
