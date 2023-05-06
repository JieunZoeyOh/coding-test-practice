package Do_It.탐색.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * p. 148
 * 문제 023. 연결 요소의 개수 구하기
 * 백준 11724 [연결 요소의 개수]
 * 방향 없는 그래프가 주어졌을 때 연결 요소의 개수를 구하는 프로그램을 작성하시오.
 */
public class P11724_연결_요소의_개수 {
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 노드 개수
        int edge = Integer.parseInt(st.nextToken()); // 에지 개수

        arr = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            arr[node1].add(node2);
            arr[node2].add(node1);
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;
            count++;
            dfs(i);
        }

        System.out.println(count);
    }

    private static void dfs(int i) {
        if (visited[i]) return;

        visited[i] = true;

        for (int item : arr[i]) {
            if (visited[item]) continue;
            dfs(item); // 연결 노드 중 방문하지 않은 노드만 탐색
        }
    }
}
