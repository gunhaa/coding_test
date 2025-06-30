package baekjoon.test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class Test {

    public static void main(String[] args) throws IOException {
        String line = " The first character is a blank\n";
        char c = line.charAt(3);
        System.out.println(c);
        double a = 3;
        double b = 6;
        System.out.println(b / a);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        ListIterator<Integer> iterator = list.listIterator();
        while(iterator.hasNext()) {
            Integer next = iterator.next();
            iterator.set(next+1);
        }
        System.out.println(list);
        String[] result = line.split(" ");

        for (String s : result) {
            System.out.println(s.length());
        }
        System.out.println(Arrays.toString(result));
        System.out.println(result.length);

        System.out.println("-----------------");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = "A";
        Set<Object> objects = new HashSet<>();
        bw.flush();
        bw.close();
    }
}
