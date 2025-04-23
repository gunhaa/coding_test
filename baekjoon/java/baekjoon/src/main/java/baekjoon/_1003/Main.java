package baekjoon._1003;
import java.io.*;
import java.util.Arrays;

public class Main {

    /*
    문제
    다음 소스는 N번째 피보나치 수를 구하는 C++ 함수이다.

    int fibonacci(int n) {
        if (n == 0) {
            printf("0");
            return 0;
        } else if (n == 1) {
            printf("1");
            return 1;
        } else {
            return fibonacci(n‐1) + fibonacci(n‐2);
        }
    }
    fibonacci(3)을 호출하면 다음과 같은 일이 일어난다.

    fibonacci(3)은 fibonacci(2)와 fibonacci(1) (첫 번째 호출)을 호출한다.
    fibonacci(2)는 fibonacci(1) (두 번째 호출)과 fibonacci(0)을 호출한다.
    두 번째 호출한 fibonacci(1)은 1을 출력하고 1을 리턴한다.
    fibonacci(0)은 0을 출력하고, 0을 리턴한다.
    fibonacci(2)는 fibonacci(1)과 fibonacci(0)의 결과를 얻고, 1을 리턴한다.
    첫 번째 호출한 fibonacci(1)은 1을 출력하고, 1을 리턴한다.
    fibonacci(3)은 fibonacci(2)와 fibonacci(1)의 결과를 얻고, 2를 리턴한다.
    1은 2번 출력되고, 0은 1번 출력된다. N이 주어졌을 때, fibonacci(N)을 호출했을 때, 0과 1이 각각 몇 번 출력되는지 구하는 프로그램을 작성하시오.

    입력
    첫째 줄에 테스트 케이스의 개수 T가 주어진다.

    각 테스트 케이스는 한 줄로 이루어져 있고, N이 주어진다. N은 40보다 작거나 같은 자연수 또는 0이다.

    출력
    각 테스트 케이스마다 0이 출력되는 횟수와 1이 출력되는 횟수를 공백으로 구분해서 출력한다.
    */

    public static void main(String[] args) throws IOException{

        System.setIn(new FileInputStream("src/main/java/baekjoon/_1003/input"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;
        while((line = br.readLine()) != null){

            int input = Integer.parseInt(line);
            fibonacci(input);
//            System.out.println(Arrays.toString(cache));

            int[] sums = new int[2];
            Arrays.stream(cache)
                    .forEach(cacheState -> {
                        sums[0] += cacheState.acc0;
                        sums[1] += cacheState.acc1;
                    });
            bw.write(String.valueOf(sums[0]));
            bw.write(" ");
            bw.write(String.valueOf(sums[1]));
            bw.flush();

        }

    }

    private static class CacheState {
        int value;
        int acc0;
        int acc1;

        public CacheState(int value, int acc0, int acc1) {
            this.value = value;
            this.acc0 = acc0;
            this.acc1 = acc1;
        }
    }

    private static CacheState[] cache;

    private static void fibonacci(int i){
        cache = new CacheState[i+1];
        for (int j = 0; j <= i; j++) {
            cache[j] = new CacheState(0, 0, 0);
        }

        cache[0].value = 0;

    }

    private static int fibonacciRecursive(int i){

        if(i == 0){
            cache[i].acc0 += 1;
            return cache[0].value;
        }

        if(i == 1){
            cache[i].acc1 += 1;
            return cache[1].value;
        }

        if(cache[i] != null){
            return cache[i].value;
        }

        cache[i].acc0 += cache[i-1].acc0;
        cache[i].acc1 += cache[i-1].acc1;
        cache[i].value = fibonacciRecursive(i-1) + fibonacciRecursive(i-2);
        return cache[i].value;
    }
}
