package baekjoon.silver._9012;

import java.io.*;
import java.util.Stack;

public class Main {
    /*
    괄호 다국어
    시간 제한	메모리 제한
        1 초	128 MB
    문제
    괄호 문자열(Parenthesis String, PS)은 두 개의 괄호 기호인 ‘(’ 와 ‘)’ 만으로 구성되어 있는 문자열이다.
    그 중에서 괄호의 모양이 바르게 구성된 문자열을 올바른 괄호 문자열(Valid PS, VPS)이라고 부른다. 한 쌍의 괄호 기호로 된 “( )” 문자열은 기본 VPS 이라고 부른다.
    만일 x 가 VPS 라면 이것을 하나의 괄호에 넣은 새로운 문자열 “(x)”도 VPS 가 된다. 그리고 두 VPS x 와 y를 접합(concatenation)시킨 새로운 문자열 xy도 VPS 가 된다.
    예를 들어 “(())()”와 “((()))” 는 VPS 이지만 “(()(”, “(())()))” , 그리고 “(()” 는 모두 VPS 가 아닌 문자열이다.

    여러분은 입력으로 주어진 괄호 문자열이 VPS 인지 아닌지를 판단해서 그 결과를 YES 와 NO 로 나타내어야 한다.

    입력
    입력 데이터는 표준 입력을 사용한다. 입력은 T개의 테스트 데이터로 주어진다. 입력의 첫 번째 줄에는 입력 데이터의 수를 나타내는 정수 T가 주어진다.
   각 테스트 데이터의 첫째 줄에는 괄호 문자열이 한 줄에 주어진다. 하나의 괄호 문자열의 길이는 2 이상 50 이하이다.

    출력
    출력은 표준 출력을 사용한다. 만일 입력 괄호 문자열이 올바른 괄호 문자열(VPS)이면 “YES”, 아니면 “NO”를 한 줄에 하나씩 차례대로 출력해야 한다.
    */

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/silver/_9012/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        Stack<String> stack = new Stack<>();
        Stack<String> tempStack = new Stack<>();
        StringBuilder result = new StringBuilder();
        for(int i=0; i<count; i++){
            String[] lineStrings = br.readLine().split("");
            for (String s : lineStrings){
                stack.push(s);
            }

            int size = stack.size();
            for(int j =0; j< size; j++){
                String popItem = stack.pop();
                if(popItem.equals(")")){
                    tempStack.push(popItem);
                } else {
                    if(!tempStack.isEmpty()){
                        tempStack.pop();

                        if(!popItem.equals("(")){
                            result.append("NO");
                            break;
                        }

                    } else {
                        result.append("NO");
                        break;
                    }
                }
            }

            if(result.length() == 0 && stack.isEmpty() && tempStack.isEmpty()){
                result.append("YES");
            } else {
                if(result.length() == 0){
                    result.append("NO");
                }
            }


            bw.write(result.toString());
            bw.newLine();
            bw.flush();
            result.setLength(0);
            tempStack.clear();
            stack.clear();
        }
    }
}
