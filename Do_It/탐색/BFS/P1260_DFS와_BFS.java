package Do_It.탐색.BFS;

import java.util.*;
import java.io.*;

/**
 * p. 164
 * 문제 026. DFS와 BFS 프로그램
 * 백준 1260 [DFS와 BFS]
 */
public class P1260_DFS와_BFS {
    static ArrayList<Integer>[] arr;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = getInteger(st);
        int m = getInteger(st);
        int start = getInteger(st);

        arr = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = getInteger(st);
            int node2 = getInteger(st);

            arr[node1].add(node2);
            arr[node2].add(node1);
        }
        br.close();

        // 오름차순 정렬
        for (int i = 1; i <= n; i++) {
            ArrayList<Integer> list = arr[i];
            Collections.sort(list);
        }

        // DFS
        dfs(start);

        // 초기화
        visited = new boolean[n + 1];

        bw.write("\n");

        // BFS
        bfs(start);

        bw.flush();
        bw.close();
    }

    private static void dfs(int start) throws IOException {
        if (visited[start]) {
            return;
        }
        visited[start] = true;
        bw.write(start + " ");
        ArrayList<Integer> list = arr[start];
        for (int item : list) {
            dfs(item);
        }
    }

    private static void bfs(int start) throws IOException {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            bw.write(node + " ");
            ArrayList<Integer> list = arr[node];
            for (int item : list) {
                if (visited[item]) continue;
                q.add(item);
                visited[item] = true;
            }
        }
    }

    private static int getInteger(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }
}
