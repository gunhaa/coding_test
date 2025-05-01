package baekjoon.silver._1072;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    /* https://www.acmicpc.net/problem/1072
    게임
    시간 제한	메모리 제한
        2 초	128 MB
    문제
    김형택은 지금 몰래 Spider Solitaire(스파이더 카드놀이)를 하고 있다. 형택이는 이 게임을 이길 때도 있었지만, 질 때도 있었다.
    누군가의 시선이 느껴진 형택이는 게임을 중단하고 코딩을 하기 시작했다.
    의심을 피했다고 생각한 형택이는 다시 게임을 켰다. 그 때 형택이는 잠시 코딩을 하는 사이에 자신의 게임 실력이 눈에 띄게 향상된 것을 알았다.

    이제 형택이는 앞으로의 모든 게임에서 지지 않는다. 하지만, 형택이는 게임 기록을 삭제 할 수 없기 때문에, 자신의 못하던 예전 기록이 현재 자신의 엄청난 실력을 증명하지 못한다고 생각했다.

    게임 기록은 다음과 같이 생겼다.

    게임 횟수 : X
    이긴 게임 : Y (Z%)
    Z는 형택이의 승률이고, 소수점은 버린다. 예를 들어, X=53, Y=47이라면, Z=88이다.
    X와 Y가 주어졌을 때, 형택이가 게임을 최소 몇 번 더 해야 Z가 변하는지 구하는 프로그램을 작성하시오.

    입력
    각 줄에 정수 X와 Y가 주어진다.

    출력
    첫째 줄에 형택이가 게임을 최소 몇 판 더 해야하는지 출력한다. 만약 Z가 절대 변하지 않는다면 -1을 출력한다.

    제한
    1 ≤ X ≤ 1,000,000,000
    0 ≤ Y ≤ X
    */
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/silver/_1072/input"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());
        int Z = (int)((100* Y/X));
        int answer = binarySearch(X, Y, Z);
        System.out.println(answer);
    }

    static int binarySearch(long X, long Y, int Z) {
        int left = 1;
        int right = 1000000001;
        int mid = 1;
        int answer = -1;

        while(left <= right){
            mid = (left + right) / 2;

            // 전체 게임 숫자는 mid이며, 졌다고 표현 가능한 게임은 X(최초 게임횟수)-Y(최초 이긴 게임) 이다
            // 목표승률(target)
            // 현재 검증 중인 승률 -> 이긴 게임 = mid + Y / 전체 게임 = mid + X
            int winRate = (int) (((mid + Y) * 100 / (mid + X)));
            if( winRate > Z){
                right = mid - 1;
                answer = right+1;
            } else {
                left = mid + 1;
                answer = left;
            }
        }

        if(mid == 1000000001){
            return -1;
        }
        // mid는 같은 승률을 유지하는 마지막 값, +1을 하게되면 최초 승률 변화 시점을 가져올 수 있다
        return answer;
    }
}
