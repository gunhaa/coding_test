package baekjoon.gold._5430;
import java.io.*;
import java.util.*;

public class Main {
    /*
    AC 다국어
    시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
    1 초	256 MB	179792	42217	29802	20.892%
    문제
    선영이는 주말에 할 일이 없어서 새로운 언어 AC를 만들었다. AC는 정수 배열에 연산을 하기 위해 만든 언어이다.
    이 언어에는 두 가지 함수 R(뒤집기)과 D(버리기)가 있다.

    함수 R은 배열에 있는 수의 순서를 뒤집는 함수이고, D는 첫 번째 수를 버리는 함수이다. 배열이 비어있는데 D를 사용한 경우에는 에러가 발생한다.

    함수는 조합해서 한 번에 사용할 수 있다. 예를 들어, "AB"는 A를 수행한 다음에 바로 이어서 B를 수행하는 함수이다.
    예를 들어, "RDD"는 배열을 뒤집은 다음 처음 두 수를 버리는 함수이다.

    배열의 초기값과 수행할 함수가 주어졌을 때, 최종 결과를 구하는 프로그램을 작성하시오.

    입력
    첫째 줄에 테스트 케이스의 개수 T가 주어진다. T는 최대 100이다.

    각 테스트 케이스의 첫째 줄에는 수행할 함수 p가 주어진다. p의 길이는 1보다 크거나 같고, 100,000보다 작거나 같다.

    다음 줄에는 배열에 들어있는 수의 개수 n이 주어진다. (0 ≤ n ≤ 100,000)

    다음 줄에는 [x1,...,xn]과 같은 형태로 배열에 들어있는 정수가 주어진다. (1 ≤ xi ≤ 100)

    전체 테스트 케이스에 주어지는 p의 길이의 합과 n의 합은 70만을 넘지 않는다.

    출력
    각 테스트 케이스에 대해서, 입력으로 주어진 정수 배열에 함수를 수행한 결과를 출력한다. 만약, 에러가 발생한 경우에는 error를 출력한다.
    */

    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/gold/_5430/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        Ac ac;
        for (int i = 0; i < testCase; i++) {
            String operation = br.readLine();
            int len = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String result = line.substring(1, line.length() - 1);
            String[] tempArr = result.split(",");
            ac = new Ac(tempArr);

            for(char c : operation.toCharArray()){
                if(c == 'R') {
                    //logic
                    ac.reverse();
                    continue;
                }
                if( c== 'D') {
                    //logic
                    boolean isDeleted = ac.delete();
                    if(!isDeleted) {
                        break;
                    }
                }
            }
            ac.print();
            bw.flush();
        }
        bw.close();
    }

    static class Ac {
        int len;
        LinkedList<Integer> list;
        boolean isReversed;

        Ac(String[] tempArr) {
            LinkedList<Integer> list = new LinkedList<>();
            for(String s: tempArr) {
                if(s.isEmpty()) {
                    continue;
                }
                list.add(Integer.valueOf(s));
            }
            this.list = list;
            this.len = list.size();
            this.isReversed = false;
        }

        void reverse() {
            if(this.isReversed) {
                this.isReversed = false;
            } else {
                this.isReversed = true;
            }
        }

        boolean delete() {
            if(this.len == 0) {
                this.len = -1;
                return false;
            }

            if(this.isReversed) {
                this.list.pollLast();
            } else {
                this.list.pollFirst();
            }
            this.len -= 1;
            return true;
        }

        void print() throws IOException {
            if(len == -1) {
                bw.write("error\n");
                return;
            }
            printList();
        }

        private void printList() throws IOException {
            bw.write("[");

            int iter = this.list.size();

            if(this.isReversed) {
                for(int i=0; i<iter; i++) {
                    if(i == (iter-1)) {
                        bw.write(String.valueOf(this.list.pollLast()));
                        continue;
                    }
                    bw.write(String.valueOf(this.list.pollLast()+","));
                }
            } else {
                for(int i=0; i<iter; i++) {
                    if(i == (iter-1)) {
                        bw.write(String.valueOf(this.list.pollFirst()));
                        continue;
                    }
                    bw.write(String.valueOf(this.list.pollFirst()+","));
                }
            }
            bw.write("]\n");
        }
    }
}
