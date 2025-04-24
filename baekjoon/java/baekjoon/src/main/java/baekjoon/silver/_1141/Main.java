package baekjoon.silver._1141;
import java.util.*;
import java.io.*;

public class Main {

    /* https://www.acmicpc.net/problem/1141

    시간 제한	메모리 제한
    2 초	    128 MB

    문제
    접두사X 집합이란 집합의 어떤 한 단어가, 다른 단어의 접두어가 되지 않는 집합이다.
    예를 들어, {hello}, {hello, goodbye, giant, hi}, 비어있는 집합은 모두 접두사X 집합이다.
    하지만, {hello, hell}, {giant, gig, g}는 접두사X 집합이 아니다.

    단어 N개로 이루어진 집합이 주어질 때, 접두사X 집합인 부분집합의 최대 크기를 출력하시오.

    입력
    첫째 줄에 단어의 개수 N이 주어진다.
    N은 50보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에는 단어가 주어진다.
    단어는 알파벳 소문자로만 이루어져 있고, 길이는 최대 50이다. 집합에는 같은 단어가 두 번 이상 있을 수 있다.

    출력
    첫째 줄에 문제의 정답을 출력한다.
    */

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/main/java/baekjoon/silver/_1141/input"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String firstLine = br.readLine();
        int count = Integer.parseInt(firstLine);

        List<String> dic = new ArrayList<>();
        List<String> answer = new ArrayList<>();

        for(int i=0; i<count; i++){
            dic.add(br.readLine());
        }
        // 긴 순서대로 answer 배열에 집어넣고
        // 들어갈때 contains로 검사한다 -> true라면 불가능/ false라면 가능

        dic.sort(Comparator.comparing(String::length).reversed());
        answer.add(dic.get(0));
        for(int j=1; j<dic.size(); j++) {
            String item = dic.get(j);
            boolean isContain = false;
            answer.add(item);

            for(int i=0; i<answer.size()-1; i++){
                if(answer.get(i).startsWith(item)){
                    isContain = true;
                }
            }
            if(isContain){
                answer.remove(item);
            }
        }
        bw.write(String.valueOf(answer.size()));
        bw.newLine();
        bw.flush();
    }
}
