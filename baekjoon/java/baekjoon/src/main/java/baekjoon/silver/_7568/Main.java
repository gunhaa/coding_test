package baekjoon.silver._7568;

import java.util.*;
import java.io.*;

public class Main {
    /* s5
    덩치
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	128 MB	118088	66389	56095	56.511%
문제
우리는 사람의 덩치를 키와 몸무게, 이 두 개의 값으로 표현하여 그 등수를 매겨보려고 한다. 어떤 사람의 몸무게가 x kg이고 키가 y cm라면 이 사람의 덩치는 (x, y)로 표시된다.
두 사람 A 와 B의 덩치가 각각 (x, y), (p, q)라고 할 때 x > p 그리고 y > q 이라면 우리는 A의 덩치가 B의 덩치보다 "더 크다"고 말한다.
예를 들어 어떤 A, B 두 사람의 덩치가 각각 (56, 177), (45, 165) 라고 한다면 A의 덩치가 B보다 큰 셈이 된다.
그런데 서로 다른 덩치끼리 크기를 정할 수 없는 경우도 있다.
예를 들어 두 사람 C와 D의 덩치가 각각 (45, 181), (55, 173)이라면 몸무게는 D가 C보다 더 무겁고, 키는 C가 더 크므로, "덩치"로만 볼 때 C와 D는 누구도 상대방보다 더 크다고 말할 수 없다.

N명의 집단에서 각 사람의 덩치 등수는 자신보다 더 "큰 덩치"의 사람의 수로 정해진다.
만일 자신보다 더 큰 덩치의 사람이 k명이라면 그 사람의 덩치 등수는 k+1이 된다.
이렇게 등수를 결정하면 같은 덩치 등수를 가진 사람은 여러 명도 가능하다.
아래는 5명으로 이루어진 집단에서 각 사람의 덩치와 그 등수가 표시된 표이다.

이름	(몸무게, 키)	덩치 등수
A	(55, 185)	2
B	(58, 183)	2
C	(88, 186)	1
D	(60, 175)	2
E	(46, 155)	5
위 표에서 C보다 더 큰 덩치의 사람이 없으므로 C는 1등이 된다.
그리고 A, B, D 각각의 덩치보다 큰 사람은 C뿐이므로 이들은 모두 2등이 된다.
그리고 E보다 큰 덩치는 A, B, C, D 이렇게 4명이므로 E의 덩치는 5등이 된다.
위 경우에 3등과 4등은 존재하지 않는다.
여러분은 학생 N명의 몸무게와 키가 담긴 입력을 읽어서 각 사람의 덩치 등수를 계산하여 출력해야 한다.

입력
첫 줄에는 전체 사람의 수 N이 주어진다.
그리고 이어지는 N개의 줄에는 각 사람의 몸무게와 키를 나타내는 양의 정수 x와 y가 하나의 공백을 두고 각각 나타난다.

출력
여러분은 입력에 나열된 사람의 덩치 등수를 구해서 그 순서대로 첫 줄에 출력해야 한다.
단, 각 덩치 등수는 공백문자로 분리되어야 한다.

제한
2 ≤ N ≤ 50
10 ≤ x, y ≤ 200
    */

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/silver/_7568/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Person[] people = new Person[N];
        int[] answer = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            Person p = new Person(weight, height);
            people[i] = p;
        }

        for (int i = 0; i < people.length; i++) {
            int bigger = 0;
            for (int j = 0; j < people.length; j++) {
                if(i != j) {
                    if(people[i].height < people[j].height && people[i].weight < people[j].weight) {
                        bigger++;
                    }
                }
            }
            answer[i] = bigger + 1;
        }

        // 예상 출력 2 2 1 2 5
        StringBuilder sb = new StringBuilder();
        for (int i : answer) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    static class Person {
        int weight;
        int height;

        Person(int w, int h) {
            this.weight = w;
            this.height = h;
        }
    }

//        List<Person> list = new ArrayList<>();
//
//        for (int i = 0; i < N; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int weight = Integer.parseInt(st.nextToken());
//            int height = Integer.parseInt(st.nextToken());
//            list.add(new Person(weight, height, i));
//        }
//
//        // compareTo를 이용해, sort 한 후 이전 값과 비교해 추가검증
//        Collections.sort(list);
//        // 원본 idx와 같은 곳에, 덩치 순위를 넣은 후 출력시키기
//        // Person.idx = 원본 idx
//        int[] answer = new int[list.size()];
//
//        int bulkRate = 0;
//        int prevRate = 0;
//
//        for (int i = 0; i < list.size(); i++) {
//            if(i == 0) {
//                Person p = list.get(i);
//                answer[p.idx] = ++bulkRate;
//                continue;
//            }
//            Person prev = list.get(i - 1);
//            Person cur = list.get(i);
//            // 덩치가 이전보다 확실히 작음
//            if(prev.weight > cur.weight && prev.height > cur.height) {
//                answer[cur.idx] = ++bulkRate + prevRate;
//                prevRate = 0;
//            } else {
//                answer[cur.idx] = bulkRate;
//                prevRate++;
//            }
//        }
//
//        StringBuilder output = new StringBuilder();
//        for (int p : answer) {
//            output.append(p).append(" ");
//        }
//        System.out.println(output.toString());
//    }
//
//    static class Person implements Comparable<Person>{
//        int weight;
//        int height;
//        int idx;
//
//        Person(int w, int h, int i) {
//            this.weight = w;
//            this.height = h;
//            this.idx = i;
//        }
//
//        @Override
//        public int compareTo(Person o){
//            if(this.weight > o.weight && this.height > o.height) {
//                return -1;
//            }
//
//            if(this.weight < o.weight && this.height < o.height) {
//                return 1;
//            }
//
//            return 0;
//        }
//
//        @Override
//        public String toString() {
//            return "this weight: " + weight + ", this height: " + height + ", this idx: " + idx;
//        }
//    }
}
