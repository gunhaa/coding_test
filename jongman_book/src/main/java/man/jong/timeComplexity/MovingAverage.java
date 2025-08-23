package man.jong.timeComplexity;

import java.util.ArrayList;
import java.util.List;

public class MovingAverage {

    public static void main(String[] args) {
        /*
        선형 시간 알고리즘은 대개 우리가 찾을 수 있는 알고리즘 중 가장 좋은 알고리즘인 경우가 많다
        주어진 입력을 한 번씩 쳐다보기라도 하려면 선형 시간이 걸릴 수 밖에 없다
        선형 시간 이하는 log N 알고리즘이 있으며, 가장 대표적인 것이 binary Search 알고리즘 이다
        즉,
        인텔 i7 920 , g++ 4.4.3 , 우분투 리눅스 10.04
        O(N^3) = 2560 입력까지 1초안에 풀 수 있다
        O(N^2) = 40960 입력까지 1초 안에 풀 수 있다
        O(NlogN) = 2천만인 입력까지 1초안에 풀 수 있다
        O(N) 1억 6천만인 입력까지 1초안에 풀 수 있다
         */
    }

    /*
    N개의 측정치가 주어질 때 매달 M달 간의 이동 평균을 계산하는 프로그램
    시간 복잡도 => M*(N-M+1);
    */
    static List<Double> movingAverageV1(List<Double> A, int M) {
        List<Double> ret = new ArrayList<>();
        int N = A.size();
        for (int i = M - 1; i < N; i++) {
            double partialSum = 0;
            for (int j = 0; j < M; j++) {
                partialSum += A.get(i - j);
            }
            ret.add(partialSum / M);
        }
        return ret;
    }

    /* 시간 복잡도 어떻게 선형으로 개선할 수 있을까?

     */
    static List<Double> movingAverageV2(List<Double> A, int M) {
        List<Double> ret = new ArrayList<>();
        int N = A.size();
        double partialSum = 0;
        for (int i = 0; i < M - 1; i++) {
            partialSum += A.get(i);
        }
        for (int i = M-1; i < N; i++) {
            partialSum += A.get(i);
            ret.add(partialSum / M);
            partialSum -= A.get(i-M+1);
        }
        return ret;
    }
}
