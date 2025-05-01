package baekjoon.gold._1253;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    /* http://acmicpc.net/problem/1253
    좋다
    시간 제한	메모리 제한
        2 초	256 MB
    문제
    N개의 수 중에서 어떤 수가 다른 수 두 개의 합으로 나타낼 수 있다면 그 수를 “좋다(GOOD)”고 한다.

    N개의 수가 주어지면 그 중에서 좋은 수의 개수는 몇 개인지 출력하라.

    수의 위치가 다르면 값이 같아도 다른 수이다.

    입력
    첫째 줄에는 수의 개수 N(1 ≤ N ≤ 2,000), 두 번째 줄에는 i번째 수를 나타내는 A[i]가 N개 주어진다. (|Ai| ≤ 1,000,000,000, Ai는 정수)

    출력
    좋은 수의 개수를 첫 번째 줄에 출력한다.

    */
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/gold/_1253/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        // 전체 크기 2000
        // left idx, rigth idx를 내려오는 탐색해야함
        // '다른' 이라는 케이스를 생각해야한다
        Arrays.sort(arr);
        for (int i = 0; i < N; i++) {
            if (isGoodNumber(arr, i)) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    static boolean isGoodNumber(int[] arr , int targetIdx) {
        int leftIdx = 0;
        int rightIdx = arr.length-1;

        while (leftIdx < rightIdx) {

            if(leftIdx == targetIdx){
                leftIdx++;
                continue;
            }

            if(rightIdx == targetIdx){
                rightIdx--;
                continue;
            }

            int sum = arr[leftIdx] + arr[rightIdx];
            if (sum == arr[targetIdx]) {
                return true;
            } else if (sum < arr[targetIdx]) {
                leftIdx = leftIdx + 1;
            } else if (sum > arr[targetIdx]) {
                rightIdx = rightIdx - 1;
            }
        }
        return false;
    }
}
