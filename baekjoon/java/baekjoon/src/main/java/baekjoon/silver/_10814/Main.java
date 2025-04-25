package baekjoon.silver._10814;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    /* https://www.acmicpc.net/problem/10814
    나이순 정렬
    시간 제한	메모리 제한
        3 초	256 MB
    문제
    온라인 저지에 가입한 사람들의 나이와 이름이 가입한 순서대로 주어진다.
    이때, 회원들을 나이가 증가하는 순으로, 나이가 같으면 먼저 가입한 사람이 앞에 오는 순서로 정렬하는 프로그램을 작성하시오.

    입력
    첫째 줄에 온라인 저지 회원의 수 N이 주어진다. (1 ≤ N ≤ 100,000)

    둘째 줄부터 N개의 줄에는 각 회원의 나이와 이름이 공백으로 구분되어 주어진다.
    나이는 1보다 크거나 같으며, 200보다 작거나 같은 정수이고, 이름은 알파벳 대소문자로 이루어져 있고, 길이가 100보다 작거나 같은 문자열이다. 입력은 가입한 순서로 주어진다.

    출력
    첫째 줄부터 총 N개의 줄에 걸쳐 온라인 저지 회원을 나이 순, 나이가 같으면 가입한 순으로 한 줄에 한 명씩 나이와 이름을 공백으로 구분해 출력한다.
    */
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/silver/_10814/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        class Member{
            String name;
            int age;
            int priority;

            Member(int age,  String name, int priority){
                this.name = name;
                this.age = age;
                this.priority = priority;
            }

            int getAge(){
                return this.age;
            }

            int getPriority(){
                return this.priority;
            }

            String getName(){
                return this.name;
            }

        }

        List<Member> list = new ArrayList<>();
        for(int i=0; i<count; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Member(Integer.parseInt(st.nextToken()), st.nextToken(), i));
        }
        List<Member> sortedList = list.stream().sorted(Comparator.comparing(Member::getAge).thenComparing(Member::getPriority)).collect(Collectors.toList());

        for(Member m : sortedList){
            bw.write(String.valueOf(m.getAge()));
            bw.write(" ");
            bw.write(m.getName());
            bw.newLine();
        }
        bw.flush();

    }
}
