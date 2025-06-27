package baekjoon.test;

import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/test/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int iter = Integer.parseInt(br.readLine());
        TreeSet<Integer> ts = new TreeSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<iter; i++) {
            ts.add(Integer.parseInt(st.nextToken()));
        }
        System.out.println(ts.first()+ " " + ts.last());
    }
}