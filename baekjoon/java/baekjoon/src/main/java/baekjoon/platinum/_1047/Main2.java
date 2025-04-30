package baekjoon.platinum._1047;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main2 {

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

        List<Wood> woodList = new ArrayList<>();

        // stdin 나무 리스트 생성
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int woodLength = Integer.parseInt(st.nextToken());
            woodList.add(new Wood(x, y, woodLength));
        }

        List<Wood> insideWoodList = new ArrayList<>();
        List<Wood> outsideWoodList = new ArrayList<>();

        // 모든 사각형의 경우의 수를 구한다(N=40)
        for (int i = 0; i < woodList.size(); i++) {
            for (int j = i; j < woodList.size(); j++) {
                for (int k = 0; k < woodList.size(); k++) {
                    for (int l = k; l < woodList.size(); l++) {
                        insideWoodList.clear();
                        outsideWoodList.clear();

                        int x1 = woodList.get(i).x;
                        int x2 = woodList.get(j).x;
                        int y1 = woodList.get(k).y;
                        int y2 = woodList.get(l).y;

                        int minX = Math.min(x1,x2);
                        int maxX = Math.max(x1,x2);
                        int minY = Math.min(y1,y2);
                        int maxY = Math.max(y1,y2);

                        // 울타리의 필요 나무 갯수를 구한다
                        int needWoods = ((maxX - minX) + (maxY - minY)) * 2;

                        // 바깥 나무들의 위치를 구한다
                        for (int m = 0; m < woodList.size(); m++) {
                            Wood wood = woodList.get(m);
                            if (wood.x < minX || wood.x > maxX || wood.y < minY || wood.y > maxY) {
                                outsideWoodList.add(wood);
                            } else {
                                insideWoodList.add(wood);
                            }
                        }

                        // 외부의 나무는 반드시 다 소모한다
                        int count = 0;
                        int acc = 0;
                        for (Wood wood : outsideWoodList) {
                            count++;
                            acc += wood.length;
                        }
                        
                        if(acc >= needWoods){
                            // 최소값 갱신
                            min = Math.min(min, count);
                            continue;
                        }
                        // 내림차순 정렬
                        Collections.sort(insideWoodList);
                        System.out.println(insideWoodList);
                        // 안됬다면 추가 진행
                        for (int m = 0; m < insideWoodList.size(); m++) {
                            Wood wood = insideWoodList.get(m);
                            count++;
                            acc += wood.length;
                            if(acc >= needWoods){
                                // 최소값 갱신
                                min = Math.min(min, count);
                                break;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(min);
    }

    static int min = Integer.MAX_VALUE;

    static class Wood implements Comparable<Wood>{
        int x;
        int y;
        int length;

        Wood(int x, int y, int getWoods) {
            this.x = x;
            this.y = y;
            this.length = getWoods;
        }

        @Override
        public int compareTo(Wood o) {
            return Integer.compare(o.length, this.length);
        }
    }
}
