package baekjoon.silver._1260;

import java.io.*;
import java.util.*;

public class Main {
    /*
    DFS와 BFS
    시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
    2 초	      128 MB	335211	134897	79628	38.774%
    문제
    그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
    단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다.
    정점 번호는 1번부터 N번까지이다.

    입력
    첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다.
    다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다.
    입력으로 주어지는 간선은 양방향이다.

    출력
    첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.
    */

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/baekjoon/silver/_1260/input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        class Graph {

            Node[] nodes;

            static class Node implements Comparable<Node>{
                int data;
                boolean marked;
                LinkedList<Node> adj;

                public Node(int data) {
                    this.data = data;
                    this.marked = false;
                    this.adj = new LinkedList<>();
                }

                @Override
                public String toString() {
                    return String.valueOf(data);
                }


                @Override
                public int compareTo(Node o) {
                    return data-o.data;
                }
            }

            Graph(int size) {
                this.nodes = new Node[size + 1];
                for (int i = 1; i < size + 1; i++) {
                    nodes[i] = new Node(i);
                }
            }

            void addEdge(int i1, int i2) {
                Node n1 = nodes[i1];
                Node n2 = nodes[i2];
                if (!n1.adj.contains(n2)) {
                    n1.adj.add(n2);
                }
                if (!n2.adj.contains(n1)) {
                    n2.adj.add(n1);
                }
//                System.out.println("edge 추가: " + i1 + ", "+ i2);
            }

            List<Integer> dfs(int index) {
                Node root = nodes[index];
                Stack<Node> stack = new Stack<>();
                stack.push(root);
                root.marked = true;
                List<Integer> result = new ArrayList<>();
                while (!stack.isEmpty()) {
                    Node node = stack.pop();
                    Collections.sort(node.adj);
                    for (Node n : node.adj) {
                        if (!n.marked) {
                            n.marked = true;
                            stack.push(n);
                        }
                    }
                    result.add(node.data);
                }
                return result;
            }

            void dfsRecursive(Node node, List<Integer> result) {
                node.marked = true;
                result.add(node.data);

                Collections.sort(node.adj);
                for (Node neighbor : node.adj) {
                    if (!neighbor.marked) {
                        dfsRecursive(neighbor, result);
                    }
                }
            }

            List<Integer> bfs(int index) {
                Node root = nodes[index];
                ArrayList<Integer> bfsResult = new ArrayList<>();
                Queue<Node> queue = new LinkedList<>();
                queue.offer(root);
                root.marked = true;

                while (!queue.isEmpty()) {
                    Node node = queue.poll();
                    bfsResult.add(node.data);

                    Collections.sort(node.adj);
                    for (Node n : node.adj) {
                        if (!n.marked) {
                            n.marked = true;
                            queue.offer(n);
                        }
                    }
                }
                return bfsResult;
            }
        }



        // 1: size 2: iteration 3: startIdx
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int iter = Integer.parseInt(st.nextToken());
        int startIdx = Integer.parseInt(st.nextToken());

        Graph graph = new Graph(size);
        for (int i = 0; i < iter; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int i1 = Integer.parseInt(st1.nextToken());
            int i2 = Integer.parseInt(st1.nextToken());
            graph.addEdge(i1, i2);
        }


//        List<Integer> dfsResult = graph.dfs(startIdx);
        ArrayList<Integer> dfsResult = new ArrayList<>();
        graph.dfsRecursive(graph.nodes[startIdx], dfsResult);

        for (int i = 1; i <= size; i++) {
            graph.nodes[i].marked = false;
        }

        List<Integer> bfsResult = graph.bfs(startIdx);
        System.out.println(dfsResult);
        System.out.println(bfsResult);
    }
}
