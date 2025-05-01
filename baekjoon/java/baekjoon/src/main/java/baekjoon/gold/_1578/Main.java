package baekjoon.gold._1578;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    /* https://www.acmicpc.net/problem/1578
    세계 정복
    시간 제한	메모리 제한
        2 초	128 MB
    문제
    오세준은 세계 정복을 위해 전 세계에 있는 N개의 국가를 정복했다.
    세준이는 N개의 국가에 있는 사람들이 서로 친하지 않음을 깨닫고 세계 정복을 위해서라면 모든 사람들을 서로 친하게 만들어야 한다는 것을 알았다.

    세준이는 전세계의 사람들을 그룹으로 나누려고 한다.
    그룹을 나누는 방법에는 다음과 같은 조건이 있는데, 첫 번째는 그룹에 들어있는 사람의 수는 정확히 K명이어야 한다.
    또, 각 그룹에 있는 사람들은 모두 다른 나라 소속이어야 한다는 것이다.
    세준이는 N개의 국가에 살고 있는 사람의 수가 주어졌을 때, 이 사람들을 최대 몇 개의 그룹으로 나눌 수 있는지 궁금해졌다.
    예를 들어, 중국에 살고 있는 사람이 4명, 캐나다에 살고 있는 사람이 4명, 폴란드, 스웨덴, 미국에 살고 있는 사람이 모두 4명이고,
    K가 4라면, 세준이는 최대 5개의 그룹으로 나눌 수 있다.

    캐나다, 중국, 폴란드, 스웨덴
    캐나다, 중국, 폴란드, 미국
    캐나다, 중국, 스웨덴, 미국
    캐나다, 폴란드, 스웨덴, 미국
    중국, 폴란드, 스웨덴, 미국
    만약 어느 그룹에도 들어가지 않는 사람이 있다면, 세준이는 이 사람들을 과감히 무시한다.

    입력
    첫째 줄에 국가의 수 N과 K가 주어진다. N은 K보다 크거나 같고, 50보다 작거나 같은 자연수이고, K는 20보다 작거나 같은 자연수이다.
    둘째 줄에는 각 나라에 살고 있는 사람의 수가 공백으로 구분해서 차례대로 주어진다. 이 수는 1000000000보다 작거나 같은 자연수이다.

    출력
    첫째 줄에 정답을 출력한다. 정답은 2^63-1보다 작거나 같다.
    */

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/gold/_1578/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int K = Integer.parseInt(st1.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        List<Integer> countryList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int countryNum = Integer.parseInt(st2.nextToken());
            countryList.add(countryNum);
        }

        Collections.sort(countryList);

        // 인구수가 최대 10억, log N 혹은 그 이하의 알고리즘 필요
        // 이진 탐색으로 말이 되는 최대 그룹을 찾는다
        long answer = binarySearch(countryList, K);

        System.out.println(answer);
    }

    static long binarySearch(List<Integer> countryList, int K){

        long left = 1;
        long right = 50000000001L;
        long answer = 0;

        while (left <= right){
            // mid 값은 그룹당 필요한 사람의 숫자
            long mid = (left + right) / 2;

            boolean result = canGroup(countryList, K, mid);
            // 최대값 탐색
            if(result) {
                left = mid + 1;
                // 맞는 위치로 갱신시킨다
                answer = mid;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    static boolean canGroup(List<Integer> countryList, int K, long mid) {
        long peopleCount = 0;
        
        // 각 그룹에서 가능한 숫자를 모두 모은다
        for (Integer i : countryList) {
            long min = Math.min(mid, i);
            peopleCount += min;
        }
        
        // 필요한 사람보다 많은지 판정한다
        if((long) mid *K <= peopleCount){
            return true;
        } else {
            return false;
        }
    }
}
