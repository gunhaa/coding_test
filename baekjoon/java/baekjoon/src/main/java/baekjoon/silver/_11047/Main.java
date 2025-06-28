package baekjoon.silver._11047;
import java.util.*;
import java.io.*;

public class Main {
    /* s4
    동전 0
    시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
    1 초	256 MB	175217	95694	72712	53.488%
    문제
    준규가 가지고 있는 동전은 총 N종류이고, 각각의 동전을 매우 많이 가지고 있다.

    동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 한다. 이때 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성하시오.

    입력
    첫째 줄에 N과 K가 주어진다. (1 ≤ N ≤ 10, 1 ≤ K ≤ 100,000,000)

    둘째 줄부터 N개의 줄에 동전의 가치 Ai가 오름차순으로 주어진다. (1 ≤ Ai ≤ 1,000,000, A1 = 1, i ≥ 2인 경우에 Ai는 Ai-1의 배수)

    출력
    첫째 줄에 K원을 만드는데 필요한 동전 개수의 최솟값을 출력한다.
    */
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/silver/_11047/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstLine = br.readLine();
        StringTokenizer st = new StringTokenizer(firstLine);
        int iter = Integer.parseInt(st.nextToken());
        int object = Integer.parseInt(st.nextToken());
        List<Integer> wallet = new ArrayList<>();
        for (int i = 0; i < iter; i++) {
            wallet.add(Integer.parseInt(br.readLine()));
        }
        int sum = 0;
        int acc = 0;
        int remain = object - sum;
        while(object != sum) {
            acc++;

            int walletSize = wallet.size();

            for(int i = walletSize-1; i >= 0; i--) {
                Integer coin = wallet.get(i);
                if(coin > remain) {
                    wallet.remove(coin);
                    continue;
                }

                sum += coin;
                remain -= coin;
                break;
            }
        }
        System.out.println(acc);
    }
}
