package baekjoon.silver._1475;

import java.util.*;
import java.io.*;

public class Main {
    /*
    방 번호
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	128 MB	81213	37234	28170	44.522%
문제
다솜이는 은진이의 옆집에 새로 이사왔다. 다솜이는 자기 방 번호를 예쁜 플라스틱 숫자로 문에 붙이려고 한다.

다솜이의 옆집에서는 플라스틱 숫자를 한 세트로 판다.
한 세트에는 0번부터 9번까지 숫자가 하나씩 들어있다.
다솜이의 방 번호가 주어졌을 때, 필요한 세트의 개수의 최솟값을 출력하시오.
(6은 9를 뒤집어서 이용할 수 있고, 9는 6을 뒤집어서 이용할 수 있다.)

입력
첫째 줄에 다솜이의 방 번호 N이 주어진다. N은 1,000,000보다 작거나 같은 자연수이다.

출력
첫째 줄에 필요한 세트의 개수를 출력한다.
    */
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/silver/_1475/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int[] results = new int[11];
        for (char c : line.toCharArray()) {
            int i = c - '0';
            results[i]++;
        }

        int counts = results[6]+results[9];
        double result = Math.ceil((double) counts / 2);
        results[6] = (int)result;
        results[9] = (int)result;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= 9; i++) {
            max = Math.max(results[i], max);
        }
        System.out.println(max);
    }

}
