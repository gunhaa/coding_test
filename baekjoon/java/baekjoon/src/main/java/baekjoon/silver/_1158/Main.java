package baekjoon.silver._1158;

import java.util.*;
import java.io.*;

public class Main {

    /* s4
    요세푸스 문제
    시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
    2 초	256 MB	135390	68431	47927	49.292%
    문제
    요세푸스 문제는 다음과 같다.

    1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고,
    양의 정수 K(≤ N)가 주어진다. 이제 순서대로 K번째 사람을 제거한다.
    한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다. 이 과정은 N명의 사람이 모두 제거될 때까지 계속된다.
    원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다. 예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.

    N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.

    입력
    첫째 줄에 N과 K가 빈 칸을 사이에 두고 순서대로 주어진다. (1 ≤ K ≤ N ≤ 5,000)

    출력
    예제와 같이 요세푸스 순열을 출력한다.
    */
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/silver/_1158/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken())-1;
//        int[] circle = new int[N];
        List<Integer> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        // circle[idx] idx+1 = 사람숫자
        for (int i = 0; i < N; i++) {
//            circle[i] = i+1;
            list.add(i+1);
        }
//        System.out.println(list);
//        System.out.println(Arrays.toString(circle));
        int cnt = 0;
        while(!list.isEmpty()) {
            cnt += K;
            cnt %= list.size();
            result.add(list.get(cnt));
            list.remove(cnt);
        }
//        System.out.println(list);
//        System.out.println(result);
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (int i = 0; i < result.size(); i++) {
            if(i==result.size()-1){
                sb.append(result.get(i)).append(">");
                break;
            }
            sb.append(result.get(i)).append(", ");
        }
        System.out.println(sb);
    }
}
