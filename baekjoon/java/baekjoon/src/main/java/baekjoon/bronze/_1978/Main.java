package baekjoon.bronze._1978;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    /* https://www.acmicpc.net/problem/1978
        소수 찾기
        시간 제한	메모리 제한
            2 초	128 MB
        문제
        주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.

        입력
        첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.

        출력
        주어진 수들 중 소수의 개수를 출력한다.
    */

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/bronze/_1978/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        int result = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<count; i++){
            int item = Integer.parseInt(st.nextToken());
            boolean isPrimitive = isPrimitive(item);

            if(isPrimitive){
                result++;
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
    }

    private static boolean isPrimitive(int item){
        if(item == 1){
            return false;
        }

        for (int j = 2; j <= Math.sqrt(item); j++) {
            if(item%j == 0){
                return false;
            }
        }
        return true;
    }
}
