package baekjoon.silver._2108;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    /* https://www.acmicpc.net/problem/2108
    통계학
    시간 제한	메모리 제한
    2 초	    256 MB
    문제
    수를 처리하는 것은 통계학에서 상당히 중요한 일이다. 통계학에서 N개의 수를 대표하는 기본 통계값에는 다음과 같은 것들이 있다. 단, N은 홀수라고 가정하자.

    산술평균 : N개의 수들의 합을 N으로 나눈 값
    중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
    최빈값 : N개의 수들 중 가장 많이 나타나는 값
    범위 : N개의 수들 중 최댓값과 최솟값의 차이
    N개의 수가 주어졌을 때, 네 가지 기본 통계값을 구하는 프로그램을 작성하시오.

    입력
    첫째 줄에 수의 개수 N(1 ≤ N ≤ 500,000)이 주어진다. 단, N은 홀수이다. 그 다음 N개의 줄에는 정수들이 주어진다. 입력되는 정수의 절댓값은 4,000을 넘지 않는다.

    출력
    첫째 줄에는 산술평균을 출력한다. 소수점 이하 첫째 자리에서 반올림한 값을 출력한다.

    둘째 줄에는 중앙값을 출력한다.

    셋째 줄에는 최빈값을 출력한다. 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.

    넷째 줄에는 범위를 출력한다.
    */

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/silver/_2108/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();

        for(int i=0; i<count; i++){
            list.add(Integer.parseInt(br.readLine()));
        }

        list.sort(Comparator.naturalOrder());
        System.out.println(Calculator.avg(list));
        System.out.println(Calculator.middleValue(list));
        System.out.println(Calculator.frequency(list));
        System.out.println(Calculator.difference(list));
    }

    static class Calculator {
        static int avg(List<Integer> list){
            int sum = 0;
            for(Integer d : list) {
                sum+= d;
            }

            return (int) Math.round((double) sum / list.size());
        }

        static int middleValue(List<Integer> list){
            int size = list.size();
            return list.get(size/2);
        }

        static int frequency(List<Integer> list){
            Set<Integer> listSet = Set.copyOf(list);
            if(listSet.size() == list.size()){
                if(list.size() == 1){
                    return list.get(0);
                }
                return list.get(1);
            } else {
                Map<Integer, Integer> map = new HashMap<>();
                for(Integer i : list){
                    if(!map.containsKey(i)){
                        map.put(i, 1);
                    } else {
                        Integer value = map.get(i);
                        map.put(i, value+1);
                    }
                }

                int max = 1;
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    if(max < entry.getValue()){
                        max = entry.getValue();
                    }
                }

                Set<Integer> answerSet = new HashSet<>();
                int key = 0;
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    if(entry.getValue() == max) {
                        key = entry.getKey();
                        answerSet.add(key);
                    }
                }

                if(answerSet.size() == 1){
                    return key;
                } else {
                    if(list.size() == 1){
                        return list.get(0);
                    }
                    Integer result = answerSet.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList()).get(1);

                    return result;
                }
            }
        }

        static int difference(List<Integer> list){
            int min = list.get(0);
            int max = list.get(list.size()-1);
            return Math.abs(max-min);
        }
    }
}
