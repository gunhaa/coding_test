package baekjoon.gold._7662;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class MainV2 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/gold/_7662/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            int operation = Integer.parseInt(br.readLine());
            for (int j = 0; j < operation; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char operand = st.nextToken().charAt(0);
                int arg = Integer.parseInt(st.nextToken());

                if(operand == 'I') {
                    tm.put(arg, tm.getOrDefault(arg, 0) + 1);
                    continue;
                }

                if(operand == 'D') {
                    if(tm.isEmpty()) {
                        continue;
                    }

                    if(arg == 1) {
                        Integer maxKey = tm.lastKey();
                        Integer remain = tm.get(maxKey);
                        if(remain == 1) {
                            tm.remove(maxKey);
                        } else {
                            tm.put(maxKey, remain-1);
                        }
                    } else {
                        Integer minKey = tm.firstKey();
                        Integer remain = tm.get(minKey);
                        if(remain == 1) {
                            tm.remove(minKey);
                        } else {
                            tm.put(minKey, remain-1);
                        }
                    }
                }
            }
            if(tm.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                Integer min = tm.firstKey();
                Integer max = tm.lastKey();
                System.out.println(max + " " + min);
                tm.clear();
            }
        }
    }
}
