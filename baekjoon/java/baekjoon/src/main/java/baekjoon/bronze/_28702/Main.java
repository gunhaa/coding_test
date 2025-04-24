package baekjoon.bronze._28702;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    /* https://www.acmicpc.net/problem/28702
    FizzBuzz
    시간 제한	메모리 제한
    0.5 초	    1024 MB
    문제
    FizzBuzz 문제는
    i = 1, 2 .. 에 대해 다음 규칙에 따라 문자열을 한 줄에 하나씩 출력하는 문제입니다.

    i가
    3의 배수이면서
    5의 배수이면 “FizzBuzz”를 출력합니다.
    i가
    3의 배수이지만
    5의 배수가 아니면 “Fizz”를 출력합니다.
    i가
    3의 배수가 아니지만
    5의 배수이면 “Buzz”를 출력합니다.
    i가
    3의 배수도 아니고
    5의 배수도 아닌 경우
    i를 그대로 출력합니다.
    FizzBuzz 문제에서 연속으로 출력된 세 개의 문자열이 주어집니다. 이때, 이 세 문자열 다음에 올 문자열은 무엇일까요?

    입력
    FizzBuzz 문제에서 연속으로 출력된 세 개의 문자열이 한 줄에 하나씩 주어집니다. 각 문자열의 길이는
    $8$ 이하입니다. 입력이 항상 FizzBuzz 문제에서 연속으로 출력된 세 개의 문자열에 대응됨이 보장됩니다.

    출력
    연속으로 출력된 세 개의 문자열 다음에 올 문자열을 출력하세요. 여러 문자열이 올 수 있는 경우, 아무거나 하나 출력하세요.
    */

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/main/java/baekjoon/bronze/_28702/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        List<String> list = new ArrayList<>();
        list.add(br.readLine());
        list.add(br.readLine());
        list.add(br.readLine());
        int answer = 0;
        final int targetOffset = 3;

        for(int i=0; i < 3; i++){
            String item = list.get(i);
            boolean isNumber = isNumber(item);
            if(isNumber){
                int number = Integer.parseInt(item);
                int offset = targetOffset-i;
                answer = number+offset;
                break;
            }
        }
        String result = resultParser(answer);

        bw.write(result);
        bw.flush();
    }

    private static boolean isNumber(String s){

        try {
            Integer.parseInt(s);
        }catch(NumberFormatException e){
            return false;
        }
        return true;
    }

    private static String resultParser(int answer){
        if(answer%3 == 0 && answer%5 ==0){
            return "FizzBuzz";
        } else if(answer%3 ==0){
            return "Fizz";
        } else if(answer%5 ==0){
            return "Buzz";
        } else {
            return String.valueOf(answer);
        }
    }
}
