package Do_It.탐색.BFS;

import java.io.*;
import java.util.*;

/**
 * p. 174
 * 문제 028. 트리의 지름 구하기
 * 백준 1167 [트리의 지름]
 */
public class P1167_트리의_지름 {
    static boolean[] visited;
    static long[] distance;
    static ArrayList<Edge>[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 노드 개수
        arr = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        distance = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            while (true) {
                int node = Integer.parseInt(st.nextToken());
                if (node == -1) {
                    break;
                }
                int distance = Integer.parseInt(st.nextToken());
                arr[idx].add(new Edge(node, distance));
            }
        }
        br.close();

        bfs(1);

        int max = 1;
        for (int i = 2; i <= n; i++) {
            if (distance[max] < distance[i]) {
                max = i;
            }
        }
        // 다시 초기화
        visited = new boolean[n + 1];
        distance = new long[n + 1];

        bfs(max);
        Arrays.sort(distance); // 오름차순 정렬
        System.out.println(distance[n]);
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int currentNode = q.poll();
            for (Edge edge : arr[currentNode]) {
                int nextNode = edge.getNode();
                int nextDistance = edge.getDistance();
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    q.add(nextNode);
                    distance[nextNode] = distance[currentNode] + nextDistance;
                }
            }
        }
    }
}

class Edge {
    private int node;
    private int distance;

    public Edge(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }

    public int getNode() {
        return node;
    }

    public int getDistance() {
        return distance;
    }
}
