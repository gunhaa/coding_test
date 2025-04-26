package baekjoon.silver._1654;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    /* https://www.acmicpc.net/problem/1654

    랜선 자르기
    시간 제한	메모리 제한
        2 초	128 MB
    문제
    집에서 시간을 보내던 오영식은 박성원의 부름을 받고 급히 달려왔다. 박성원이 캠프 때 쓸 N개의 랜선을 만들어야 하는데 너무 바빠서 영식이에게 도움을 청했다.

    이미 오영식은 자체적으로 K개의 랜선을 가지고 있다. 그러나 K개의 랜선은 길이가 제각각이다.
    박성원은 랜선을 모두 N개의 같은 길이의 랜선으로 만들고 싶었기 때문에 K개의 랜선을 잘라서 만들어야 한다.
    예를 들어 300cm 짜리 랜선에서 140cm 짜리 랜선을 두 개 잘라내면 20cm는 버려야 한다. (이미 자른 랜선은 붙일 수 없다.)

    편의를 위해 랜선을 자르거나 만들 때 손실되는 길이는 없다고 가정하며, 기존의 K개의 랜선으로 N개의 랜선을 만들 수 없는 경우는 없다고 가정하자.
    그리고 자를 때는 항상 센티미터 단위로 정수길이만큼 자른다고 가정하자. N개보다 많이 만드는 것도 N개를 만드는 것에 포함된다. 이때 만들 수 있는 최대 랜선의 길이를 구하는 프로그램을 작성하시오.

    입력
    첫째 줄에는 오영식이 이미 가지고 있는 랜선의 개수 K, 그리고 필요한 랜선의 개수 N이 입력된다.
    K는 1이상 10,000이하의 정수이고, N은 1이상 1,000,000이하의 정수이다. 그리고 항상 K ≦ N 이다. 그 후 K줄에 걸쳐 이미 가지고 있는 각 랜선의 길이가 센티미터 단위의 정수로 입력된다.
    랜선의 길이는 231-1보다 작거나 같은 자연수이다.

    출력
    첫째 줄에 N개를 만들 수 있는 랜선의 최대 길이를 센티미터 단위의 정수로 출력한다.
    */

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/silver/_1654/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<count; i++){
            list.add(Integer.parseInt(br.readLine()));
        }

        // 최대값
        long max = -1;
        for(Integer i : list){
            if(i > max){
                max = i;
            }
        }

        long start = 1;
        long answer = 0;
        while(start <= max){
            // 오버플로우 위험
            long mid = start + (max - start) / 2;
            long lanCount = lanCount(list, mid);

            if(lanCount < target){
                max = mid - 1;
            } else {
                start = mid + 1;
                answer = mid;
            }
        }
        System.out.println(answer);
    }

    private static int lanCount(List<Integer> list, long mid){
        int count = 0;
        for (Integer i : list) {
            long lan = i/mid;
            count += lan;
        }
        return count;
    }
}