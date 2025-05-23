package baekjoon.gold._1931;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main2 {
        /* https://www.acmicpc.net/problem/1931
    회의실 배정
    시간 제한	메모리 제한
         2 초	128 MB
    문제
    한 개의 회의실이 있는데 이를 사용하고자 하는 N개의 회의에 대하여 회의실 사용표를 만들려고 한다.
    각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 찾아보자.
    단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.
    회의의 시작시간과 끝나는 시간이 같을 수도 있다. 이 경우에는 시작하자마자 끝나는 것으로 생각하면 된다.

    입력
    첫째 줄에 회의의 수 N(1 ≤ N ≤ 100,000)이 주어진다.
    둘째 줄부터 N+1 줄까지 각 회의의 정보가 주어지는데 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다.
    시작 시간과 끝나는 시간은 2^31-1보다 작거나 같은 자연수 또는 0이다.

    출력
    첫째 줄에 최대 사용할 수 있는 회의의 최대 개수를 출력한다.
    */

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/gold/_1931/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;
        int count = Integer.parseInt(br.readLine());
        List<long[]> meetingList = new ArrayList<>();
        for (int i=0; i<count; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long h = Long.parseLong(st.nextToken());
            long m = Long.parseLong(st.nextToken());
            meetingList.add(new long[]{h,m});
        }


        meetingList.sort((a, b) -> {
            if (a[1] == b[1]){
                return Long.compare(a[0], b[0]);
            }
            return Long.compare(a[1], b[1]);
        });

        long lastFinish = -1;
        for (long[] meeting : meetingList) {
            if(lastFinish > meeting[0]){
                continue;
            }

            lastFinish = meeting[1];
            answer++;
        }

        System.out.println(answer);
    }
}
