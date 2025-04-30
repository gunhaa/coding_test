package baekjoon.platinum._1047;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /* https://www.acmicpc.net/problem/1047
    울타리
    시간 제한	메모리 제한
         2 초	128 MB
    문제
    은진이의 집 앞에는 많은 나무가 심어져 있는 아름다운 정원이 있다.

    최근에 새로운 법이 제정되었다. 이 법은 모든 정원은 울타리로 둘러쌓여야 한다는 법이다.
    울타리는 반드시 변이 축에 평행한 직사각형 모양이어야 한다. 모든 나무는 울타리의 안에 있거나, 울타리의 경계에 접해 있어야 한다.

    이러한 새로운 법을 듣게된 은진이는 마음이 아팠다.
    안타깝게도, 은진이는 울타리를 만들 나무를 살 돈이 없다. 따라서, 은진이는 정원에 심어져있는 나무를 조금 잘라 울타리를 만드는 방법밖에 없다.

    각 나무가 심어져 있는 (x, y)위치와, 나무를 베었을 때, 만들 수 있는 울타리의 길이가 주어진다.

    은진이는 나무를 매우 사랑하기 때문에, 나무를 되도록이면 조금만 나무를 벌목하려고 한다.
     은진이가 새로운 법을 지키기 위해 잘라야 하는 나무 개수의 최솟값을 구하는 프로그램을 작성하시오.

    가로 세로의 길이 중 하나가 0이어도 직사각형이며, 모두 0이어도 직사각형이다.

    입력
    첫째 줄에 N이 주어진다. N은 2보다 크거나 같고, 40보다 작거나 같은 자연수이다.
    둘째 줄부터 N개의 줄에 각 나무가 심어져 있는 위치와 그 나무로 만들 수 있는 울타리의 길이가 순서대로 주어진다.
    모든 값은 1,000,000보다 작거나 같은 자연수이다. 모든 나무의 x좌표는 같지 않고, y좌표도 같지 않다.

    출력
    첫째 줄에 문제의 정답을 출력한다.
    */

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/platinum/_1047/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Wood> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int woods = Integer.parseInt(st.nextToken());
            list.add(new Wood(x, y, woods));
        }

        // 모든 경우의 직사각형 좌표를 구한다
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                // x,y값에 따라 직사각형의 필요 나무를 구한다
                Wood woodI = list.get(i);
                Wood woodJ = list.get(j);

                // 직사각형의 x, y 범위 계산
                int minX = Math.min(woodI.x, woodJ.x);
                int maxX = Math.max(woodI.x, woodJ.x);
                int minY = Math.min(woodI.y, woodJ.y);
                int maxY = Math.max(woodI.y, woodJ.y);

                // 직사각형의 울타리 길이 계산 (2*(가로 + 세로))
                int needWoods = 2 * (maxX - minX + maxY - minY);

                // 외부 나무를 잘라내기 위해 필요한 나무 개수 계산
                if(needWoods != 0 ){
                    outsideWoodsClear(list, needWoods, minX, maxX, minY, maxY);
                }
            }
        }

        System.out.println(min);

    }

    static int min = Integer.MAX_VALUE;

    static void outsideWoodsClear(List<Wood> list, int needWoods, int x1, int x2, int y1, int y2) {

        List<Wood> outsideWoods = new ArrayList<>();

        for (Wood wood : list) {
            // 직사각형 외부의 나무라면 리스트에 추가
            if (wood.x < x1 || wood.x > x2 || wood.y < y1 || wood.y > y2) {
                outsideWoods.add(wood);
            }
        }
        // tempWoods를 얻는 나무 수에 따라 내림차순 정렬 후 iter하여 needWoods를 만족시키는 지점을 찾고, 없다면 넘긴다
        Collections.sort(outsideWoods);

        int acc = 0;
        int count = 0;
        for (Wood wood : outsideWoods) {
            acc += wood.getWoods;
            count++;
        }

        if(acc >= needWoods){
            min = Math.min(min, count);
        }
    }


    static class Wood implements Comparable<Wood>{
        int x;
        int y;
        int getWoods;

        Wood(int x, int y, int getWoods) {
            this.x = x;
            this.y = y;
            this.getWoods = getWoods;
        }

        @Override
        public int compareTo(Wood o) {
            return Integer.compare(o.getWoods, this.getWoods);
        }
    }

}
