package baekjoon.silver._11725;

import java.util.*;
import java.io.*;

public class Main {
    /* s2
    트리의 부모 찾기
    시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
    1 초	256 MB	109018	50323	35208	43.707%
    문제
    루트 없는 트리가 주어진다. 이때, 트리의 루트를 1이라고 정했을 때, 각 노드의 부모를 구하는 프로그램을 작성하시오.

    입력
    첫째 줄에 노드의 개수 N (2 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N-1개의 줄에 트리 상에서 연결된 두 정점이 주어진다.

    출력
    첫째 줄부터 N-1개의 줄에 각 노드의 부모 노드 번호를 2번 노드부터 순서대로 출력한다.
    */
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] results;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/silver/_11725/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        results = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            addEdge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }


//        results = new int[N+1];
//
//        Node root = new Node(1);
//        for (int i = 0; i < N-1; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            root.addChildren(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
//        }
//        System.out.println(Arrays.toString(results));


        dfs(1, 1);
        System.out.println(Arrays.toString(results));
        for (int i = 2; i < results.length; i++) {
            if(i == results.length - 1) {
                bw.write(results[i]);
                break;
            }
            bw.write(results[i] + "\n");
        }
        bw.flush();
    }

    static void addEdge(int a, int b) {
        graph.get(a).add(b);
        graph.get(b).add(a);
    }

    static void dfs(int depth, int parent) {
        visited[depth] = true;
        results[depth] = parent;

        for (int next : graph.get(depth)) {
            if (!visited[next]) {
                dfs(next, depth);
            }
        }
    }

//    static class Node {
//        int data;
//        List<Node> children;
//        Node(int v) {
//            this.data = v;
//            this.children = new ArrayList<>();
//        }
//
//        void addChildren(int a, int b) {
//
//            if(a == data) {
//                children.add(new Node(b));
//                results[b] = a;
//                return;
//            }
//
//            if(b == data) {
//                children.add(new Node(a));
//                results[a] = b;
//                return;
//            }
//
//            for(Node child : children) {
//                child.addChildren(a, b);
//            }
//
//        }
//    }
}
