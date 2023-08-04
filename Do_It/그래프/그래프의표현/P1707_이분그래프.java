package Do_It.그래프.그래프의표현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * p. 269
 * 문제 048. 이분 그래프 판별하기
 * 백준 1707 [이분 그래프]
 */
public class P1707_이분그래프 {

    static List<Integer>[] nodes;
    static boolean isEven;
    static int[] check;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int totalNode = Integer.parseInt(st.nextToken());
            int totalEdge = Integer.parseInt(st.nextToken());
            isEven = true;

            nodes = new ArrayList[totalNode + 1];
            check = new int[totalNode + 1];
            visited = new boolean[totalNode + 1];

            for (int j = 1; j <= totalNode; j++) {
                nodes[j] = new ArrayList<>();
            }

            for (int j = 0; j < totalEdge; j++) {
                st = new StringTokenizer(br.readLine());
                int startNode = Integer.parseInt(st.nextToken());
                int endNode = Integer.parseInt(st.nextToken());
                nodes[startNode].add(endNode);
                nodes[endNode].add(startNode);
            }

            for (int j = 1; j <= totalNode; j++) {
                if (isEven) {
                    dfs(j);
                } else {
                    break;
                }
            }

            System.out.println(isEven ? "YES" : "NO");

        }
    }

    private static void dfs(int node) {
        visited[node] = true;
        for (int nextNode : nodes[node]) {
            if (!visited[nextNode]) {
                check[nextNode] = (check[node] + 1) % 2;
                dfs(nextNode);
            } else if (check[node] == check[nextNode]) {
                isEven = false;
            }
        }
    }
}
