package Do_It.탐색.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * p. 157
 * 문제 025. 친구 관계 파악하기
 * 백준 13023 [ABCDE]
 */
public class P13023_ABCDE {
    static boolean[] visited;
    static ArrayList<Integer>[] arr;
    static boolean arrive;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = getInteger(st);
        int m = getInteger(st);

        // init
        arrive = false;
        arr = new ArrayList[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
        }

        // 노드 init
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = getInteger(st);
            int node2 = getInteger(st);
            arr[node1].add(node2);
            arr[node2].add(node1);
        }

        // dfs
        for (int i = 0; i < n; i++) {
            dfs(i, 1);
            if (arrive) {
                break;
            }
        }

        if (arrive) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }

    private static void dfs(int now, int depth) {
        if (arrive || depth == 5) {
            arrive = true;
            return;
        }

        visited[now] = true;
        for (int i : arr[now]) {
            if (!visited[i]) {
                dfs(i, depth + 1);
            }
        }
        visited[now] = false;
    }

    private static int getInteger(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }
}
