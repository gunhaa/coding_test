package baekjoon.defaultIO;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("path"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {

            // 나누지 않을 경우
            String line = br.readLine();
            // 토큰으로 나눌 경우 (split " ")
            StringTokenizer st = new StringTokenizer(br.readLine());
            bw.write((String.valueOf("result")));
            bw.write("\n");
            // or
            bw.newLine();
            bw.flush();
        }
    }

}
