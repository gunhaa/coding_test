package baekjoon.bronze._4153;

import java.io.*;
import java.util.*;

public class Main {
    /* https://www.acmicpc.net/problem/4153
    직각삼각형
    시간 제한	메모리 제한
        1 초	128 MB
    문제
    과거 이집트인들은 각 변들의 길이가 3, 4, 5인 삼각형이 직각 삼각형인것을 알아냈다.
    주어진 세변의 길이로 삼각형이 직각인지 아닌지 구분하시오.

    입력
    입력은 여러개의 테스트케이스로 주어지며 마지막줄에는 0 0 0이 입력된다.
    각 테스트케이스는 모두 30,000보다 작은 양의 정수로 주어지며, 각 입력은 변의 길이를 의미한다.

    출력
    각 입력에 대해 직각 삼각형이 맞다면 "right", 아니라면 "wrong"을 출력한다.
    */

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/bronze/_4153/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        for(;;){
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Double> list = new ArrayList<>();
            list.add(Double.parseDouble(st.nextToken()));
            list.add(Double.parseDouble(st.nextToken()));
            list.add(Double.parseDouble(st.nextToken()));
            Collections.sort(list);
            if(list.get(0)==0 && list.get(1)==0 && list.get(2)==0) {
                break;
            }

            if(isRight(list)){
                sb.append("right\n");
            } else {
                sb.append("wrong\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }

    private static boolean isRight(List<Double> list){
        return (Math.pow(list.get(0), 2) + Math.pow(list.get(1) , 2)) == Math.pow(list.get(2), 2);
    }
}
