package baekjoon.silver._13335;

import java.util.*;
import java.io.*;

public class Main {
    /* s1
트럭 다국어
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	512 MB	19747	11029	8751	57.207%
문제
강을 가로지르는 하나의 차선으로 된 다리가 하나 있다. 이 다리를 n 개의 트럭이 건너가려고 한다.
트럭의 순서는 바꿀 수 없으며, 트럭의 무게는 서로 같지 않을 수 있다.
다리 위에는 단지 w 대의 트럭만 동시에 올라갈 수 있다.
다리의 길이는 w 단위길이(unit distance)이며, 각 트럭들은 하나의 단위시간(unit time)에 하나의 단위길이만큼만 이동할 수 있다고 가정한다.
동시에 다리 위에 올라가 있는 트럭들의 무게의 합은 다리의 최대하중인 L보다 작거나 같아야 한다.
 참고로, 다리 위에 완전히 올라가지 못한 트럭의 무게는 다리 위의 트럭들의 무게의 합을 계산할 때 포함하지 않는다고 가정한다.

예를 들어, 다리의 길이 w는 2, 다리의 최대하중 L은 10, 다리를 건너려는 트럭이 트럭의 무게가 [7, 4, 5, 6]인 순서대로 다리를 오른쪽에서 왼쪽으로 건넌다고 하자.
이 경우 모든 트럭이 다리를 건너는 최단시간은 아래의 그림에서 보는 것과 같이 8 이다.



Figure 1. 본문의 예에 대해 트럭들이 다리를 건너는 과정.

다리의 길이와 다리의 최대하중, 그리고 다리를 건너려는 트럭들의 무게가 순서대로 주어졌을 때, 모든 트럭이 다리를 건너는 최단시간을 구하는 프로그램을 작성하라.

입력
입력 데이터는 표준입력을 사용한다. 입력은 두 줄로 이루어진다.
입력의 첫 번째 줄에는 세 개의 정수 n (1 ≤ n ≤ 1,000) , w (1 ≤ w ≤ 100) and L (10 ≤ L ≤ 1,000)이 주어지는데,
n은 다리를 건너는 트럭의 수, w는 다리의 길이, 그리고 L은 다리의 최대하중을 나타낸다.
입력의 두 번째 줄에는 n개의 정수 a1, a2, ⋯ , an (1 ≤ ai ≤ 10)가 주어지는데, ai는 i번째 트럭의 무게를 나타낸다.

출력
출력은 표준출력을 사용한다. 모든 트럭들이 다리를 건너는 최단시간을 출력하라.
    */
    // 해당 방법은 업데이트에 심각한 문제가 있다
//    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/main/java/baekjoon/silver/_13335/input"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st1 = new StringTokenizer(br.readLine());
//        Queue<Integer> trucks = new ArrayDeque<>();
//        int n = Integer.parseInt(st1.nextToken());
//        int w = Integer.parseInt(st1.nextToken());
//        int L = Integer.parseInt(st1.nextToken());
//        StringTokenizer st2 = new StringTokenizer(br.readLine());
//        for (int i = 0; i < n; i++) {
//            int truck = Integer.parseInt(st2.nextToken());
//            trucks.add(truck);
//        }
////        System.out.println(trucks);
//        int time = 0;
//        int remainWeight = L;
//        while(!trucks.isEmpty()) {
//            Integer truck = trucks.poll();
//            remainWeight -= truck;
//            // 더 올라갈수있는가?
//            if(!trucks.isEmpty()) {
//                int nextTruck = trucks.peek();
//                while(nextTruck <= remainWeight) {
//                    remainWeight -= nextTruck;
//                    // 제거
//                    trucks.poll();
//                    // 시간 1만큼 추가
//                    time++;
//                    if(trucks.isEmpty()) {
//                        break;
//                    } else {
//                        nextTruck = trucks.peek();
//                    }
//                }
//            }
//            time += w;
//            remainWeight = L;
//        }
//        // 다리에서 최종 트럭이 나가야함
//        time += 1;
//        System.out.println(time);
//    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/silver/_13335/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        LinkedList<Truck> trucks = new LinkedList<>();
        int n = Integer.parseInt(st1.nextToken());
        int w = Integer.parseInt(st1.nextToken());
        int L = Integer.parseInt(st1.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int weight = Integer.parseInt(st2.nextToken());
            trucks.add(new Truck(weight));
        }

        EventQueue eventQueue = new EventQueue(w, L, trucks);

        while(!eventQueue.isEmpty()) {
            eventQueue.nextTick();
        }

        System.out.println(eventQueue.time+1);
    }

    static class EventQueue {
        // 다리 길이
        int bridgeLen;
        // 최대하중
        int L;
        // 남은 하중
        int remainL;
        int time;
        LinkedList<Truck> remainTrucks;
        LinkedList<Truck> movingTrucks;

        EventQueue(int w, int L, LinkedList<Truck> remainTrucks) {
            this.bridgeLen = w;
            this.L = L;
            this.remainL = L;
            this.remainTrucks = remainTrucks;
            this.movingTrucks = new LinkedList<>();
            this.time = 0;
        }

        void nextTick() {
            if(!remainTrucks.isEmpty()) {
                Truck nextTruck = remainTrucks.peek();
                if(remainL >= nextTruck.weight) {
                    this.remainL -= nextTruck.weight;
                    remainTrucks.poll();
                    movingTrucks.add(nextTruck);
                }
            }

            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < movingTrucks.size(); i++) {
                Truck cur = movingTrucks.get(i);
                cur.pos++;
                if(cur.pos >= bridgeLen) {
                    temp.add(i);
                    remainL += cur.weight;
                }
            }

            for (int t : temp) {
                movingTrucks.remove(t);
            }

            this.time++;
        }

        boolean isEmpty() {
            return remainTrucks.isEmpty() && movingTrucks.isEmpty();
        }
    }

    static class Truck {
        int weight;
        // 위치
        int pos;

        Truck(int w) {
            this.weight = w;
            this.pos = 0;
        }
    }
}
